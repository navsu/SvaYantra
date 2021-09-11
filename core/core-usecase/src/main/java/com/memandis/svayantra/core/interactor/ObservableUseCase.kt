package com.memandis.svayantra.core.interactor

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

interface ObservableUseCase<Type> {
    val dispatcher: CoroutineDispatcher
    fun observe(): Flow<Type>
}
