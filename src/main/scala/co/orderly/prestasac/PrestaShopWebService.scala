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
  val shopURL:		        String,
  val authenticationKey: 	String,
  val debug:   		        Boolean = true)
{
  
  // Compatible versions of the PrestaShop Web Service
  val MIN_PRESTASHOP_VERSION = "1.4.0.17"
  val MAX_PRESTASHOP_VERSION = "1.4.2.3"

  /**
   * Take the status code and throw an exception if the server didn't return 200 or 201 code
   * @param statusCode Status code of an HTTP return
   */
  protected def checkStatusCode(statusCode: Int): Int = {

    val error = "This call to PrestaShop Web Services failed and returned an HTTP status of %d. That means: %s.";

    statusCode match {
      case 200 => statusCode; case 201 => statusCode
      case 204 => throw new PrestaShopWebServiceException(error.format(statusCode, "No content"))
      case 400 => throw new PrestaShopWebServiceException(error.format(statusCode, "Bad request"))
      case 401 => throw new PrestaShopWebServiceException(error.format(statusCode, "Unauthorized"))
      case 404 => throw new PrestaShopWebServiceException(error.format(statusCode, "Not Found"))
      case 405 => throw new PrestaShopWebServiceException(error.format(statusCode, "Method Not Allowed"))
      case 500 => throw new PrestaShopWebServiceException(error.format(statusCode, "Internal Server Error"))
      case _   => throw new PrestaShopWebServiceException("This call to PrestaShop Web Services returned an unexpected HTTP status of: %d.".format(statusCode))
    }
  }

  /**
   * Handles an HTTP request to PrestaShop Web Service. Uses HttpClient. Can throw a PrestaShopWebServiceException
	 * @param url Resource to request
	 * @param args Parameters to configure the HTTP request
	 * @return A tuple containing the response code and the XML
   */
  protected def executeRequest(url: String, args: Map[String, String]): Tuple2[Int, Elem] = {

  }

  /**
   * Delete (DELETE) a resource
   * This version takes a resource type and an array of IDs to delete
   *
  def delete(resource: String, ids: Array[Int]) {
    // TODO
  }

  /**
   * Delete (DELETE) a resource
   * @param url A URL which explicitly sets resource type and resource ID
   */
  def delete(url: String) {
    // TODO
  }    */
}

/**
 * Custom runtime exception for this library
 */
class PrestaShopWebServiceException(message: String) extends RuntimeException(message) {
}