package com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.events

import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.data.vos.HealthCareInfoVO

/**
 * Created by paikhantko on 7/14/18.
 */
class DataEvent {

    class HealthCareInfosLoadedEvent(val mHealthCareInfos: List<HealthCareInfoVO>)

    class EmptyDataLoadedEvent(val errorMsg: String? = "Empty Body Response")
}