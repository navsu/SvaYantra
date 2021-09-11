package com.memandis.svayantra.test

import com.memandis.svayantra.db.svayantra.SvayantraControllerEntity
import com.memandis.svayantra.localrepo.svayantra.SvaYantraLocalRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MockSvaYantraLocalRepo(
    private val observedSvaYantraControllers: List<SvayantraControllerEntity> = emptyList()
) : SvaYantraLocalRepo {

    val addRepoRenders = RenderRecorder<SvayantraControllerEntity>()
    val updateRepoRenders = RenderRecorder<List<SvayantraControllerEntity>>()

    override suspend fun addController(svayantraControllerEntity: SvayantraControllerEntity) =
        addRepoRenders.add(svayantraControllerEntity)

    override suspend fun updateControllers(updateSvayantraControllerEntities: List<SvayantraControllerEntity>) =
        updateRepoRenders.add(updateSvayantraControllerEntities)

    override fun observeSvayantraControllers(): Flow<List<SvayantraControllerEntity>> =
        flowOf(observedSvaYantraControllers)

    fun reset() {
        addRepoRenders.reset()
        updateRepoRenders.reset()
    }
}
