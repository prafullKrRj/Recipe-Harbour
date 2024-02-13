package com.prafullkumar.recipeharbour.presentations.historyScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prafullkumar.recipeharbour.data.local.entities.HistoryEntity
import com.prafullkumar.recipeharbour.data.repositories.RecipeRepository
import com.prafullkumar.recipeharbour.model.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val repository: RecipeRepository
): ViewModel() {



    val history: StateFlow<List<HistoryEntity>> = repository.getSavedRecipes().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

}
