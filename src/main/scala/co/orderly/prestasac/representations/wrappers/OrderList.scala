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
package co.orderly.prestasac.representations.wrappers

// Java
import java.util.{List => JList}

// Scala
import scala.collection.mutable.{Buffer, ArrayBuffer}
import scala.collection.JavaConversions._
import scala.reflect.BeanProperty

// JAXB
import javax.xml.bind.annotation._

// Narcolepsy
import co.orderly.narcolepsy._

// Prestasac
import co.orderly.prestasac.representations.shared.PrestaShopListXLink

@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
class OrderList extends RepresentationWrapper[OrderListXLink] {

  type rtype = OrderListXLink

  @BeanProperty
  var orders: Orders = _

  def toList: List[OrderListXLink] = this.orders.orderLinks.toList

  def fromList(orderLinks: List[OrderListXLink]) {
    val p = new Orders()
    p.orderLinks = orderLinks.toBuffer
    p
  }
}

@XmlType(name = "")
@XmlRootElement(name = "orders")
class Orders {

  var orderLinks: Buffer[OrderListXLink] = ArrayBuffer[OrderListXLink]()

  @XmlElement(name = "order", required = true)
  def getOrders: JList[OrderListXLink] = this.orderLinks

  def setOrders(orders: JList[OrderListXLink]) {
    this.orderLinks = orderLinks
  }
}

@XmlElement(name = "order", required = true)
@XmlAccessorType(XmlAccessType.FIELD)
class OrderListXLink extends PrestaShopListXLink
