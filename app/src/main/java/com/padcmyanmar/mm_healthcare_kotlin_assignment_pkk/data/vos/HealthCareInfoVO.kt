package com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by paikhantko on 7/14/18.
 */
class HealthCareInfoVO(@SerializedName("id") var id: Long=0,
                       @SerializedName("title") var title: String="",
                       @SerializedName("image") var image: String="",
                       @SerializedName("author") var author: AuthorVO?=null,
                       @SerializedName("short-description") var shortDescription: String="",
                       @SerializedName("published-date") var publishedDate: String="",
                       @SerializedName("complete-url") var completeUrl: String="",
                       @SerializedName("info-type") var infoType: String="") {

}