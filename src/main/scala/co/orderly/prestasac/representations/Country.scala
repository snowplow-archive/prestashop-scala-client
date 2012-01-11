/*
 * Copyright (c) 2012 Orderly Ltd. All rights reserved.
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
 * The Country representation holds the information pertaining to a
 * country in PrestaShop.
 *
 * A typical representation looks something like this:
 *
 * <prestashop xmlns:xlink="http://www.w3.org/1999/xlink">
 *   <country>
 * 	  <id><![CDATA[30]]></id>
 * 	  <id_zone xlink:href="http://www.psychicbazaar.com/api/zones/4"><![CDATA[4]]></id_zone>
 * 	  <id_currency></id_currency>
 * 	  <iso_code><![CDATA[ZA]]></iso_code>
 * 	  <call_prefix><![CDATA[27]]></call_prefix>
 * 	  <active><![CDATA[1]]></active>
 * 	  <contains_states><![CDATA[0]]></contains_states>
 * 	  <need_identification_number><![CDATA[0]]></need_identification_number>
 * 	  <need_zip_code><![CDATA[1]]></need_zip_code>
 * 	  <zip_code_format><![CDATA[NNNN]]></zip_code_format>
 * 	  <display_tax_label><![CDATA[1]]></display_tax_label>
 * 	  <name><language id="1" xlink:href="http://www.psychicbazaar.com/api/languages/1"><![CDATA[South Africa]]></language></name>
 *   </country>
 * </prestashop>
 */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
class Country extends Representation {

  @XmlElement(required = true)
  @BeanProperty
  var country: CountryElement = _
}

/**
 * The StateElement holds the core fields for the state.
 */
@XmlAccessorType(XmlAccessType.FIELD)
class CountryElement extends PrestaShopIdentity {

  // -------------------------------------------------------------------------------------------------------------------
  // XLinks into other resources
  // -------------------------------------------------------------------------------------------------------------------

  // TODO: retrieve the xlink:href as well
  @BeanProperty
  var idZone: JLong = _ // PrestaShopXLink = _

  // TODO: retrieve the xlink:href as well
  @XmlElement(nillable = true)
  @BeanProperty
  var idCurrency: JLong = _ // PrestaShopXLink = _

  // -------------------------------------------------------------------------------------------------------------------
  // Resource-specific fields
  // -------------------------------------------------------------------------------------------------------------------

  @BeanProperty
  var isoCode: String = _

  @BeanProperty
  var callPrefix: String = _

  @BeanProperty
  var active: JInteger = _

  @BeanProperty
  var containsStates: JInteger = _

  @BeanProperty
  var needIdentificationNumber: JInteger = _

  @BeanProperty
  var needZipCode: JInteger = _

  @BeanProperty
  var zipCodeFormat: String = _

  @BeanProperty
  var displayTaxLabel: JInteger = _

  // TODO: add in name. It's wrapped inside a <language> element
  // @BeanProperty
  // var name: String = _
}