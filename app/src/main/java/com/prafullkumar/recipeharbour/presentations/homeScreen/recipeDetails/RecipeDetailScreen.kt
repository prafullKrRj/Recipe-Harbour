package com.prafullkumar.recipeharbour.presentations.homeScreen.recipeDetails

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun RecipeDetailsScreen(viewModel: RecipeDetailsViewModel, navController: NavController) {
    Text(
        modifier = Modifier,
        text = "Reicpe Details",
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Start,
    )
}