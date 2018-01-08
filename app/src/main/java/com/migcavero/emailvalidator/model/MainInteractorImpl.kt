package com.migcavero.emailvalidator.model

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainInteractorImpl : MainInteractor {

    val BASE_URL: String = "https://www.validator.pizza/"
    val VALID_STATUS_CODE = 200
    val INVALID_STATUS_CODE = 400
    val LIMIT_REACHED_CODE = 429

    override fun requestResponse(email: String, onApiResponse: MainInteractor.OnApiResponse) {
        val builder = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

        val retrofit: Retrofit = builder.build()
        val validatorPizzaClient: ValidatorPizzaClient = retrofit.create(ValidatorPizzaClient::class.java)
        val call: Call<Email> = validatorPizzaClient.validateEmail(email)

        call.enqueue(object : Callback<Email> {

            override fun onResponse(call: Call<Email>, response: Response<Email>) {
                if (response.body() != null) {
                    when (response.body()!!.status) {
                        VALID_STATUS_CODE -> {
                            val emailObject: Email = response.body()!!
                            onApiResponse.onValidResponse(emailObject)
                        }
                        INVALID_STATUS_CODE -> onApiResponse.onInvalidResponse()
                        LIMIT_REACHED_CODE -> onApiResponse.onLimitReachedResponse()
                    }
                } else {
                    onApiResponse.onInvalidResponse()
                }
            }

            override fun onFailure(call: Call<Email>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

    }

}