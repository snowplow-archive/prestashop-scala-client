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

  // -------------------------------------------------------------------------------------------------------------------
  // Fully defined PrestaShop representations
  // -------------------------------------------------------------------------------------------------------------------

  val products = resource[Product, ProductList]("products")
  val orders = resource[Order, OrderList]("orders")

  // -------------------------------------------------------------------------------------------------------------------
  // Partially defined PrestaShop representations
  // -------------------------------------------------------------------------------------------------------------------

  // These partially defined PrestaShop representations have Nothing in place
  // of RepresentationWrappers. The plural representations do exist - they just haven't
  // been defined yet in Prestasac (no pressing need - pull request if you need them)
  val addresses = resource[Address, Nothing]("addresses")
  val customers = resource[Customer, Nothing]("customers")
  val countries = resource[Country, Nothing]("countries")
  val states = resource[State, Nothing]("states")
}