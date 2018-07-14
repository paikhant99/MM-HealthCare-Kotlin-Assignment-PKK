package com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by paikhantko on 7/14/18.
 */
abstract class BaseViewHolder<W>(itemView: View) :RecyclerView.ViewHolder(itemView) ,View.OnClickListener{

    protected var mData: W?=null

    init {
        itemView.setOnClickListener(this)
    }

    abstract fun setData(w: W)
}