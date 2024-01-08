package com.prafullkumar.recipeharbour.presentations.searchScreen

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun SearchScreenMain(searchViewModel: SearchViewModel) {

    Text(
        modifier = Modifier,
        text = "Search Screen",
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Start,
    )
}