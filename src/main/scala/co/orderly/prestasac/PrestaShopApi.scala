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
package co.orderly.prestasac

// Narcolepsy
import co.orderly.narcolepsy._

// Prestasac
import co.orderly.prestasac.representations._
import wrappers._

/**
 * Resource definitions for the Orderly MDM API
 */
object PrestaShopApi extends Api {

  // TODO can I attach an ErrorRepresentation to this?

  // Fully defined PrestaShop representations
  val products = resource[Product, ProductList, ProductListXLink]("products")
  val orders = resource[Order, OrderList, OrderListXLink]("orders")

  // Partially defined PrestaShop representations
  // It's not that the undefined plural representations don't exist - it's just
  // that there is limited business value in defining them in Prestasac

  // TODO: add support for a resource without a RepresentationWrapper
  val addresses = resource[Address, OrderList, OrderListXLink]("addresses")
  // val customers = resource[Customer, DummyRepresentationWrapper]("customers")
  // val countries = resource[Country, DummyRepresentationWrapper]("countries")
  // val states = resource[State, DummyRepresentationWrapper]("states")
}