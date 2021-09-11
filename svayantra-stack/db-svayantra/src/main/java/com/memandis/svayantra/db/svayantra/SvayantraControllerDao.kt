package com.memandis.svayantra.db.svayantra

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SvayantraControllerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addController(svayantraControllerEntity: SvayantraControllerEntity)

    @Query("SELECT * FROM $SVAYANTRA_CONTROLLER_TABLE_NAME")
    fun observeSvayantraControllers(): Flow<List<SvayantraControllerEntity>>

    @Query("DELETE FROM $SVAYANTRA_CONTROLLER_TABLE_NAME")
    suspend fun deleteAllControllers()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addControllers(updatedControllers: List<SvayantraControllerEntity>)
}
