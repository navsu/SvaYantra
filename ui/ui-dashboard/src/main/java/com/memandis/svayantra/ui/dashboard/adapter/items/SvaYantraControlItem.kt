package com.memandis.svayantra.ui.dashboard.adapter.items

class SvaYantraControlItem(
    val controlId: Int,
    val name: String,
    val password: String,
    val status: Int,
    val timer: Int, // 24 hr 64800 12 hr 43200
    val dimmer: Int,
    val url: String,
    val controlIconUrl: String
) : ControlItem {
    override val itemViewType: Int
        get() = ControlItem.SVAYANTRA_CONTROL_VIEW_TYPE
}
