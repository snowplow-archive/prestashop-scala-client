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
package co.orderly.prestasac.representations.shared
// TODO move into Narcolepsy
 
import org.eclipse.persistence.oxm.XMLNameTransformer
 
class CamelCase2Underscore extends XMLNameTransformer {
 
  def transformRootElementName(name: String): String = name
 
  def transformTypeName(name: String): String = name

  def transformAttributeName(name: String): String = name

  def transformElementName(name: String): String =
    name.toList.map(c => if(c.isUpper) "_" + c.toLower else c).mkString
}