package com.migcavero.emailvalidator.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ValidatorPizzaClient {

    @GET("email/{email}")
    fun validateEmail(@Path("email") email: String) : Call<Email>

}