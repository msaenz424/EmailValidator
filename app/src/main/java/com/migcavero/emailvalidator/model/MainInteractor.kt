package com.migcavero.emailvalidator.model

interface MainInteractor {

    fun requestResponse(email: String, onApiResponse: OnApiResponse)

    interface OnApiResponse{

        fun onValidResponse(email: Email)

        fun onInvalidResponse()

        fun onLimitReachedResponse()

    }

}