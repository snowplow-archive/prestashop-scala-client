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
import co.orderly.prestasac._

// Scala
import scala.collection.JavaConversions._

/**
 * Example calls to the PrestaShop web service using Prestasac. Update the apiUri
 * and apiKey with your own PrestaShop instance to try this out.
 *
 * All of the calls are non-destructive.
 */
object ExampleOperations {

  def main(args: Array[String]) {

    // Instantiate the PrestaShop web service client. Update this with your details before running
    val client = new PrestaShopClient(
      apiUri = "[YOUR PRESTASHOP API URL HERE]", // [YOUR PRESTASHOP API URL HERE]
      apiKey = "[YOUR PRESTASHOP AUTHENTICATION KEY HERE]")  // [YOUR PRESTASHOP AUTHENTICATION KEY HERE]

    // Attach the client to the resources we've defined
    PrestaShopApi.attachClient(client)

    // List all orders. Note getS() - this means we are retrieving all rows. This is unimportant when simply run()ing,
    // but important when we are unmarshalling (because gets() unmarshals to a RepresentationWrapper whereas get()
    // unmarshals to a Representation)
    PrestaShopApi.orders.gets().consolePrint().run()

    // Display order #23
    PrestaShopApi.orders.get()
      .consolePrint()
      .setId(23)
      .run() // Returns a RestfulResponse - (code, headers, body) Tuple3

    val order = PrestaShopApi.orders.get()
      .setId(34)
      .unmarshal() // Returns an UnmarshalledResponse containing and ErrorRepresentation or an Order object
    Console.println("order delivery ID = %s".format(order.right.get.get.order.idAddressDelivery.id))

    val product = PrestaShopApi.products.get()
      .setId(23)
      .unmarshal()
    val m = product.right.get.get.product.idManufacturer
    Console.println("product.idManufacturer: id = %s, href = %s".format(m.id, m.href))

    PrestaShopApi.products.gets()
      .toList
      .foreach ( p => {
        val pr = PrestaShopApi.products.get()
          .setId(p.id)
          .unmarshal()
        val pa = pr.right.get.get.product // Assume we didn't get an error
        Console.println("Product #%s made by %s selling for %s".format(pa.id, pa.manufacturerName, pa.price))
      })

    // Let's wrap up with an exception
    PrestaShopApi.orders.get()
      .consolePrint()
      .overrideSlug("typo") // Access a resource slug which doesn't exist
      .setId(23)
      .throwException() // TODO: this isn't implemented yet
      .run()
  }
}
