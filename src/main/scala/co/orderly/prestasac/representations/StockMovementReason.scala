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
package co.orderly.prestasac.representations

/**
 * The StockMovementReason representation holds the reason (justification) for
 * a given stock movement within PrestaShop.
 *
 * A typical representation looks something like this:
 *
 * <prestashop xmlns:xlink="http://www.w3.org/1999/xlink">
 *   <stock_movement_reason>
 *     <id><![CDATA[5]]></id>
 *     <name><language id="1" xlink:href="http://www.psychicbazaar.com/api/languages/1"><![CDATA[Restocking]]></language></name>
 *     <date_add><![CDATA[2011-07-06 10:29:12]]></date_add>
 *     <date_upd><![CDATA[2011-07-06 10:29:12]]></date_upd>
 *   </stock_movement_reason>
 * </prestashop>
 */

// TODO - note this is a full representation - so should inherit from PrestaShopTimestampedIdentity
