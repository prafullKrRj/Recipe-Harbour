package com.prafullkumar.recipeharbour.presentations.favouritesScreen

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun FavouriteScreen(viewModel: FavouritesViewModel, navController: NavHostController) {
    Text(
        modifier = Modifier,
        text = "Favourite Screen",
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Start,
    )
}