package com.prafullkumar.recipeharbour.presentations.recipeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prafullkumar.recipeharbour.data.repositories.RecipeRepository
import com.prafullkumar.recipeharbour.model.Resource
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RecipeDetailsViewModel(
    private val repository: RecipeRepository,
    private val recipeId: String
): ViewModel() {
    fun bookmarkRecipe() {
        repository.bookmarkRecipe(recipeId)
    }

    private val _state: MutableStateFlow<Resource<SingleRecipeDto>> = MutableStateFlow(Resource.Loading)
    val state = _state.asStateFlow()
    init {
        viewModelScope.launch {
            _state.update {
                Resource.Loading
            }
            repository.getRecipeDetails(recipeId).collect { resp ->
                when(resp) {
                    is Resource.Success -> {
                        _state.update {
                            Resource.Success(resp.data)
                        }
                    }
                    is Resource.Error -> {
                        _state.update {
                            Resource.Error(resp.message)
                        }
                    }
                    is Resource.Loading -> {
                        _state.update {
                            Resource.Loading
                        }
                    }
                    else -> {
                        _state.update {
                            Resource.Initial
                        }
                    }
                }
            }
        }
    }
}