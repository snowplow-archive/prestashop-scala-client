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

import scala.xml._
import scala.xml.parsing._
import scala.io.Source

/**
 * Simple console example of an Amazon Product API call using scalapac
 */
object ExampleOperations {

  def main(args: Array[String]) {

    // Instantiate the PrestaShop web service client. Update this with your details before running
    val client = new PrestaShopClient(
      apiUri = "x",
      apiKey = "y")

    // Attach the resources we've defined to the client
    PrestaShopApi.attachClient(client)

    // Fetch the XLink list of all products stored in PrestaShop
    val (retVal, response, isErr) = PrestaShopApi.orders.get()
    if (isErr) {
      Console.println("Error: return code: %s, response body follows below:\n\n%s".format(retVal, response))
      System.exit(1)
    }
    // Loop through and print out all order IDs
    response.right.get.toList foreach ( order => Console.println("id = %s".format(order.id)))

    val (_, response2, _) = PrestaShopApi.orders.get("21")
  }
}
