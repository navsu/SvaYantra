package com.memandis.svayantra.ui.dashboard

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dashboardVMModule = module {
    viewModel {
        DashboardViewModel(
            refreshSvaYantraControllersUseCase = get(),
            observeSvaYantraControllersUseCase = get()
        )
    }
}
