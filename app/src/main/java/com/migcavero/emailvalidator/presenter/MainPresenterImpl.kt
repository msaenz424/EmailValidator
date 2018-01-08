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
        mMainView.displayValidEmailMessage()
    }

    override fun onInvalidResponse() {
        mMainView.displayInvalidEmailMessage()
    }

    override fun onLimitReachedResponse() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}