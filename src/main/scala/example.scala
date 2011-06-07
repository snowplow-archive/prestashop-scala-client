/* Distributed as part of scalapac, an Amazon Product API client for Scala.
 *
 * Copyright (c) 2011 Alex Dean
 *
 * scalapac is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * scalapac is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with scalapac. If not, see <http://www.gnu.org/licenses/>.
 */
import co.orderly.prestasac.PrestaShopWebService

/**
 * Simple console example of an Amazon Product API call using scalapac
 */
object ExampleOperations {

  def main(args: Array[String]) {

    // Update this with your Amazon credentials before running
    val psApi = new PrestaShopWebService(shopURL     = "[YOUR AWS ID HERE]",
                                       authenticationKey       = "[YOUR AWS SECRET HERE]",
                                       debug = true
                                       )

    val blah = psApi.checkStatusCode(999)
  }
}