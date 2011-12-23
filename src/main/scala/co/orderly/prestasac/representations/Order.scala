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
import java.lang.{Float => JFloat}
import java.lang.{Integer => JInteger}

// Scala
import scala.reflect.BeanProperty

// JAXB
import javax.xml.bind.annotation._

// Prestasac
import co.orderly.prestasac.representations.shared._

/**
 * The Order representation holds the information pertaining to an
 * order in PrestaShop.
 */
@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
class Order extends PrestaShopRepresentation {

  // -------------------------------------------------------------------------------------------------------------------
  // XLinks into other resources
  // -------------------------------------------------------------------------------------------------------------------

  @BeanProperty
  var idAddressDelivery: PrestaShopXLink = _

  @BeanProperty
  var idAddressInvoice: PrestaShopXLink = _

  @BeanProperty
  var idCart: PrestaShopXLink = _

  @BeanProperty
  var idCurrency: PrestaShopXLink = _

  @BeanProperty
  var idLang: PrestaShopXLink = _

  @BeanProperty
  var idCustomer: PrestaShopXLink = _

  @BeanProperty
  var idCarrier: PrestaShopXLink = _

  // -------------------------------------------------------------------------------------------------------------------
  // Resource-specific fields
  // -------------------------------------------------------------------------------------------------------------------

  @BeanProperty
  var module: String = _

  @BeanProperty
  var invoiceNumber: Long = _

  @BeanProperty
  var deliveryNumber: Long = _

  @BeanProperty
  var invoiceDate: JDate = _

  @BeanProperty
  var deliveryDate: JDate = _

  @BeanProperty
  var valid: JInteger = _

  // TODO: fix current state (missing the attributes)
  @BeanProperty
  var currentState: JInteger = _

  @BeanProperty
  var secureKey: String = _

  @BeanProperty
  var payment: String = _

  @BeanProperty
  var recyclable: JInteger = _

  @BeanProperty
  var gift: JInteger = _

  @BeanProperty
  var giftMessage: String = _

  // -------------------------------------------------------------------------------------------------------------------
  // Associations
  // -------------------------------------------------------------------------------------------------------------------


}
