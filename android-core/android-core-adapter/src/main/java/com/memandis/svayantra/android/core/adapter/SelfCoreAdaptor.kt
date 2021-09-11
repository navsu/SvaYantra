package com.memandis.svayantra.android.core.adapter
//
// import android.annotation.SuppressLint
// import android.view.LayoutInflater
// import android.view.View
// import android.view.ViewGroup
// import androidx.annotation.LayoutRes
// import androidx.recyclerview.widget.DiffUtil
// import androidx.recyclerview.widget.ListAdapter
// import androidx.recyclerview.widget.RecyclerView
// import androidx.databinding.ViewDataBinding
//
// open class SelfBaseAdaptor<T : ViewBindingAdapterItem, VB : ViewDataBinding>(
//     @LayoutRes val layout: Int,
//     private val baseListener: SelfBaseListener<T>,
//     diffCallBack: SelfBaseDiffCallback<T>
// ) : ListAdapter<T, SelfBaseAdaptor.SelfBaseViewHolder<T>>(diffCallBack)
// {
//    var emptyView: View? = null
//        set(v) {
//            field = v
//            updateEmptyView()
//        }
//
//    var data: List<T> = emptyList()
//        set(v) {
//            field = v
//            notifyDataSetChanged()
//        }
//
//    private fun updateEmptyView() {
//        emptyView?.visibility = if (data.isEmpty()) View.VISIBLE else View.GONE
//    }
//
//    class SelfBaseViewHolder<T>(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
//    {
//        fun <V> bind(item: T?, viewModel: V, baseListener: SelfBaseListener<T>) {
//            binding.setVariable(BR.item, item)
//            binding.setVariable(BR.viewModel, viewModel)
//            binding.setVariable(BR.clickListener, baseListener)
//            binding.executePendingBindings()
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  SelfBaseViewHolder<T> {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val binding: ViewDataBinding = DataBindingUtil.inflate( layoutInflater, layout, parent,false )
//        return  SelfBaseViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: SelfBaseViewHolder<T>, position: Int) {
//        holder.bind(data.getOrNull(position), viewModel, baseListener)
//    }
//
//    override fun getItemCount(): Int { return data.size }
//
// }
//
// @BindingAdapter("selfAdapterData")
// fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: List<T>?) {
//    if (data == null) {
//        return
//    }
//    if (recyclerView.adapter is SelfBaseAdaptor<*, *>) {
//        (recyclerView.adapter as SelfBaseAdaptor<T, *>).data = data
//    }
// }
//
// @BindingAdapter("empty_view")
// fun setRecyclerViewProperties(recyclerView: RecyclerView, view: View) {
//    if (recyclerView.adapter is SelfBaseAdaptor<*, *>) {
//        (recyclerView.adapter as SelfBaseAdaptor<*, *>).emptyView = view
//    }
// }
//
// open class SelfBaseListener<T>(val clickListener: (item: T) -> Unit) {
//    fun onClick(item: T) = clickListener(item)
// }
//
// open class SelfBaseDiffCallback<T> : DiffUtil.ItemCallback<T>() {
//
//    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
//        return oldItem == newItem
//    }
//
//    @SuppressLint("DiffUtilEquals")
//    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
//        return oldItem == newItem
//    }
// }
