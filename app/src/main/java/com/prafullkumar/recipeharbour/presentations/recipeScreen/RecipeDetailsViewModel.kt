package com.prafullkumar.recipeharbour.presentations.recipeScreen

import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prafullkumar.recipeharbour.data.repositories.RecipeRepository
import com.prafullkumar.recipeharbour.model.recipeFromNameDto.Recipe
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeDetailsViewModel(
    private val repository: RecipeRepository,
    private val recipeId: String
): ViewModel() {

    private val _state: MutableStateFlow<RecipeDetailsState> = MutableStateFlow(RecipeDetailsState.Loading)
    val state = _state.asStateFlow()
    init {
        viewModelScope.launch {
            _state.value = RecipeDetailsState.Loading
            _state.value = try {
                RecipeDetailsState.Success(repository.getRecipeDetails(recipeId))
            } catch (e: Exception) {
                RecipeDetailsState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
sealed class RecipeDetailsState {
    data object Loading: RecipeDetailsState()
    data class Success(val recipe: SingleRecipeDto): RecipeDetailsState()
    data class Error(val error: String): RecipeDetailsState()
}