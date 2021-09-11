package com.memandis.svayantra.test

import com.memandis.svayantra.remoterepo.svayantra.SvaYantraControllerModel
import com.memandis.svayantra.remoterepo.svayantra.SvaYantraRemoteRepo

class MockSvaYantraRemoteRepo(
    private val fetchedRepos: List<SvaYantraControllerModel>
) : SvaYantraRemoteRepo {
    override suspend fun fetchSvaYantraControllersFor(
        url: String,
        cpass: String
    ): List<SvaYantraControllerModel> =
        fetchedRepos
}
