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
import scala.collection.JavaConversions._
import java.util.{Collection => JCollection}
import java.util.{Date => JDate}
import java.lang.{Float => JFloat}
import java.lang.{Integer => JInteger}
import java.lang.{Long => JLong}

// Scala
import scala.reflect.BeanProperty

// JAXB
import javax.xml.bind.annotation._

// MOXy
import org.eclipse.persistence.oxm.annotations.XmlNameTransformer

// Narcolepsy
import orderly.narcolepsy.Representation

// Prestasac
import co.orderly.prestasac.representations.shared._

/**
 * The Order representation holds the information pertaining to an
 * order in PrestaShop.
 */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[co.orderly.prestasac.representations.shared.LowerCaseWithUnderscoresNameGenerator])
class Order extends Representation {

  @XmlElement(required = true)
  @BeanProperty
  var order: OrderElement = _
}

/**
 * The OrderElement holds the core fields for the order.
 */
@XmlAccessorType(XmlAccessType.FIELD)
class OrderElement extends PrestaShopCommonFields {

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
  var invoiceNumber: JLong = _

  @BeanProperty
  var deliveryNumber: JLong = _

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

  @XmlElement(nillable = true)
  @BeanProperty
  var giftMessage: String = _

  @BeanProperty
  var totalDiscounts: JFloat = _

  @BeanProperty
  var totalPaid: JFloat = _

  @BeanProperty
  var totalPaidReal: JFloat = _

  @BeanProperty
  var totalProducts: JFloat = _

  @BeanProperty
  var totalProductsWt: JFloat = _

  @BeanProperty
  var totalShipping: JFloat = _

  @BeanProperty
  var carrierTaxRate: JFloat = _

  @BeanProperty
  var totalWrapping: JFloat = _

  @XmlElement(nillable = true)
  @BeanProperty
  var shippingNumber: JLong = _

  @BeanProperty
  var conversionRate: JFloat = _

  // -------------------------------------------------------------------------------------------------------------------
  // Associations
  // -------------------------------------------------------------------------------------------------------------------

  // TODO: can I just use ElementWrapper?!
  /* @XmlElement(required = true)
  @BeanProperty
  var associations: OrderAssociations = _ */
}

/**
 * Associations is a wrapper around the order's line items (aka order rows).
 */
@XmlAccessorType(XmlAccessType.FIELD)
class OrderAssociations {

  // TODO: missing attributes on order_rows. Perhaps ElementWrapper is not right here?
  @XmlElementWrapper(name = "order_rows") // Needed to wrap <order_rows> around each <order_row>
  @XmlElement(name = "order_row")
  @BeanProperty
  var orderRows: JCollection[OrderRow] = Iterable[OrderRow]()
}

/**
 * OrderRow contains the information pertaining to an individual line item
 * within an order.
 */
@XmlAccessorType(XmlAccessType.FIELD)
class OrderRow {

  @BeanProperty
  var id: JLong = _

  @BeanProperty
  var productId: JLong = _

  @BeanProperty
  var productAttributeId: JLong = _

  @BeanProperty
  var productQuantity: JInteger = _

  @BeanProperty
  var productName: String = _

  @BeanProperty
  var productPrice: JFloat = _
}