package com.example.mvpsample.presenter

import com.example.mvpsample.repository.LocalRepository

class MainPresenter(
    private val view:MainContract.View,
    private val localRepository: LocalRepository
):MainContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {
        val text = localRepository.loadText()
        view.showTextView(text)
    }

    override fun onClickButton(text: String) {
        localRepository.saveText(text)
        view.showTextView(text)
    }

}