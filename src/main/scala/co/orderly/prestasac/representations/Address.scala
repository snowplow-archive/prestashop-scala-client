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
import java.lang.{Integer => JInteger}

// Scala
import scala.reflect.BeanProperty

// JAXB
import javax.xml.bind.annotation._
import adapters.XmlJavaTypeAdapter

// MOXy
import org.eclipse.persistence.oxm.annotations.XmlNameTransformer

// Narcolepsy
import co.orderly.narcolepsy._
import marshallers.xml.moxy.CamelCase2Underscore

// Prestasac
import co.orderly.prestasac.representations.shared._

/**
 * The Address representation holds the information pertaining to an
 * address in PrestaShop.
 */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
class Address extends Representation {

  @XmlElement(required = true)
  @BeanProperty
  var address: AddressElement = _
}

/**
 * The AddressElement holds the core fields for the address.
 */
@XmlAccessorType(XmlAccessType.FIELD)
class AddressElement extends PrestaShopCommonFields {

  // -------------------------------------------------------------------------------------------------------------------
  // XLinks into other resources
  // -------------------------------------------------------------------------------------------------------------------

  // TODO: retrieve the xlink:href as well
  @XmlElement(nillable = true)
  @BeanProperty
  var idCustomer: JInteger = _ // PrestaShopXLink = _

  // TODO: retrieve the xlink:href as well
  @XmlElement(nillable = true)
  @BeanProperty
  var idManufacturer: JInteger = _ // PrestaShopXLink = _

  // TODO: retrieve the xlink:href as well
  @XmlElement(nillable = true)
  @BeanProperty
  var idSupplier: JInteger = _ // PrestaShopXLink = _

  // TODO: retrieve the xlink:href as well
  @BeanProperty
  var idCountry: JInteger = _ // PrestaShopXLink = _

  // TODO: retrieve the xlink:href as well
  @XmlElement(nillable = true)
  @BeanProperty
  var idState: JInteger = _ // PrestaShopXLink = _

  // -------------------------------------------------------------------------------------------------------------------
  // Resource-specific fields
  // -------------------------------------------------------------------------------------------------------------------

  @BeanProperty
  var alias: String = _

  @XmlElement(nillable = true)
  @BeanProperty
  var company: String = _

  @BeanProperty
  var lastname: String = _

  @BeanProperty
  var firstname: String = _

  @BeanProperty
  var address1: String = _

  @XmlElement(nillable = true)
  @BeanProperty
  var address2: String = _

  @BeanProperty
  var postcode: String = _

  @BeanProperty
  var city: String = _

  @XmlElement(nillable = true)
  @BeanProperty
  var other: String = _

  @XmlElement(nillable = true)
  @BeanProperty
  var phone: String = _

  @XmlElement(nillable = true)
  @BeanProperty
  var phoneMobile: String = _

  @XmlElement(nillable = true)
  @BeanProperty
  var dni: String = _

  @XmlElement(nillable = true)
  @BeanProperty
  var vatNumber: String = _

  @BeanProperty
  var deleted: JInteger = _

  // -------------------------------------------------------------------------------------------------------------------
  // Associations
  // -------------------------------------------------------------------------------------------------------------------

  // None
}

/*

<?xml version="1.0" encoding="UTF-8"?>
<prestashop xmlns:xlink="http://www.w3.org/1999/xlink">
<address>
	<id><![CDATA[13]]></id>
	<id_customer xlink:href="http://www.psychicbazaar.com/api/customers/10"><![CDATA[10]]></id_customer>
	<id_manufacturer></id_manufacturer>
	<id_supplier></id_supplier>
	<id_country xlink:href="http://www.psychicbazaar.com/api/countries/1"><![CDATA[1]]></id_country>
	<id_state></id_state>
	<alias><![CDATA[My address]]></alias>
	<company></company>
	<lastname><![CDATA[lala]]></lastname>
	<firstname><![CDATA[john]]></firstname>
	<address1><![CDATA[wqeqwewq]]></address1>
	<address2></address2>
	<postcode><![CDATA[01999]]></postcode>
	<city><![CDATA[Berlin]]></city>
	<other></other>
	<phone></phone>
	<phone_mobile></phone_mobile>
	<dni></dni>
	<vat_number></vat_number>
	<deleted><![CDATA[0]]></deleted>
	<date_add><![CDATA[2011-09-07 10:41:26]]></date_add>
	<date_upd><![CDATA[2011-09-07 10:41:26]]></date_upd>
</address>
</prestashop>  */