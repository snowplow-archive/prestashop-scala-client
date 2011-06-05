package co.orderly

/* Distributed as part of prestasac, a xxx.
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
/**
 * Provides a pair of classes for interacting with the Amazon Product API from Scala.
 *
 * ==Overview==
 * The main class to use is [[main.scala.co.orderly.scalapac.scalapac.OperationHelper]]. Create an instance
 * with your Amazon API connection details like so:
 *
 * val opHelper = new OperationHelper(awsAccessKeyId     = "Enter here",
 *                                    awsSecretKey       = "Enter here",
 *                                    awsAssociateTagKey = "Enter here"
 *                                    )
 *
 * Once you have created an opHelper, you can then run operations against the Amazon Product
 * API using the execute command:
 *
 * val (code, xml) = opHelper.execute("ItemSearch", Map("SearchIndex"    -> "Books",
 *                                                      "Keywords"       -> "harry potter",
 *                                                      "ResponseGroup"  -> "ItemAttributes,Offers"
 *                                                     ))
 *
 * For testing queries in the Scala console there is also a helper method, use like so:
 *
 * scala> opHelper.debug("ItemSearch", ...)
 */
package object prestasac {
}
