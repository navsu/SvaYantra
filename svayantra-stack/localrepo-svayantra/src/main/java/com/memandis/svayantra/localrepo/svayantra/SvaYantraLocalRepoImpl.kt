package com.memandis.svayantra.localrepo.svayantra

import com.memandis.svayantra.db.svayantra.SvayantraControllerDao
import com.memandis.svayantra.db.svayantra.SvayantraControllerEntity
import kotlinx.coroutines.flow.Flow

class SvaYantraLocalRepoImpl(private val svayantraControllerDao: SvayantraControllerDao) : SvaYantraLocalRepo {

    override suspend fun addController(svayantraControllerEntity: SvayantraControllerEntity) =
        svayantraControllerDao.addController(svayantraControllerEntity = svayantraControllerEntity)

    override suspend fun updateControllers(updateSvayantraControllerEntities: List<SvayantraControllerEntity>) {
        svayantraControllerDao.addControllers(updatedControllers = updateSvayantraControllerEntities)
    }

    override fun observeSvayantraControllers(): Flow<List<SvayantraControllerEntity>> =
        svayantraControllerDao.observeSvayantraControllers()
}
