package com.memandis.svayantra.usecase.svayantra

import com.memandis.svayantra.core.dispatchers.AppCoroutineDispatchers
import com.memandis.svayantra.core.interactor.NoResultUseCase
import com.memandis.svayantra.db.svayantra.SvayantraControllerEntity
import com.memandis.svayantra.localrepo.svayantra.SvaYantraLocalRepo
import kotlinx.coroutines.CoroutineDispatcher

class AddControllerUseCase(
    private val appCoroutineDispatchers: AppCoroutineDispatchers,
    private val svayantraLocalRepo: SvaYantraLocalRepo
) : NoResultUseCase<AddControllerUseCase.Params>() {

    data class Params(
        val controllerName: String,
        val controllerPassword: String,
        val controllerStatus: Int,
        val controllerUrl: String
    )

    override val workDispatcher: CoroutineDispatcher
        get() = appCoroutineDispatchers.io

    override suspend fun run(params: Params) {
        svayantraLocalRepo.addController(
            svayantraControllerEntity = SvayantraControllerEntity(
                remoteId = 1234,
                name = params.controllerName,
                password = params.controllerPassword,
                status = params.controllerStatus,
                url = params.controllerUrl,
                ownerAvatarUrl = "https://selfless.s3-eu-west-1.amazonaws.com/data/user_icon.png"
            )
        )
    }
}
