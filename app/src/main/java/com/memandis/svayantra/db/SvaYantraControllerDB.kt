package com.memandis.svayantra.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.memandis.svayantra.db.svayantra.SvayantraControllerDao
import com.memandis.svayantra.db.svayantra.SvayantraControllerEntity

@Database(entities = [SvayantraControllerEntity::class], exportSchema = false, version = 1)
abstract class SvaYantraControllerDB : RoomDatabase() {
    companion object {
        const val DB_NAME = "svayantra_app.db"
    }

    abstract fun svayantraControllerDAO(): SvayantraControllerDao
}
