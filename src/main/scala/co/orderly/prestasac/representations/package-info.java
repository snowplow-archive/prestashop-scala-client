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

// This is in Java because this has not been fixed yet: https://issues.scala-lang.org/browse/SI-3600
@XmlNameTransformer(co.orderly.prestasac.representations.shared.CamelCase2Underscore.class)
package co.orderly.prestasac.representations;

import org.eclipse.persistence.oxm.annotations.XmlNameTransformer;