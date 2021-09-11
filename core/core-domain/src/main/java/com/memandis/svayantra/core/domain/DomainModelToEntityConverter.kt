package com.memandis.svayantra.core.domain

interface DomainModelToEntityConverter<Input : DomainModel, Output : DomainEntity> {
    fun convert(input: Input): Output
}
