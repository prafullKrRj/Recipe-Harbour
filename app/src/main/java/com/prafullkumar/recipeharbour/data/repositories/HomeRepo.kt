package com.prafullkumar.recipeharbour.data.repositories

import android.content.Context
import com.prafullkumar.recipeharbour.model.recipeFromNameDto.RecipeFromNameDto
import com.prafullkumar.recipeharbour.data.remote.RecipeApi

interface RecipeRepository {
    suspend fun searchRecipes(recipeName: String): RecipeFromNameDto
}

class RecipeRepositoryImpl (
    private val recipeApi: RecipeApi,
    private val context: Context
) : RecipeRepository {

    override suspend fun searchRecipes(recipeName: String): RecipeFromNameDto {
        return recipeApi.searchRecipes(
            type = "",
            query = recipeName,
            appId = Cons.appId,
            appKey = Cons.appKey
        )
    }
}

object Cons {
    const val appKey = "6b4d33464451b16430455f5d7c0a9f68"
    const val appId = "f42f8ae0"
}