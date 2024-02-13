package com.prafullkumar.recipeharbour.presentations.historyScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto
import com.prafullkumar.recipeharbour.presentations.recipeScreen.RecipeSuccessScreen

@Composable
fun HistoryScreen(viewModel: HistoryViewModel, navController: NavHostController) {
    val history = viewModel.history.collectAsState()
    Scaffold {  paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(history.value) { item: SingleRecipeDto ->
                RecipeSuccessScreen(
                    recipeDto = item,
                    navController = navController
                )
            }
        }
    }
}
