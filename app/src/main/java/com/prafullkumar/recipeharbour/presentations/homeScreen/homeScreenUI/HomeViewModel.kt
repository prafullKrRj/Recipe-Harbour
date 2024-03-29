package com.prafullkumar.recipeharbour.presentations.homeScreen.homeScreenUI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.prafullkumar.recipeharbour.RecipeHarbourApp
import com.prafullkumar.recipeharbour.data.repositories.RecipeRepository
import com.prafullkumar.recipeharbour.presentations.homeScreen.HomeConstants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: RecipeRepository
): ViewModel() {

    private val _recipe = MutableStateFlow("")
    val recipe = _recipe.asStateFlow()
    fun getRecipeFromName(recipeName: String) {
        viewModelScope.launch {
            _recipe.update {
                repository.searchRecipes(recipeName).hits[0].recipe?.ingredientLines?.get(0) ?: "error"
            }
            repository.searchRecipes(recipeName)
        }
    }
    val indianRecipe = HomeConstants.getRandom10IndianDishes()
    val chineseRecipe = HomeConstants.getRandom10ChineseDishes()
    val europeanRecipe = HomeConstants.getRandom10EuropeanDishes()
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as RecipeHarbourApp)
                val container = application.appContainer.recipeRepository
                HomeViewModel(container)
            }
        }
    }
}