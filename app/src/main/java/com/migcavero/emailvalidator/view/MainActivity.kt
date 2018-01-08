package com.migcavero.emailvalidator.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.migcavero.emailvalidator.R
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI(this).setContentView(this)
    }

    override fun displayValidEmailMessage() {
        toast(R.string.valid_email_message)
    }

    override fun displayInvalidEmailMessage() {
        toast(R.string.invalid_email_message)
    }

    override fun displayLimitReachedMessage() {
        toast(R.string.limit_reached_message)
    }

}
