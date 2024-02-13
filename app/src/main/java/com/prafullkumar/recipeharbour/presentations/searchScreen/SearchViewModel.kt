package com.prafullkumar.recipeharbour.presentations.searchScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prafullkumar.recipeharbour.data.repositories.SearchRepository
import com.prafullkumar.recipeharbour.model.Resource
import com.prafullkumar.recipeharbour.model.recipeFromNameDto.RecipeFromNameDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchRepository: SearchRepository
): ViewModel() {

    private val _searchState: MutableStateFlow<Resource<RecipeFromNameDto>> = MutableStateFlow(Resource.Initial)
    val searchState = _searchState.asStateFlow()

    val searchQuery: MutableState<String> = mutableStateOf("")

    val history: MutableState<List<String>> = mutableStateOf(emptyList())
    fun searchDishes(query: String) {
        _searchState.update {
            Resource.Loading
        }
        viewModelScope.launch {
            searchRepository.searchRecipes(query).collect { resp ->
                when(resp) {
                    is Resource.Success -> {
                        _searchState.update {
                            Resource.Success(resp.data)
                        }
                    }
                    is Resource.Error -> {
                        _searchState.update {
                            Resource.Error(resp.message)
                        }
                    }
                    is Resource.Loading -> {
                        _searchState.update {
                            Resource.Loading
                        }
                    }
                    else -> {
                        _searchState.update {
                            Resource.Initial
                        }
                    }
                }
            }
            searchRepository.addRecipeToDb(query)
        }
    }
    init {
        try {
            viewModelScope.launch {
                searchRepository.getAllHistory().stateIn(viewModelScope, SharingStarted.Lazily, emptyList()).collect { list ->
                    history.value = list.map { it.name }
                }
            }
        } catch (e: Exception) {
            println("DB error")
        }
    }
}