package com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.events

/**
 * Created by paikhantko on 7/14/18.
 */
class ErrorEvent {
    class ApiErrorEvent(val throwable: Throwable? = null) {

        fun getMsg(): String? {
            if (throwable == null)
                return "Null Throwable in Error"
            else
                return throwable.message
        }
    }
}