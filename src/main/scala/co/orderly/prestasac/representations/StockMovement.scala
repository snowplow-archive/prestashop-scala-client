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
 * The StockMovement representation holds the information pertaining
 * to a stock movement in PrestaShop.
 *
 * A typical representation looks something like this:
 *
 * <prestashop xmlns:xlink="http://www.w3.org/1999/xlink">
 *   <stock_movement>
 *     <id><![CDATA[30]]></id>
 *     <id_product xlink:href="http://www.psychicbazaar.com/api/products/1"><![CDATA[1]]></id_product>
 *     <id_product_attribute xlink:href="http://www.psychicbazaar.com/api/product_option_values/42"><![CDATA[42]]></id_product_attribute>
 *     <id_order></id_order>
 *     <id_employee xlink:href="http://www.psychicbazaar.com/api/employees/1"><![CDATA[1]]></id_employee>
 *     <id_stock_mvt_reason xlink:href="http://www.psychicbazaar.com/api/stock_movement_reasons/2"><![CDATA[2]]></id_stock_mvt_reason>
 *     <quantity><![CDATA[50]]></quantity>
 *     <date_add><![CDATA[2011-07-06 10:29:17]]></date_add>
 *     <date_upd><![CDATA[2011-07-06 10:29:17]]></date_upd>
 *   </stock_movement>
 * </prestashop>
 */

// TODO