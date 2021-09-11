package com.memandis.svayantra.ui.dashboard.adapter.items

class SvaYantraControllerItem(
    val controllerId: Int,
    val name: String,
    val password: String,
    val status: Int,
    val url: String,
    val ownerAvatarUrl: String
) : ControllerItem {
    override val itemViewType: Int
        get() = ControllerItem.SVAYANTRA_CONTROLLER_VIEW_TYPE
}
