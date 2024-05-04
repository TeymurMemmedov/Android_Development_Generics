package com.example.mygenerics.rvAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView


class SimpleGenericRvAdapter<RvItem:Any>(
    @LayoutRes val layoutId:Int,
    val viewOperations:(View,RvItem,Int)->Unit
) :RecyclerView.Adapter<SimpleGenericRvAdapter<RvItem>.ViewHolder>() {

    lateinit var items : List<RvItem>

    fun setRvItems(list:List<RvItem>){
        items = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val view: View):RecyclerView.ViewHolder(view){
        fun bind(item:RvItem,position: Int) = viewOperations.invoke(view,item,position)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId,parent,false)
        return  ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item,position)
    }
}