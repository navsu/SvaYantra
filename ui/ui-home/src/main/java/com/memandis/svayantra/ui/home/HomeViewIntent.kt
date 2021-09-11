package com.memandis.svayantra.ui.home

sealed class HomeViewIntent {
    object None : HomeViewIntent()
    data class AddSvaYantraController(
        val controllerName: String,
        val controllerPassword: String,
        val controllerStatus: Int,
        val controllerUrl: String
    ) : HomeViewIntent()
}
