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
 * The Country representation holds the information pertaining to a
 * country in PrestaShop.
 *
 * A typical representation looks something like this:
 *
 * <prestashop xmlns:xlink="http://www.w3.org/1999/xlink">
 *   <country>
 * 	  <id><![CDATA[30]]></id>
 * 	  <id_zone xlink:href="http://www.psychicbazaar.com/api/zones/4"><![CDATA[4]]></id_zone>
 * 	  <id_currency></id_currency>
 * 	  <iso_code><![CDATA[ZA]]></iso_code>
 * 	  <call_prefix><![CDATA[27]]></call_prefix>
 * 	  <active><![CDATA[1]]></active>
 * 	  <contains_states><![CDATA[0]]></contains_states>
 * 	  <need_identification_number><![CDATA[0]]></need_identification_number>
 * 	  <need_zip_code><![CDATA[1]]></need_zip_code>
 * 	  <zip_code_format><![CDATA[NNNN]]></zip_code_format>
 * 	  <display_tax_label><![CDATA[1]]></display_tax_label>
 * 	  <name><language id="1" xlink:href="http://www.psychicbazaar.com/api/languages/1"><![CDATA[South Africa]]></language></name>
 *   </country>
 * </prestashop>
 */

// TODO note should extend PrestaShopIdentity
