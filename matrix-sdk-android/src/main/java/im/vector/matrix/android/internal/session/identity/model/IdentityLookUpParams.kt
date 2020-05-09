/*
 * Copyright (c) 2020 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.matrix.android.internal.session.identity.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Ref: https://github.com/matrix-org/matrix-doc/blob/hs/hash-identity/proposals/2134-identity-hash-lookup.md
 */
@JsonClass(generateAdapter = true)
internal data class IdentityLookUpParams(
        /**
         * Required. The addresses to look up. The format of the entries here depend on the algorithm used.
         * Note that queries which have been incorrectly hashed or formatted will lead to no matches.
         */
        @Json(name = "addresses")
        val hashedAddresses: List<String>,

        /**
         * Required. The algorithm the client is using to encode the addresses. This should be one of the available options from /hash_details.
         */
        @JvmField
        @Json(name = "algorithm")
        val algorithm: String,

        /**
         * Required. The pepper from /hash_details. This is required even when the algorithm does not make use of it.
         */
        @JvmField
        @Json(name = "pepper")
        val pepper: String
)