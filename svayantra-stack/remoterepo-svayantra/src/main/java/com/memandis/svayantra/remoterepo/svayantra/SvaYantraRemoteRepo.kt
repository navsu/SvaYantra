package com.memandis.svayantra.remoterepo.svayantra

interface SvaYantraRemoteRepo {
    suspend fun fetchSvaYantraControllersFor(url: String, cpass: String): List<SvaYantraControllerModel>
}
