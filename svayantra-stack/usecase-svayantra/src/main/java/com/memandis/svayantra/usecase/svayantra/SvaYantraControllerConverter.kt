package com.memandis.svayantra.usecase.svayantra

import com.memandis.svayantra.core.domain.DomainModelToEntityConverter
import com.memandis.svayantra.db.svayantra.SvayantraControllerEntity
import com.memandis.svayantra.remoterepo.svayantra.SvaYantraControllerModel

object SvaYantraControllerConverter : DomainModelToEntityConverter<SvaYantraControllerModel, SvayantraControllerEntity> {
    override fun convert(input: SvaYantraControllerModel): SvayantraControllerEntity =
        SvayantraControllerEntity(
            remoteId = input.id,
            name = input.name,
            password = input.password,
            status = input.status,
            url = input.url,
            ownerAvatarUrl = input.owner.avatarUrl
        )
}
