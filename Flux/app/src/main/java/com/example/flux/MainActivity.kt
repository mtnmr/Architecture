package com.example.flux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.flux.data.Repo
import com.example.flux.flux.MainStore
import com.example.flux.flux.action.MainActionCreator
import com.example.flux.ui.MainScreen
import com.example.flux.ui.theme.FluxTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var actionCreator: MainActionCreator
    @Inject lateinit var store: MainStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        actionCreator.getRepos("mtnmr")

        setContent {
            FluxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val list = remember { mutableStateListOf<Repo>() }
                    store.repos.subscribe{
                        list.clear()
                        list.addAll(it)
                    }
                    
                    MainScreen(repoList = list)

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FluxTheme {
        Greeting("Android")
    }
}