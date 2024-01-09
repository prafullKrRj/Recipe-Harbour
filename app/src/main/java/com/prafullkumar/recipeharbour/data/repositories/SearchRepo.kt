package com.prafullkumar.recipeharbour.data.repositories

import android.content.Context
import com.prafullkumar.recipeharbour.data.remote.RecipeApi
import com.prafullkumar.recipeharbour.model.recipeFromNameDto.RecipeFromNameDto

interface SearchRepository {
    suspend fun searchRecipes(recipeName: String): RecipeFromNameDto
}

class SearchRepositoryImpl (
    private val context: Context,
    private val recipeApi: RecipeApi
) : SearchRepository {

    override suspend fun searchRecipes(recipeName: String): RecipeFromNameDto {
        return recipeApi.searchRecipes(
            type = "public",
            query = recipeName,
            appId = Cons.appId,
            appKey = Cons.appKey
        )
    }
}