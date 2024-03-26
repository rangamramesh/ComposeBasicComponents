package com.ramesh.composepractice.learnList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LearnList(list: ArrayList<String>) {

//    List
    Column {
        list.forEach {
            Text(text = it)
        }
    }
}

@Composable
fun LearnLazyColumn(list: ArrayList<String>) {

//    List
    LazyColumn {
        items(list) {
            Text(
                text = it,
                color = Color.Blue,
                modifier = Modifier.run { padding(horizontal = 20.dp, vertical = 10.dp) })
        }
    }
}

@Composable
fun LearnLazyRow(list: ArrayList<String>) {

//    List
    LazyRow {
        items(list) {
            Text(
                text = it,
                color = Color.Blue,
                modifier = Modifier.run { padding(horizontal = 20.dp, vertical = 10.dp) })
        }
    }
}