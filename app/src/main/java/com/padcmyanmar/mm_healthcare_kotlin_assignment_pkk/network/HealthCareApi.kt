package com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.network

import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.network.responses.GetHealthCareInfoResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by paikhantko on 7/14/18.
 */
interface HealthCareApi {

    @FormUrlEncoded
    @POST("mm-healthcare/GetHealthcareInfo.php")
    fun loadHealthCareInfos(
            @Field("access_token") accessToken: String):Call<GetHealthCareInfoResponse>
}