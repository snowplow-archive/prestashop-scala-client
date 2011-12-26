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

// Narcolepsy
import orderly.narcolepsy.Representation

// Prestasac
import co.orderly.prestasac.representations.shared._

/**
 * The Product representation holds the information pertaining to a
 * product in the PrestaShop catalogue.
 */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
class Product extends Representation {

  @XmlElement(required = true)
  @BeanProperty
  var product: ProductElement = _
}

/**
 * The ProductElement holds the core fields for the order.
 */
@XmlAccessorType(XmlAccessType.FIELD)
class ProductElement extends PrestaShopCommonFields {

  // -------------------------------------------------------------------------------------------------------------------
  // XLinks into other resources
  // -------------------------------------------------------------------------------------------------------------------

  @BeanProperty
  var idManufacturer: PrestaShopXLink = _

  @BeanProperty
  var idCategoryDefault: PrestaShopXLink = _

  // TODO: add not_filterable attribute
  @BeanProperty
  var idDefaultCombination: PrestaShopXLink = _

  // -------------------------------------------------------------------------------------------------------------------
  // Resource-specific fields
  // -------------------------------------------------------------------------------------------------------------------

  @BeanProperty
  var idSupplier: String = _

  @BeanProperty
  var outOfStock: JInteger = _

  // TODO: add in <new>. No idea what data type it should be. But it's nillable

  @BeanProperty
  var cacheDefaultAttribute: JInteger = _

  // TODO: add in <id_default_image>. No idea on datatype. Has not_filterable attribute

  // TODO: add not_filterable attribute
  @BeanProperty
  var positionInCategory: JInteger = _

  @BeanProperty
  var manufacturerName: String = _

  @BeanProperty
  var reference: String = _

  @BeanProperty
  var supplierReference: String = _

  // TODO: add location. No idea on datatype

  @BeanProperty
  var ean13: String = _

  @BeanProperty
  var upc: String = _

  // TODO: add unity. Not sure what it is

  // TODO: add id_tax_rules_group

  // TODO: add id_color_default

  @BeanProperty
  var minimalQuantity: JInteger = _

  @BeanProperty
  var price: JFloat = _

  @BeanProperty
  var additionalShippingCost: JFloat = _

  @BeanProperty
  var wholesalePrice: JFloat = _

  @BeanProperty
  var onSale: JInteger = _

  @BeanProperty
  var onlineOnly: JInteger = _

  @BeanProperty
  var ecotax: JFloat = _

  // TODO: check assumption that <unit_price> is a float (it probably is)
  @XmlElement(nillable = true)
  @BeanProperty
  var unitPrice: JFloat = _
}
