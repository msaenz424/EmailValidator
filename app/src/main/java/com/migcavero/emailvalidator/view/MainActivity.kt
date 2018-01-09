package com.migcavero.emailvalidator.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.migcavero.emailvalidator.R
import com.migcavero.emailvalidator.model.Email
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), MainView {

    lateinit var mMainUi: MainActivityUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainUi = MainActivityUI(this)
        mMainUi.setContentView(this)
    }

    override fun displayValidEmailMessage(email: Email) {
        mMainUi.emailTextView.text = resources.getString(R.string.email_text) + " ${email.email}"
        mMainUi.domainTextView.text = resources.getString(R.string.domain_text) + " ${email.domain}"
        mMainUi.mxRecordTextView.text = resources.getString(R.string.mx_record_text) + " ${email.mx}"
        mMainUi.disposableTextView.text = resources.getString(R.string.disposable_text) + " ${email.disposable}"
        mMainUi.aliasTextView.text = resources.getString(R.string.alias_text) + " ${email.alias}"
    }

    override fun displayInvalidEmailMessage() {
        toast(R.string.invalid_email_message)
    }

    override fun displayLimitReachedMessage() {
        toast(R.string.limit_reached_message)
    }

}
