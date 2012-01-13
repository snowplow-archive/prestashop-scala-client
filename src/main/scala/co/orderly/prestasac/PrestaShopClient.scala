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
import utils._
import adapters.ApacheHttpClientAdapter

class PrestaShopClient(
  apiUri: String,
  apiKey: String) extends Client(Some(apiUri), None, apiKey, "") with ApacheHttpClientAdapter {

  // Note: we use lazy vals so we can validate in the Narcolepsy super constructor as per
  // http://stackoverflow.com/questions/7475291/how-do-i-validate-a-subclassed-field-in-my-scala-abstract-parent-object

  // Set the name of this client
  lazy override val name = generated.Settings.name

  // Set the version
  lazy override val version = generated.Settings.version

  // PrestaShop web service only supports XML
  lazy override val contentTypes = List(
    "text/xml"
    )

  // The resources which this API exposes for CRUD
  lazy override val resources = PrestaShopApi
}