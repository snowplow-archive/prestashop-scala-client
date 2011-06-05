/* Distributed as part of prestasac, a Scala client for the PrestaShop Web Service
 *
 * Copyright (c) 2011 Alex Dean
 *
 * prestasac is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * prestasac is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with prestasac. If not, see <http://www.gnu.org/licenses/>.
 */
package co.orderly.prestasac

import java.net.{URL, URLConnection, HttpURLConnection}
import java.io.{InputStream, IOException}

import scala.xml._

/**
 * Instantiate the PrestaShopWebService to start executing operations against the PrestaShop Web Service
 */
class PrestaShopWebService(
  shopURL:		String,
  authenticationKey: 	String,
  debug:   		Boolean = True)
{
  
  // Compatible versions of the PrestaShop Web Service
  val MIN_PRESTASHOP_VERSION = "1.4.0.17"
  val MAX_PRESTASHOP_VERSION = "1.4.2.3"

  /**
   * Take the status code and throw an exception if the server didn't return 200 or 201 code
   */
  def checkStatusCode(statusCode: String) {
    // TODO
  }

  /**
   * Delete (DELETE) a resource
   * options can contain either:
   * - A url which explicitly sets resource type and resource ID
   * - A resource type and ID
   * - A resource type and an array of IDs 
   */
  def delete(url: String) {
    // TODO
  } 
}
