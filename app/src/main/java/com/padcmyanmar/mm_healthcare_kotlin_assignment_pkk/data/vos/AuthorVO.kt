package com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by paikhantko on 7/14/18.
 */
class AuthorVO(@SerializedName("author-id") var author_id: Long=0,
               @SerializedName("author-name") var author_name: String="",
               @SerializedName("author-picture") var author_picture: String="") {
}