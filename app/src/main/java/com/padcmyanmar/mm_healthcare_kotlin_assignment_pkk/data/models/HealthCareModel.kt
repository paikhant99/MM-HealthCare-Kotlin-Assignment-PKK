package com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.data.models

import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.events.DataEvent
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.network.HealthCareDataAgent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * Created by paikhantko on 7/14/18.
 */
class HealthCareModel {

    companion object {
        private var INSTANCE:HealthCareModel?=null
        fun getInstance():HealthCareModel{
            if(INSTANCE==null){
                INSTANCE= HealthCareModel()
            }
            val i=INSTANCE
            return i!!
        }
    }

    private constructor(){
        EventBus.getDefault().register(this)
    }

    fun loadHealthCareInfos(){
        HealthCareDataAgent.getInstance().loadHealthCareInfos()
    }


    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onHealthCareInfosLoadedEvent(healthCareInfosLoadedEvent: DataEvent.HealthCareInfosLoadedEvent){

    }
}