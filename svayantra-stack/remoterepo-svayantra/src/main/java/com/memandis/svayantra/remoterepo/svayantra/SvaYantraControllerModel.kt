package com.memandis.svayantra.remoterepo.svayantra

import com.memandis.svayantra.core.domain.DomainModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SvaYantraControllerModel(
    val id: Int,
    val name: String,
    @Json(name = "name")
    val password: String,
    @Json(name = "pass")
    val status: Int,
    @Json(name = "ip")
    val url: String,
    @Json(name = "owner")
    val owner: SvaYantraControllerOwner
) : DomainModel

@JsonClass(generateAdapter = true)
data class SvaYantraControllerOwner(
    @Json(name = "avatar_url")
    val avatarUrl: String
)
