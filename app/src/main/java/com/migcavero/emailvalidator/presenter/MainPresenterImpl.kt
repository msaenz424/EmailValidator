package com.migcavero.emailvalidator.presenter

import com.migcavero.emailvalidator.model.Email
import com.migcavero.emailvalidator.model.MainInteractor
import com.migcavero.emailvalidator.model.MainInteractorImpl
import com.migcavero.emailvalidator.view.MainView

class MainPresenterImpl constructor(mainView: MainView) : MainPresenter, MainInteractor.OnApiResponse {

    var mMainView = mainView
    var mMainInteractor = MainInteractorImpl()

    override fun onVerifyButtonClicked(email: String) {
        mMainInteractor.requestResponse(email, this)
    }

    override fun onValidResponse(email: Email) {
        mMainView.displayValidEmailMessage(email)
    }

    override fun onInvalidResponse() {
        mMainView.displayInvalidEmailMessage()
    }

    override fun onLimitReachedResponse() {
        mMainView.displayLimitReachedMessage()
    }

}