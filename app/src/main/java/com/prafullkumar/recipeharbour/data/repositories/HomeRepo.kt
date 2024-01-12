package com.prafullkumar.recipeharbour.data.repositories

import com.prafullkumar.recipeharbour.data.local.AppDao
import com.prafullkumar.recipeharbour.model.recipeFromNameDto.RecipeFromNameDto
import com.prafullkumar.recipeharbour.data.remote.RecipeApi
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    suspend fun searchRecipes(recipeName: String): RecipeFromNameDto
    suspend fun getRecipeDetails(recipeId: String): SingleRecipeDto
    suspend fun saveRecipe(recipe: SingleRecipeDto)
    fun getSavedRecipes(): Flow<List<SingleRecipeDto>>
}

class RecipeRepositoryImpl(
    private val recipeApi: RecipeApi,
    private val appDao: AppDao
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

    override suspend fun saveRecipe(recipe: SingleRecipeDto) = appDao.insertRecipe(recipe)
    override fun getSavedRecipes(): Flow<List<SingleRecipeDto>> {
        return appDao.getSavedRecipes()
    }
}

object Cons {
    const val appKey = "6b4d33464451b16430455f5d7c0a9f68"
    const val appId = "f42f8ae0"
}