package com.example.mygenerics.rvAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class GenericRvAdapter<RvItem : Any, VB : ViewBinding>(
    private val inflater: (LayoutInflater, ViewGroup, Boolean) -> VB,
    private val bindViewHolder: (VB, RvItem, position:Int) -> Unit
) : RecyclerView.Adapter<GenericRvAdapter.GenericViewHolder<VB>>() {

     class GenericViewHolder<VB : ViewBinding>(val binding: VB) :
        RecyclerView.ViewHolder(binding.root)

    var itemList: List<RvItem> = emptyList()

    fun sendListToAdapter(list: List<RvItem>) {
        itemList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenericViewHolder<VB> {
        val binding = inflater.invoke(LayoutInflater.from(parent.context), parent, false)

        return GenericViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: GenericViewHolder<VB>,
        position: Int
    ) {
        val item = itemList[position]
        bindViewHolder.invoke(holder.binding, item,position)
    }

    override fun getItemCount(): Int = itemList.size
}
