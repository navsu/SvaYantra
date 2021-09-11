package com.memandis.svayantra.ui.dashboard.adapter

import com.memandis.svayantra.android.core.adapter.ViewBindingDiffUtilCallback
import com.memandis.svayantra.ui.dashboard.adapter.items.ControlItem
import com.memandis.svayantra.ui.dashboard.adapter.items.SvaYantraControlItem

object `ControlItemDiffCallback` : ViewBindingDiffUtilCallback<ControlItem>() {
    override fun areItemsTheSame(oldItem: ControlItem, newItem: ControlItem): Boolean {
        if (oldItem !is SvaYantraControlItem || newItem !is SvaYantraControlItem) {
            return false
        }

        return oldItem.controlId == newItem.controlId
    }

    override fun areContentsTheSame(oldItem: ControlItem, newItem: ControlItem): Boolean {
        if (oldItem !is SvaYantraControlItem || newItem !is SvaYantraControlItem) {
            return false
        }

        return oldItem.controlId == newItem.controlId
    }
}
