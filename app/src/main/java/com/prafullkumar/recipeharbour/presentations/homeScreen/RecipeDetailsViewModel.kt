package com.prafullkumar.recipeharbour.presentations.homeScreen

import androidx.lifecycle.ViewModel
import com.prafullkumar.recipeharbour.data.RecipeRepository

class RecipeDetailsViewModel(
    private val repository: RecipeRepository,
    private val recipe: String
): ViewModel() {

}
