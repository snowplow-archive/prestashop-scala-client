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
import orderly.narcolepsy._

// Prestasac
import co.orderly.prestasac.representations.PrestaShopXLink

@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
class ProductList extends RepresentationWrapper[ProductXLink] {

  @BeanProperty
  var products: Products = _

  def toList: List[ProductXLink] = this.products.productLinks.toList

  def fromList(productLinks: List[ProductXLink]) {
    val p = new Products()
    p.productLinks = arrayBufferFromList[ProductXLink](productLinks)
    p
  }
}

@XmlType(name = "")
@XmlRootElement(name = "products")
class Products {

  var productLinks: Buffer[ProductXLink] = ArrayBuffer[ProductXLink]()

  @XmlElement(name = "product", required = true)
  def getProducts: JList[ProductXLink] = this.productLinks

  def setProducts(products: JList[ProductXLink]) {
    this.productLinks = productLinks
  }
}

@XmlElement(name = "product", required = true)
@XmlAccessorType(XmlAccessType.FIELD)
class ProductXLink extends PrestaShopXLink
