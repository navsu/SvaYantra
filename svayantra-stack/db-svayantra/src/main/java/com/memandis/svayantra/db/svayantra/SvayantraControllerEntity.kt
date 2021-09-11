package com.memandis.svayantra.db.svayantra

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.memandis.svayantra.core.domain.DomainEntity

const val SVAYANTRA_CONTROLLER_TABLE_NAME = "svayantra_controllers"

@Entity(tableName = SVAYANTRA_CONTROLLER_TABLE_NAME)
class SvayantraControllerEntity(
    val internalId: Int? = null,
    @PrimaryKey
    val remoteId: Int,
    val name: String,
    val password: String,
    val status: Int,
    val url: String,
    val ownerAvatarUrl: String
) : DomainEntity
