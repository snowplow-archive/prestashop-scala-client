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
 * The Product representation holds the information pertaining to a
 * product in the PrestaShop catalogue.
 */
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlNameTransformer(classOf[CamelCase2Underscore])
class Product extends Representation {

  @XmlElement(required = true)
  @BeanProperty
  var product: ProductElement = _
}

/**
 * The ProductElement holds the core fields for the order.
 */
@XmlAccessorType(XmlAccessType.FIELD)
class ProductElement extends PrestaShopTimestampedIdentity {

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

  @BeanProperty
  var width: JInteger = _

  @BeanProperty
  var height: JInteger = _

  @BeanProperty
  var depth: JInteger = _

  @BeanProperty
  var weight: JInteger = _

  @BeanProperty
  var quantityDiscount: JInteger = _

  @BeanProperty
  var customizable: JInteger = _

  @BeanProperty
  var uploadableFiles: JInteger = _

  @BeanProperty
  var textFields: JInteger = _

  @BeanProperty
  var active: JInteger = _

  @BeanProperty
  var availableForOrder: JInteger = _

  @BeanProperty
  var condition: String = _

  @BeanProperty
  var showPrice: JInteger = _

  @BeanProperty
  var indexed: JInteger = _

  @BeanProperty
  var cacheIsPack: JInteger = _

  @BeanProperty
  var cacheHasAttachment: JInteger = _

  @BeanProperty
  var quantity: JInteger = _

  // TODO: add in <meta_description>

  // TODO: add in <meta_keywords>

  // TODO: add in <meta_title>

  // TODO: add in <link_rewrite>

  // TODO: add in <name>

  // TODO: add in <available_now>

  // TODO: add in <available_later>

  // TODO: add in <description>

  // TODO: add in <description_short>

  // -------------------------------------------------------------------------------------------------------------------
  // Associations
  // -------------------------------------------------------------------------------------------------------------------

  // TODO: add in <categories>

  // TODO: add in the other associations
}
