package com.migcavero.emailvalidator.view

import com.migcavero.emailvalidator.presenter.MainPresenterImpl
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivityUI constructor(mainView: MainView) : AnkoComponent<MainActivity>{

    val mMainPresenter = MainPresenterImpl(mainView)

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        verticalLayout{
            val email = editText()
            button("Verify Email"){
                onClick {
                    mMainPresenter.onVerifyButtonClicked(email.text.toString()) }
            }
        }
    }
}