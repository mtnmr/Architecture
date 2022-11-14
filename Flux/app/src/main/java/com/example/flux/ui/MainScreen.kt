package com.example.flux.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flux.data.Repo

@Composable
fun MainScreen(repoList:List<Repo>){
    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(items = repoList){ item ->  
            RepoItem(repo = item)
        }
    }
}

@Composable
fun RepoItem(repo: Repo){
    Card(

    ) {
        Column(
            modifier = Modifier.padding(8.dp).fillMaxWidth()
        ) {
            Text(text = repo.name)
        }
    }
}

@Preview
@Composable
fun RepoItemPreview(){
    Surface(
        color = Color.White
    ) {
        RepoItem(repo = Repo(id=0, name="sample repo", description = "", fullName = "", htmlUrl = ""))
    }
}