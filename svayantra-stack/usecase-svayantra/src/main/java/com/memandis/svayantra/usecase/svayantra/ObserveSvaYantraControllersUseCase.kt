package com.memandis.svayantra.usecase.svayantra

import com.memandis.svayantra.core.dispatchers.AppCoroutineDispatchers
import com.memandis.svayantra.core.interactor.FlowUseCase
import com.memandis.svayantra.db.svayantra.SvayantraControllerEntity
import com.memandis.svayantra.localrepo.svayantra.SvaYantraLocalRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
class ObserveSvaYantraControllersUseCase(
    private val appCoroutineDispatchers: AppCoroutineDispatchers,
    private val svaYantraLocalRepo: SvaYantraLocalRepo
) : FlowUseCase<List<SvayantraControllerEntity>, Unit>() {

    override val dispatcher: CoroutineDispatcher
        get() = appCoroutineDispatchers.io

    override fun doWork(params: Unit): Flow<List<SvayantraControllerEntity>> =
        svaYantraLocalRepo.observeSvayantraControllers()
}
