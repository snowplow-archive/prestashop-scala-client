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
import co.orderly.prestasac._

// Scala
import scala.collection.JavaConversions._

/**
 * Example calls to the PrestaShop web service using Prestasac. Update the apiUri
 * and apiKey with your own PrestaShop instance to try this out. All of the calls
 * are non-destructive
 */
object ExampleOperations {

  def main(args: Array[String]) {

    // Instantiate the PrestaShop web service client. Update this with your details before running
    val client = new PrestaShopClient(
      apiUri = "[YOUR PRESTASHOP API URL HERE]", // [YOUR PRESTASHOP API URL HERE]
      apiKey = "[YOUR PRESTASHOP AUTHENTICATION KEY HERE]")  // [YOUR PRESTASHOP AUTHENTICATION KEY HERE]

    // Attach the client to the resources we've defined
    PrestaShopApi.attachClient(client)

    // Fetch the XLink list of all orders stored in PrestaShop
    val (retVal, orders, isErr) = PrestaShopApi.orders.get()
    if (isErr) {
      Console.println("Error: return code: %s, response body follows below:\n\n%s".format(retVal, orders))
      System.exit(1)
    }
    // Loop through and print out all customers, how much they paid and when they bought
    orders.right.get.toList foreach ( o => {
      val (_, order, _) = PrestaShopApi.orders.get(o.id.toString())
      val oa = order.left.get.order // Alias
      Console.println("Customer #TODO paid %s on %s".format(oa.totalPaidReal, oa.dateAdd))
    })

    // Display all of the products sold as part of order #5
    val (_, order, _) = PrestaShopApi.orders.get("5")
    order.left.get.order.associations.orderRows foreach ( or => Console.println("Line item = %s (x%s)".format(or.productName, or.productQuantity)))

    // Fetch the XLink list of all products stored in PrestaShop
    val ps = PrestaShopApi.products.get()
    if (ps._3) {
      Console.println("Error: return code: %s, response body follows below:\n\n%s".format(ps._1, ps._2))
      System.exit(1)
    }

    // Loop through and print out all customers, how much they paid and when they bought
    ps._2.right.get.toList foreach ( p => {
      val pr = PrestaShopApi.products.get(p.id.toString())
      val pa = pr._2.left.get.product // Alias
      Console.println("Product #%s made by %s selling for %s".format(pa.id, pa.manufacturerName, pa.price))
    })
  }
}
