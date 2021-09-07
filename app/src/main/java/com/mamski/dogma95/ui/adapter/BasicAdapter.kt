package com.mamski.dogma95.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BasicAdapter<T>: RecyclerView.Adapter<BaseViewHolder<T>>() {

    protected var data: ArrayList<T>? = null
    abstract fun getViewHolder(view: ViewGroup): BaseViewHolder<T>
    abstract fun handleOtherBinding()

    open fun printLog(msg: String) {
        println("${javaClass.simpleName}: $msg")
    }

    override fun getItemCount(): Int = data!!.size

    protected fun getItemAt(position: Int): T {
        return data?.get(position)!!
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(getItemAt(position))
        handleOtherBinding()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
       return getViewHolder(parent)
    }

}