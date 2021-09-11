package com.memandis.svayantra.ui.dashboard

sealed class DashboardViewIntent {
    object None : DashboardViewIntent()
    object Refresh : DashboardViewIntent()
}
