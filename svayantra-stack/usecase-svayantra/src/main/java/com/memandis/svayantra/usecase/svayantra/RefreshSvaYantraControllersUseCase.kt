package com.memandis.svayantra.usecase.svayantra

import com.memandis.svayantra.core.dispatchers.AppCoroutineDispatchers
import com.memandis.svayantra.core.interactor.NoResultUseCase
import com.memandis.svayantra.localrepo.svayantra.SvaYantraLocalRepo
import com.memandis.svayantra.remoterepo.svayantra.SvaYantraControllerModel
import com.memandis.svayantra.remoterepo.svayantra.SvaYantraRemoteRepo
import kotlinx.coroutines.CoroutineDispatcher

class RefreshSvaYantraControllersUseCase(
    private val appCoroutineDispatchers: AppCoroutineDispatchers,
    private val svaYantraRemoteRepo: SvaYantraRemoteRepo,
    private val svaYantraLocalRepo: SvaYantraLocalRepo

) : NoResultUseCase<RefreshSvaYantraControllersUseCase.Params>() {

    data class Params(val url: String, val cpass: String)

    override val workDispatcher: CoroutineDispatcher
        get() = appCoroutineDispatchers.io

    override suspend fun run(params: Params) {
        val remoteRepos: List<SvaYantraControllerModel> =
            svaYantraRemoteRepo.fetchSvaYantraControllersFor(url = params.url, cpass = params.cpass)
        svaYantraLocalRepo.updateControllers(
            updateSvayantraControllerEntities = remoteRepos.map(SvaYantraControllerConverter::convert)
        )
    }
}
