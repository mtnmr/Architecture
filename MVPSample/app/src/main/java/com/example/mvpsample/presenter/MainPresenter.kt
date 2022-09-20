package com.example.mvpsample.presenter

class MainPresenter(private val view:MainContract.View):MainContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {
    }

    override fun onClickButton(text: String) {
        view.showTextView(text)
    }

}