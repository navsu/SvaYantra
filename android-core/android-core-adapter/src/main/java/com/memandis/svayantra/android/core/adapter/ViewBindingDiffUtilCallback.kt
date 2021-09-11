package com.memandis.svayantra.android.core.adapter

import androidx.recyclerview.widget.DiffUtil

abstract class ViewBindingDiffUtilCallback<Item : ViewBindingAdapterItem> :
    DiffUtil.ItemCallback<Item>()
