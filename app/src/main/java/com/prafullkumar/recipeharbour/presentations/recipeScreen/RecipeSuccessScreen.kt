package com.prafullkumar.recipeharbour.presentations.recipeScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.prafullkumar.recipeharbour.model.singleRecipeDto.Images
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto
import com.prafullkumar.recipeharbour.presentations.recipeScreen.components.RecipeDetails
import com.prafullkumar.recipeharbour.presentations.recipeScreen.components.RecipeImage

@Composable
fun RecipeSuccessScreen(viewModel: RecipeDetailsViewModel, recipeDto: SingleRecipeDto, navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            RecipeImage(
                modifier = Modifier.fillMaxWidth(),
                images = recipeDto.recipe?.images ?: Images(),
                isBookMarked = recipeDto.isFavourite,
                viewModel = viewModel
            ) {
                navController.popBackStack()
            }
        }
        item {
            RecipeDetails(
                modifier = Modifier.fillMaxWidth(),
                recipeDto = recipeDto,
            )
        }
        item {

        }
    }
}
