package com.memandis.svayantra.ui.dashboard.adapter

import com.memandis.svayantra.android.core.adapter.ViewBindingDiffUtilCallback
import com.memandis.svayantra.ui.dashboard.adapter.items.ControllerItem
import com.memandis.svayantra.ui.dashboard.adapter.items.SvaYantraControllerItem

object ControllerItemDiffCallback : ViewBindingDiffUtilCallback<ControllerItem>() {
    override fun areItemsTheSame(oldItem: ControllerItem, newItem: ControllerItem): Boolean {
        if (oldItem !is SvaYantraControllerItem || newItem !is SvaYantraControllerItem) {
            return false
        }

        return oldItem.controllerId == newItem.controllerId
    }

    override fun areContentsTheSame(oldItem: ControllerItem, newItem: ControllerItem): Boolean {
        if (oldItem !is SvaYantraControllerItem || newItem !is SvaYantraControllerItem) {
            return false
        }

        return oldItem.controllerId == newItem.controllerId
    }
}
