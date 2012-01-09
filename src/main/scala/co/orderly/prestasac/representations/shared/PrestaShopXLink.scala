/*
 * Copyright (c) 2011 Orderly Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package co.orderly.prestasac.representations.shared

// Java
import java.lang.{Long => JLong}

// Scala
import scala.reflect.BeanProperty

// JAXB
import javax.xml.bind.annotation._

// Narcolepsy
import co.orderly.narcolepsy.Representation

@XmlAccessorType(XmlAccessType.FIELD)
class PrestaShopXLink extends Representation {

  @XmlAttribute(namespace = "http://www.w3.org/1999/xlink") // Href is an xlink: attribute
  @BeanProperty
  var href: String = _

  @XmlValue
  @BeanProperty
  var id: JLong = _
}
