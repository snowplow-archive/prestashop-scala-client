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
import java.util.{Date => JDate}

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
import marshallers.xml.types.DateSpaceTimeAdapter

// Prestasac
import co.orderly.prestasac.representations.shared._

/**
 * The Customer representation holds the information pertaining to a
 * customer in PrestaShop.
 *
 * A typical representation looks something like this:
 *
 * <?xml version="1.0" encoding="UTF-8"?>
 * <prestashop xmlns:xlink="http://www.w3.org/1999/xlink">
 *   <customer>
 *     <id><![CDATA[30]]></id>
 *     <id_default_group xlink:href="http://www.psychicbazaar.com/api/groups/1"><![CDATA[1]]></id_default_group>
 *     <newsletter_date_add></newsletter_date_add>
 *     <ip_registration_newsletter></ip_registration_newsletter>
 *     <last_passwd_gen><![CDATA[2011-10-03 11:41:50]]></last_passwd_gen>
 *     <secure_key><![CDATA[267558046eb890312511804d2ca0668e]]></secure_key>
 *     <deleted><![CDATA[0]]></deleted>
 *     <passwd><![CDATA[2d62ca3847bd8c046b4bf6a677dee403]]></passwd>
 *     <lastname><![CDATA[Dean]]></lastname>
 *     <firstname><![CDATA[Alexander]]></firstname>
 *     <email><![CDATA[keptest3@keplarllp.com]]></email>
 *     <note></note>
 *     <id_gender><![CDATA[9]]></id_gender>
 *     <birthday></birthday>
 *     <newsletter><![CDATA[0]]></newsletter>
 *     <optin><![CDATA[0]]></optin>
 *     <active><![CDATA[1]]></active>
 *     <is_guest><![CDATA[0]]></is_guest>
 *     <date_add><![CDATA[2011-10-03 17:41:50]]></date_add>
 *     <date_upd><![CDATA[2011-10-03 17:41:50]]></date_upd>
 *   </customer>
 * </prestashop>
 */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
class Customer extends Representation {

  @XmlElement(required = true)
  @BeanProperty
  var customer: CustomerElement = _
}

/**
 * The CustomerElement holds the core fields for the address.
 */
@XmlAccessorType(XmlAccessType.FIELD)
class CustomerElement extends PrestaShopTimestampedIdentity {

  // -------------------------------------------------------------------------------------------------------------------
  // XLinks into other resources
  // -------------------------------------------------------------------------------------------------------------------

  // TODO: retrieve the xlink:href as well
  @BeanProperty
  var idDefaultGroup: JInteger = _ // PrestaShopXLink = _

  // -------------------------------------------------------------------------------------------------------------------
  // Resource-specific fields
  // -------------------------------------------------------------------------------------------------------------------

  @XmlElement(nillable = true)
  @XmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
  @BeanProperty
  var newsletterDateAdd: JDate = _

  @XmlElement(nillable = true)
  @BeanProperty
  var ipRegistrationNewsletter: String = _

  @XmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
  @BeanProperty
  var lastPasswdGen: JDate = _

  @BeanProperty
  var secureKey: String = _

  @BeanProperty
  var deleted: JInteger = _

  @BeanProperty
  var passwd: String = _

  @BeanProperty
  var lastname: String = _

  @BeanProperty
  var firstname: String = _

  @BeanProperty
  var email: String = _

  @XmlElement(nillable = true)
  @BeanProperty
  var note: String = _

  @BeanProperty
  var idGender: JInteger = _

  // TODO: add in birthday field (left out as not sure of type). It's nillable though

  @BeanProperty
  var newsletter: JInteger = _

  @BeanProperty
  var optin: JInteger = _

  @BeanProperty
  var active: JInteger = _

  @BeanProperty
  var isGuest: JInteger = _

  // -------------------------------------------------------------------------------------------------------------------
  // Associations
  // -------------------------------------------------------------------------------------------------------------------

  // None
}
