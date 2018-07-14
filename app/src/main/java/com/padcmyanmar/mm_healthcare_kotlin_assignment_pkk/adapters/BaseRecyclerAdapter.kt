package com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.viewholders.BaseViewHolder

/**
 * Created by paikhantko on 7/14/18.
 */
abstract class BaseRecyclerAdapter<T,W>(context: Context) : RecyclerView.Adapter<BaseViewHolder<W>>() {

    protected var mData: MutableList<W>? = null
    protected var mLayoutInflater: LayoutInflater

    init {
        mData=ArrayList()
        mLayoutInflater= LayoutInflater.from(context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<W>, position: Int) {
        holder.setData(mData!![position])
    }

    override fun getItemCount(): Int {
        return mData!!.size
    }

    fun setNewData(mNewData: MutableList<W>){
        mData=mNewData;
        notifyDataSetChanged()
    }
}