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
import utils._
import adapters.ApacheHttpClientAdapter

class PrestaShopClient(
  apiUri: String,
  apiKey: String) extends Client(Some(apiUri), Some("text/xml"), apiKey, "") with ApacheHttpClientAdapter {

  // Note: we use lazy vals so we can validate in the Narcolepsy super constructor as per
  // http://stackoverflow.com/questions/7475291/how-do-i-validate-a-subclassed-field-in-my-scala-abstract-parent-object

  // Configuration which relates to this client
  lazy override val clientName = "PrestaShop Scala Client" // TODO: can we not pull this from the SBT?
  lazy override val clientVersion = new RestfulVersion("0.2") // TODO: should be set automatically
  lazy override val charSet = RestfulHelpers.defaultCharSet // TODO: urg, shouldn't have to be set here like this

  // TODO: move all this into a compatibility lambda
  override val minVersionSupported = Some(new RestfulVersion("1.4.0.17"))
  override val maxVersionSupported = Some(new RestfulVersion("1.4.7.5"))
  override val versionHeader = Some("PSWS-Version")

  // Configuration which relates to the API itself
  lazy override val defaultRootUri = None // Not hosted

  lazy override val errorFormat = MixedErrors // Plaintext and some Representation-based errors. TODO: I think this is wrong for PrestaShop. Should be plaintext

  // How the client and API can/should communicate
  lazy override val supportedContentTypes = List(
    "text/xml"
    )
  lazy override val defaultContentType = Some("text/xml")

  // The resources which this API exposes for CRUD
  override val apiResources = PrestaShopApi
}