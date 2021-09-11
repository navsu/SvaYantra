package com.memandis.svayantra.ui.home

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeVMModule = module {
    viewModel { HomeViewModel(
        addControllerUseCase = get()
    ) }
}
