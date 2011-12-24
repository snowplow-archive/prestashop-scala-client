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
package co.orderly.prestasac.representations

// Java
import java.util.{Date => JDate}
import java.lang.{Float => JFloat} // TODO: check we need this

// Scala
import scala.reflect.BeanProperty

// JAXB
import javax.xml.bind.annotation._

// Narcolepsy
import orderly.narcolepsy.Representation

// Prestasac
import co.orderly.prestasac.representations.shared._

/**
 * Product representation holds the information pertaining to a
 * product in the PrestaShop catalogue.
 *
 * This is a placeholder for now.
 */
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
class Product extends Representation {


}
