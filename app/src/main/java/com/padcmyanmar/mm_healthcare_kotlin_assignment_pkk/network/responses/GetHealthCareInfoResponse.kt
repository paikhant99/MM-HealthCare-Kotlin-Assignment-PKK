package com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.data.vos.HealthCareInfoVO

/**
 * Created by paikhantko on 7/14/18.
 */
class GetHealthCareInfoResponse {

    @SerializedName("code")
    private var code: Int=0

    @SerializedName("message")
    private var message: String=""

    @SerializedName("healthcare-info")
    private var healthCareInfos: List<HealthCareInfoVO>?=null

    fun getCode():Int{
        return code
    }

    fun getMessage():String{
        return message
    }

    fun getHealthCareInfos():List<HealthCareInfoVO>{
        if(healthCareInfos==null){
            healthCareInfos=ArrayList()
        }
        val i=healthCareInfos
        return i!!
    }
}