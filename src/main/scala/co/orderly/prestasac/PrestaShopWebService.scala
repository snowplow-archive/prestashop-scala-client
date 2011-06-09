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
  var apiURL:             String,
  val authenticationKey:  String,
  val debug:              Boolean = true) {
  
  // Compatible versions of the PrestaShop Web Service
  val MIN_PRESTASHOP_VERSION = "1.4.0.17"
  val MAX_PRESTASHOP_VERSION = "1.4.2.3"

  // Append a trailing slash to the API URL if there isn't one
  // TODO

  /**
   * Take the status code and throw an exception if the server didn't return 200 or 201 code
   * @param statusCode Status code of an HTTP return
   */
  protected def check(statusCode: Int): Int = {

    val error = "This call to the PrestaShop Web Service failed and returned an HTTP status of %d. That means: %s.";

    statusCode match {
      case 200 => statusCode
      case 201 => statusCode
      case 204 => throw new PrestaShopWebServiceException(error.format(statusCode, "No content"))
      case 400 => throw new PrestaShopWebServiceException(error.format(statusCode, "Bad request"))
      case 401 => throw new PrestaShopWebServiceException(error.format(statusCode, "Unauthorized"))
      case 404 => throw new PrestaShopWebServiceException(error.format(statusCode, "Not found"))
      case 405 => throw new PrestaShopWebServiceException(error.format(statusCode, "Method not allowed"))
      case 500 => throw new PrestaShopWebServiceException(error.format(statusCode, "Internal server error"))
      case _   => throw new PrestaShopWebServiceException("This call to the PrestaShop Web Service returned an unexpected HTTP status of: %d.".format(statusCode))
    }
  }

  /**
   * Handles an HTTP request to PrestaShop Web Service. Uses HttpClient. Can throw a PrestaShopWebServiceException
   * @param url Resource to request
   * @param args Parameters to configure the HTTP request
   * @return A tuple containing the response code, body and header
   */
  protected def execute(
    url:    String,
    verb:   String,
    xml:    Elem = None,
    noBody: Boolean = false): Tuple3[Int, String, String] = {

    // TODO

    return (check(code), body, header) // Return in a tuple, checking the status code as we do so
  }

  /**
   * Loads an XML into an Elem from a String
   * Throws an exception if there is no XML or it won't validate
   */
  protected def parseXML(xml: String): Elem = {

  }

  /**
   * Validates that the parameters are all either "filter", "display", "sort" or "limit"
   * Throws a PrestaShopWebServiceException if not.
   * @param params Parameters to validate
   * @return The original parameters if everything is okay
   */
  protected def validate(params: Map[String, String]): Map[String, String] = {

    params.map(
      (param) => if (!("filter", "display", "sort", "limit") contains param._1 )
        throw new PrestaShopWebServiceException("Parameter %s is not supported".format(param._1))
    ) // TODO: check this returns params okay
  }

  /**
   * Returns a canonicalized, escaped string of &key=value pairs from an ordered map of parameters
   */
  protected def canonicalize(params: Map[String, String]): String = {

    params.map(
      (param) => escape( param._1 ) + "=" + escape(param._2)
    ).mkString("&")
  }

  /**
   * Add (POST) a resource, self-assembly version
   * @param resource Type of resource to add
   * @param postXml Full XML of new resource
   * @return XML response from Web Service
   */
  def add(resource: String, postXml: Elem): Elem = {
    add(apiURL + resource)
  }

  /**
   * Add (POST) a resource, URL version
   * @param url Full URL for a POST request to the Web Service
   * @param postXml Full XML of new resource
   * @return XML response from Web Service
   */
  def add(url: String, postXml: Elem): Elem = {
    // TODO
  }

  /**
   * Retrieve (GET) a resource, self-assembly version
   * @param resource Type of resource to retrieve
   * @param id Resource ID to retrieve
   * @param params Map of parameters (one or more of 'filter', 'display', 'sort', 'limit')
   * @return XML response from Web Service
   */
  def get(resource: String, id: Int, params: Map[String, String] = immutable.Map.empty): Elem = {
    get(apiURL + resource + "?" + canonicalize(validate(params)))
  }

  /**
   * Retrieve (GET) a resource, URL version
   * @param url A URL which explicitly sets the resource type and ID to retrieve
   * @param params Map of parameters (one or more of 'filter', 'display', 'sort', 'limit')
   * @return XML response from Web Service
   */
  def get(url: String, params: Map[String, String] = immutable.Map.empty): Elem = {
    // TODO
  }

  /**
   * Head (HEAD) an individual resource or all resources of a type, self-assembly version
   * @param resource Type of resource to head
   * @param id Resource ID to head (if not provided, head all resources of this type)
   * @param params Map of parameters (one or more of 'filter', 'display', 'sort', 'limit')
   * @return Header from Web Service's response
   */
  def head(resource: String, id: Int = None, params: Map[String, String] = immutable.Map.empty): String = {
    head(apiURL + resource /* + TODO add /id if set */ + "?" + canonicalize(validate(params)))
  }

  /**
   * Head (HEAD) an individual resource or all resources of a type, URL version
   * @param url Full URL for the HEAD request to the Web Service
   * @return Header from Web Service's response
   */
  def head(url: String): String = {
    val (code, body, header) = execute(url, "HEAD")
  }

  /**
   * Edit (PUT) a resource, self-assembly version
   * @param resource Type of resource to update
   * @param id Resource ID to update
   * @param xml Modified XML of the resource
   * @return XML response from Web Service
   */
  def edit(resource: String, id: Int, xml: Elem): Elem = {
    edit(apiURL + resource + "/" + id, xml)
  }

  /**
   * Edit (PUT) a resource, URL version
   * @param url A URL which explicitly sets the resource type and ID to edit
   * @param xml Modified XML of the resource
   * @return XML response from Web Service
   */
  def edit(url: String, xml: Elem): Elem = {

    // Execute the API call
    val (code, body, header) = execute(url, "PUT", xml)

    // Parse and return the XML
    parseXML(body)
  }

  /**
   * Delete (DELETE) a resource, self-assembly version supporting one ID
   * This version takes a resource type and an array of IDs to delete
   * @param resource The type of resource to delete (e.g. "orders")
   * @param id An ID of this resource type, to delete
   */
  def delete(resource: String, id: Int) {
    delete(apiURL + resource + "/" + id)
  }

  /**
   * Delete (DELETE) a resource, self-assembly version supporting multiple IDs
   * This version takes a resource type and an array of IDs to delete
   * @param resource The type of resource to delete (e.g. "orders")
   * @param ids An array of IDs of this resource type, to delete
   */
  def delete(resource: String, ids: Array[Int]) {
    delete(apiURL + resource + "/?id=[%s]".format(ids.mkString(",")))
  }

  /**
   * Delete (DELETE) a resource, URL version
   * @param url A URL which explicitly sets resource type and resource ID
   */
  def delete(url: String) {
    val (code, body, header) = execute(url, "DELETE")
  }
}

/**
 * Custom runtime exception for this library
 */
class PrestaShopWebServiceException(message: String) extends RuntimeException(message) {
}