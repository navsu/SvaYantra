package com.memandis.svayantra.localrepo.svayantra

import com.memandis.svayantra.db.svayantra.SvayantraControllerEntity
import kotlinx.coroutines.flow.Flow

interface SvaYantraLocalRepo {
    suspend fun addController(svayantraControllerEntity: SvayantraControllerEntity)
    suspend fun updateControllers(updateSvayantraControllerEntities: List<SvayantraControllerEntity>)
    fun observeSvayantraControllers(): Flow<List<SvayantraControllerEntity>>
}
