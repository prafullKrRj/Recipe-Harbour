package com.prafullkumar.recipeharbour

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.prafullkumar.recipeharbour.presentations.homeScreen.HomeViewModel

object ViewModelProvider {
    val HomeScreenVM = viewModelFactory {
        initializer {
            val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RecipeHarbourApp)
            val container = application.appContainer.recipeRepository
            HomeViewModel(container)
        }
    }
}