package com.prafullkumar.recipeharbour

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.prafullkumar.recipeharbour.presentations.aiScreen.ChatBotMainViewModel
import com.prafullkumar.recipeharbour.presentations.favouritesScreen.FavouritesViewModel
import com.prafullkumar.recipeharbour.presentations.historyScreen.HistoryViewModel
import com.prafullkumar.recipeharbour.presentations.homeScreen.homeScreenUI.HomeViewModel
import com.prafullkumar.recipeharbour.presentations.homeScreen.recipeDetails.RecipeDetailsViewModel
import com.prafullkumar.recipeharbour.presentations.searchScreen.SearchViewModel

object ViewModelProvider {
    val HomeScreenVM = viewModelFactory {
        initializer {
            val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RecipeHarbourApp)
            val container = application.appContainer.recipeRepository
            HomeViewModel(container)
        }
    }
    fun getRecipesViewModel(recipe: String) = viewModelFactory {
        initializer {
            val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RecipeHarbourApp)
            val container = application.appContainer.recipeRepository
            RecipeDetailsViewModel(container, recipe)
        }
    }
    val FavouritesScreenVM = viewModelFactory {
        initializer {
            val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RecipeHarbourApp)
            val container = application.appContainer.recipeRepository
            FavouritesViewModel(container)
        }
    }
    val ChatBotScreenVM = viewModelFactory {
        initializer {
            val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RecipeHarbourApp)
            val container = application.appContainer.recipeRepository
            ChatBotMainViewModel()
        }
    }
    val SearchScreenVM = viewModelFactory {
        initializer {
            val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RecipeHarbourApp)
            val container = application.appContainer.searchRepository
            SearchViewModel(container)
        }
    }
    val HistoryScreenVM = viewModelFactory {
        initializer {
            val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RecipeHarbourApp)
            val container = application.appContainer.recipeRepository
            HistoryViewModel(container)
        }
    }
}