package com.example.mvpsample.presenter

//Contractの役割はViewとPresenterを橋渡し、双方で使用するメソッドを定義する。
interface MainContract {

    interface View: BaseView<Presenter>{
        //テキストを表示するメソッド
        fun showTextView(text:String)
    }

    interface Presenter:BasePresenter{
        //ボタンクリックに使用するメソッド
        fun onClickButton(text: String)
    }
}