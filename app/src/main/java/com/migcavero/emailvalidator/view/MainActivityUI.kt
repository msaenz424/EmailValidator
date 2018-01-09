package com.migcavero.emailvalidator.view

import android.widget.TextView
import com.migcavero.emailvalidator.presenter.MainPresenterImpl
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivityUI constructor(mainView: MainView) : AnkoComponent<MainActivity> {

    lateinit var emailTextView: TextView
    lateinit var domainTextView: TextView
    lateinit var mxRecordTextView: TextView
    lateinit var disposableTextView: TextView
    lateinit var aliasTextView: TextView

    private val mMainPresenter = MainPresenterImpl(mainView)

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        verticalLayout {
            val email = editText()

            button("Verify Email") {
                onClick {
                    mMainPresenter.onVerifyButtonClicked(email.text.toString())
                }
            }

            emailTextView = textView{padding = 16}
            domainTextView = textView{padding = 16}
            mxRecordTextView = textView{padding = 16}
            disposableTextView = textView{padding = 16}
            aliasTextView = textView{padding = 16}
        }
    }
}