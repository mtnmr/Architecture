package com.example.mvpsample.presenter

import android.util.Log
import com.example.mvpsample.repository.local.LocalRepository
import com.example.mvpsample.repository.remote.RemoteRepository
import kotlinx.coroutines.*

class MainPresenter(
    private val view:MainContract.View,
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository
):MainContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {
        val text = localRepository.loadText()
        view.showNumber(text)
    }

    override fun onClickButton(text: String) {
        localRepository.saveText(text)
        view.showNumber(text)

        CoroutineScope(Dispatchers.Default).launch {
            val pokemon = async {
                remoteRepository.getPoke(text)
            }.await()
            withContext(Dispatchers.Main){
                view.showPokeName(pokemon.name)
                view.showPokeImage(pokemon.getImage())
            }
        }
    }

}