package com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.data.vos.HealthCareInfoVO
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.delegates.HealthCareDelegate
import kotlinx.android.synthetic.main.view_items_health_care_info.view.*

/**
 * Created by paikhantko on 7/14/18.
 */
class HealthCareInfoViewHolder(itemView: View,private val mDelegate: HealthCareDelegate) : BaseViewHolder<HealthCareInfoVO>(itemView) {


    /**
     * Set Data for Each View Item
     */
    override fun setData(data: HealthCareInfoVO) {
        itemView.tvHealthCareTitle.text=data.title
        itemView.tvAuthorName.text=data.author!!.author_name
        itemView.tvInfoType.text=data.infoType;
        Glide.with(itemView.context).load(data.image).into(itemView.ivHealthCareImage)
    }

    override fun onClick(v: View?) {
        mDelegate.onTapView()
    }
}