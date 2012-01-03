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
import java.lang.{Long => JLong}
import java.lang.{Integer => JInteger}

// Scala
import scala.reflect.BeanProperty

// JAXB
import javax.xml.bind.annotation._

// MOXy
import org.eclipse.persistence.oxm.annotations.XmlNameTransformer

// Narcolepsy
import co.orderly.narcolepsy._
import marshallers.jaxb.moxy.CamelCase2Underscore

// Prestasac
import shared.PrestaShopIdentity

/**
 * The State representation holds the information pertaining to a
 * state (aka region or county) in PrestaShop.
 *
 * A typical representation looks like this:
 *
 * <prestashop xmlns:xlink="http://www.w3.org/1999/xlink">
 *   <state>
 *     <id><![CDATA[15]]></id>
 *     <id_zone xlink:href="http://www.psychicbazaar.com/api/zones/2"><![CDATA[2]]></id_zone>
 *     <id_country xlink:href="http://www.psychicbazaar.com/api/countries/21"><![CDATA[21]]></id_country>
 *     <iso_code><![CDATA[IA]]></iso_code>
 *     <name><![CDATA[Iowa]]></name>
 *     <active><![CDATA[1]]></active>
 *   </state>
 * </prestashop>
 */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
class State extends Representation {

  @XmlElement(required = true)
  @BeanProperty
  var state: StateElement = _
}

/**
 * The StateElement holds the core fields for the state.
 */
@XmlAccessorType(XmlAccessType.FIELD)
class StateElement extends PrestaShopIdentity {

  // -------------------------------------------------------------------------------------------------------------------
  // XLinks into other resources
  // -------------------------------------------------------------------------------------------------------------------

  // TODO: retrieve the xlink:href as well
  @BeanProperty
  var idZone: JLong = _ // PrestaShopXLink = _

  // TODO: retrieve the xlink:href as well
  @BeanProperty
  var idCountry: JLong = _ // PrestaShopXLink = _

  // -------------------------------------------------------------------------------------------------------------------
  // Resource-specific fields
  // -------------------------------------------------------------------------------------------------------------------

  @BeanProperty
  var isoCode: String = _

  @BeanProperty
  var name: String = _

  @BeanProperty
  var active: JInteger = _
}