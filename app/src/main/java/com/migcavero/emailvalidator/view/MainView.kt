package com.migcavero.emailvalidator.view

import com.migcavero.emailvalidator.model.Email

interface MainView {

    fun displayValidEmailMessage(email: Email)

    fun displayInvalidEmailMessage()

    fun displayLimitReachedMessage()

}