package com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerViewAccessibilityDelegate
import android.view.ViewGroup
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.R
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.data.vos.HealthCareInfoVO
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.delegates.HealthCareDelegate
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.viewholders.BaseViewHolder
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.viewholders.HealthCareInfoViewHolder

/**
 * Created by paikhantko on 7/14/18.
 */
class HealthCareAdapter(context: Context,private val mDelegate: HealthCareDelegate): BaseRecyclerAdapter<HealthCareInfoViewHolder, HealthCareInfoVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<HealthCareInfoVO> {
        val healthCareItemView=mLayoutInflater.inflate(R.layout.view_items_health_care_info,parent,false)
        return HealthCareInfoViewHolder(healthCareItemView,mDelegate)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}