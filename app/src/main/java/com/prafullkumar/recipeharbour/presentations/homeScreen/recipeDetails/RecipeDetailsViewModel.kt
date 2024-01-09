package com.prafullkumar.recipeharbour.presentations.homeScreen.recipeDetails

import androidx.lifecycle.ViewModel
import com.prafullkumar.recipeharbour.data.repositories.RecipeRepository

class RecipeDetailsViewModel(
    private val repository: RecipeRepository,
    private val recipe: String
): ViewModel() {

}
