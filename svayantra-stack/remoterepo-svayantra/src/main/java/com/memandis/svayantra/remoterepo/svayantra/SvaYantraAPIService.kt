package com.memandis.svayantra.remoterepo.svayantra

import retrofit2.http.GET
import retrofit2.http.Path

interface SvaYantraAPIService {
    @GET("{url}/{upass}")
    suspend fun fetchSvaYantraControllersFor(
        @Path("url") url: String,
        @Path("cpass") cpass: String
    ): List<SvaYantraControllerModel>
}
