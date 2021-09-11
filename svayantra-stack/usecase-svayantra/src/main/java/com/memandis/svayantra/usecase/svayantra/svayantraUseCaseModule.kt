package com.memandis.svayantra.usecase.svayantra

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.dsl.module

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
val svayantraUseCaseModule = module {
    factory {
        ObserveSvaYantraControllersUseCase(
            appCoroutineDispatchers = get(),
            svaYantraLocalRepo = get()
        )
    }

    factory {
        RefreshSvaYantraControllersUseCase(
            appCoroutineDispatchers = get(),
            svaYantraRemoteRepo = get(),
            svaYantraLocalRepo = get()
        )
    }

    factory {
        AddControllerUseCase(
            appCoroutineDispatchers = get(),
            svayantraLocalRepo = get()
        )
    }
}
