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
import java.util.{Collection => JCollection}
import java.util.{Date => JDate}
import java.lang.{Float => JFloat}
import java.lang.{Integer => JInteger}
import java.lang.{Long => JLong}
import java.util.{List => JList}

// Scala
import scala.collection.mutable.{Buffer, ArrayBuffer}
import scala.reflect.BeanProperty
import scala.collection.JavaConversions._

// JAXB
import javax.xml.bind.annotation._
import adapters.XmlJavaTypeAdapter

// MOXy
import org.eclipse.persistence.oxm.annotations.XmlNameTransformer

// Narcolepsy
import co.orderly.narcolepsy._
import marshallers.jaxb.moxy.CamelCase2Underscore
import marshallers.jaxb.types.DateSpaceTimeAdapter

// Prestasac
import co.orderly.prestasac.representations.shared._

/**
 * The Order representation holds the information pertaining to an
 * order in PrestaShop.
 */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
class Order extends Representation {

  @XmlElement(required = true)
  @BeanProperty
  var order: OrderElement = _
}

/**
 * The OrderElement holds the core fields for the order.
 */
@XmlAccessorType(XmlAccessType.FIELD)
class OrderElement extends PrestaShopTimestampedIdentity {

  // -------------------------------------------------------------------------------------------------------------------
  // XLinks into other resources
  // -------------------------------------------------------------------------------------------------------------------

  // TODO: retrieve the xlink:href as well
  @BeanProperty
  var idAddressDelivery: JLong = _ // PrestaShopXLink = _

  // TODO: retrieve the xlink:href as well
  @BeanProperty
  var idAddressInvoice: JLong = _ // PrestaShopXLink = _

  // TODO: retrieve the xlink:href as well
  @BeanProperty
  var idCart: JLong = _ // PrestaShopXLink = _

  // TODO: retrieve the xlink:href as well
  @BeanProperty
  var idCurrency: JLong = _ // PrestaShopXLink = _

  // TODO: retrieve the xlink:href as well
  @BeanProperty
  var idLang: JLong = _ // PrestaShopXLink = _

  // TODO: retrieve the xlink:href as well
  @BeanProperty
  var idCustomer: JLong = _ // PrestaShopXLink = _

  // TODO: retrieve the xlink:href as well
  @BeanProperty
  var idCarrier: JLong = _ // PrestaShopXLink = _

  // -------------------------------------------------------------------------------------------------------------------
  // Resource-specific fields
  // -------------------------------------------------------------------------------------------------------------------

  @BeanProperty
  var module: String = _

  @BeanProperty
  var invoiceNumber: JLong = _

  @BeanProperty
  var deliveryNumber: JLong = _

  @XmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
  @BeanProperty
  var invoiceDate: JDate = _

  @XmlElement(nillable = true)
  @XmlJavaTypeAdapter(classOf[DateSpaceTimeAdapter])
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

  @XmlElement(required = true)
  @BeanProperty
  var associations: Associations = _
}

/**
 * Associations is a wrapper around the order's line items (aka order rows).
 */
@XmlType(name = "")
class Associations {

  var orderRows: Buffer[OrderRow] = ArrayBuffer[OrderRow]()

  @XmlElementWrapper(name = "order_rows") // Needed to wrap <order_rows> around each <order_row>
  @XmlElement(name = "order_row", required = true)
  def getOrderRows: JList[OrderRow] = this.orderRows

  def setOrderRows(orderRows: JList[OrderRow]) {
    this.orderRows = orderRows
  }
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
