package com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.network

import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.events.DataEvent
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.events.ErrorEvent
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.network.responses.GetHealthCareInfoResponse
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.utils.HealthCareAppConstants
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by paikhantko on 7/14/18.
 */
class HealthCareDataAgent {

    companion object {
        private var INSTANCE: HealthCareDataAgent?=null
        fun getInstance():HealthCareDataAgent{
            if (INSTANCE==null){
                INSTANCE= HealthCareDataAgent()
            }

            val i= INSTANCE
            return i!!
        }
    }


    private var mHealthCareApi: HealthCareApi

    private constructor(){
        val okHttpClient: OkHttpClient=OkHttpClient.Builder()
                .connectTimeout(60,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .build()

        val retrofit: Retrofit=Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://padcmyanmar.com/padc-5/")
                .client(okHttpClient)
                .build()

        mHealthCareApi=retrofit.create(HealthCareApi::class.java)
    }

    fun loadHealthCareInfos(){
        val healthCareCall=mHealthCareApi.loadHealthCareInfos(HealthCareAppConstants.VALUE_ACCESS_TOKEN)
        healthCareCall.enqueue(object :Callback<GetHealthCareInfoResponse>{
            override fun onFailure(call: Call<GetHealthCareInfoResponse>?, t: Throwable?) {
                val errorEvent=ErrorEvent.ApiErrorEvent(t)
                EventBus.getDefault().post(errorEvent)
            }

            override fun onResponse(call: Call<GetHealthCareInfoResponse>, response: Response<GetHealthCareInfoResponse>) {
                val healthCareResponse: GetHealthCareInfoResponse?=response.body()
                if(healthCareResponse!=null &&
                        healthCareResponse.getCode()==200 &&
                        healthCareResponse.getHealthCareInfos()!!.isNotEmpty()){
                    val dataEvent=DataEvent.HealthCareInfosLoadedEvent(healthCareResponse.getHealthCareInfos());
                    EventBus.getDefault().post(dataEvent)
                } else {
                    if(healthCareResponse != null)
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent(healthCareResponse.getMessage()))
                    else
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent())
                }
            }
        })
    }


}