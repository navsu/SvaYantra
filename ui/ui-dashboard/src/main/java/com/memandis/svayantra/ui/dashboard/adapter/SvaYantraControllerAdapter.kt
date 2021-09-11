package com.memandis.svayantra.ui.dashboard.adapter

import android.view.ViewGroup
import coil.load
import coil.transform.CircleCropTransformation
import com.memandis.svayantra.android.core.adapter.ViewBindingAdapter
import com.memandis.svayantra.android.core.adapter.ViewBindingViewHolder
import com.memandis.svayantra.ui.dashboard.R
import com.memandis.svayantra.ui.dashboard.adapter.items.ControllerItem
import com.memandis.svayantra.ui.dashboard.adapter.items.SvaYantraControllerItem
import com.memandis.svayantra.ui.dashboard.databinding.ItemSvayantraControllerBinding

class SvaYantraControllerAdapter :
    ViewBindingAdapter<ControllerItem, ItemSvayantraControllerBinding>(`ControllerItemDiffCallback`) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewBindingViewHolder<ControllerItem, ItemSvayantraControllerBinding> {
        val inflater = parent.layoutInflater
        return when (viewType) {
            ControllerItem.SVAYANTRA_CONTROLLER_VIEW_TYPE -> {
                val binding = ItemSvayantraControllerBinding.inflate(inflater, parent, false)
                GithubRepoViewHolder(binding)
            }
            else -> throw IllegalStateException("Unknown viewType: $viewType")
        }
    }

    inner class GithubRepoViewHolder(
        binding: ItemSvayantraControllerBinding
    ) : ViewBindingViewHolder<ControllerItem, ItemSvayantraControllerBinding>(binding) {

        override fun bind(item: ControllerItem) {
            item as SvaYantraControllerItem

            binding.controllerIcon.load(item.ownerAvatarUrl) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
            binding.controllerName.text = item.name
            binding.controllerStatus.text = binding.root.context.getString(R.string.controller_status, item.status)
            binding.controllerUrl.text = item.url
            binding.controllerLocation.text = item.password
        }
    }
}
