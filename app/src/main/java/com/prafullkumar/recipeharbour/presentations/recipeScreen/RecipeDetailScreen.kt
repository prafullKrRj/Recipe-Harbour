package com.prafullkumar.recipeharbour.presentations.recipeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.prafullkumar.recipeharbour.model.Resource

@Composable
fun RecipeDetailsScreen(viewModel: RecipeDetailsViewModel, navController: NavController) {
    val state = viewModel.state.collectAsState()
    when(state.value) {
        is Resource.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is Resource.Error -> {
            Text(text =
                (state.value as Resource.Error).message, modifier = Modifier, textAlign = TextAlign.Center)
        }
        is Resource.Success -> {
            RecipeSuccessScreen(
                recipeDto = (state.value as Resource.Success).data,
                navController = navController
            )
        } else -> {
            Text(text = "Something went wrong", modifier = Modifier, textAlign = TextAlign.Center)
        }
    }
}

