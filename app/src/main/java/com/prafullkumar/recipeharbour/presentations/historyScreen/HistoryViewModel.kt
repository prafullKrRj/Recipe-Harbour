package com.prafullkumar.recipeharbour.presentations.historyScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prafullkumar.recipeharbour.data.repositories.RecipeRepository
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class HistoryViewModel(container: RecipeRepository): ViewModel() {


    val history: StateFlow<List<SingleRecipeDto>> = container.getSavedRecipes().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

}
