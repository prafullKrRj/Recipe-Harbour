package com.prafullkumar.recipeharbour.data.repositories

import android.content.Context
import com.prafullkumar.recipeharbour.model.recipeFromNameDto.RecipeFromNameDto
import com.prafullkumar.recipeharbour.data.remote.RecipeApi
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto

interface RecipeRepository {
    suspend fun searchRecipes(recipeName: String): RecipeFromNameDto
    suspend fun getRecipeDetails(recipeId: String): SingleRecipeDto
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

    override suspend fun getRecipeDetails(recipeId: String): SingleRecipeDto {
        return recipeApi.getRecipeDetails(
            type = "public",
            recipeId = recipeId,
            appId = Cons.appId,
            appKey = Cons.appKey
        )
    }
}

object Cons {
    const val appKey = "6b4d33464451b16430455f5d7c0a9f68"
    const val appId = "f42f8ae0"
}