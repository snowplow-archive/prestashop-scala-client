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
import orderly.narcolepsy._
import utils._
import adapters.ApacheHttpClientAdapter

class PrestaShopClient(
  rootUri:      String,
  username:     String) extends Client(Some(rootUri), Some("text/xml"), username, "") with ApacheHttpClientAdapter {

  // Note: we use lazy vals so we can validate in the Narcolepsy super constructor as per
  // http://stackoverflow.com/questions/7475291/how-do-i-validate-a-subclassed-field-in-my-scala-abstract-parent-object

  // Configuration which relates to this client
  lazy override val clientName = "PrestaShop Scala Client"
  lazy override val clientVersion = new RestfulVersion("0.2")
  override val minVersionSupported = Some(new RestfulVersion("1.4.0.17"))
  override val maxVersionSupported = Some(new RestfulVersion("1.4.7.5"))

  // Configuration which relates to the API itself
  lazy override val defaultRootUri = None // Not hosted
  override val versionHeader = Some("PSWS-Version")
  lazy override val errorFormat = MixedErrors // Plaintext and some Representation-based errors

  // How the client and API can/should communicate
  lazy override val supportedContentTypes = List(
    "text/xml"
    )
  lazy override val defaultContentType = Some("text/xml")

  // The resources which this API exposes for CRUD
  override val apiResources = PrestaShopApi
}