package com.prafullkumar.recipeharbour.presentations.recipeScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.prafullkumar.recipeharbour.model.singleRecipeDto.Ingredients
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto

@Composable
fun IngredientsSection(recipeDto: SingleRecipeDto, modifier: Modifier) {
    val ingredients = recipeDto.recipe?.ingredients ?: emptyList()
    Column {
        ingredients.forEach {
            IngredientItem(
                modifier = modifier,
                ingredient = it
            )
        }
    }
}

@Composable
fun IngredientItem(modifier: Modifier, ingredient: Ingredients) {
    Column(modifier = modifier) {
        Text(
            text = ingredient.text ?: "",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
