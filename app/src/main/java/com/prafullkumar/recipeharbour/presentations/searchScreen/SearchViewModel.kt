package com.prafullkumar.recipeharbour.presentations.searchScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prafullkumar.recipeharbour.data.repositories.SearchRepository
import com.prafullkumar.recipeharbour.model.recipeFromNameDto.RecipeFromNameDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchRepository: SearchRepository
): ViewModel() {

    private val _searchState: MutableStateFlow<SearchState> = MutableStateFlow(SearchState.Empty)
    val searchState = _searchState.asStateFlow()
    fun searchDishes(query: String) {
        _searchState.value = SearchState.Loading
        viewModelScope.launch {
            _searchState.value = try {
                SearchState.Success(searchRepository.searchRecipes(query))
            } catch (e: Exception) {
                SearchState.Error(e.message ?: "Something went wrong")
            }
        }
    }
}
sealed class SearchState {
    data class Success(val dishes: RecipeFromNameDto): SearchState()
    data object Loading: SearchState()
    data class Error(val error: String): SearchState()
    data object Empty: SearchState()
}