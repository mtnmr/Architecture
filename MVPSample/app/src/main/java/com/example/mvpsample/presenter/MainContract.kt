package com.example.mvpsample.presenter

//Contractの役割はViewとPresenterを橋渡し、双方で使用するメソッドを定義する。
interface MainContract {

    interface View : BaseView<Presenter> {
        //テキストを表示するメソッド
        fun showNumber(id: String)

        fun showPokeName(name: String)
        fun showPokeImage(imageUrl: String)
    }

    interface Presenter : BasePresenter {
        //ボタンクリックに使用するメソッド
        fun onClickButton(text: String)
    }
}