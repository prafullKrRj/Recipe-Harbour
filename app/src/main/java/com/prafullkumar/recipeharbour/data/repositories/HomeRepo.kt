package com.prafullkumar.recipeharbour.data.repositories

import com.prafullkumar.recipeharbour.data.local.AppDao
import com.prafullkumar.recipeharbour.data.local.entities.HistoryEntity
import com.prafullkumar.recipeharbour.model.recipeFromNameDto.RecipeFromNameDto
import com.prafullkumar.recipeharbour.data.remote.RecipeApi
import com.prafullkumar.recipeharbour.model.Resource
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface RecipeRepository {
    suspend fun searchRecipes(recipeName: String): RecipeFromNameDto
    suspend fun getRecipeDetails(recipeId: String): Flow<Resource<SingleRecipeDto>>
    fun getSavedRecipes(): Flow<List<HistoryEntity>>
    suspend fun saveRecipe(recipe: HistoryEntity)
}

class RecipeRepositoryImpl(
    private val recipeApi: RecipeApi,
    private val appDao: AppDao
) : RecipeRepository {

    override suspend fun searchRecipes(recipeName: String): RecipeFromNameDto {
        val response = recipeApi.searchRecipes(
            type = "public",
            query = recipeName,
            appId = Cons.appId,
            appKey = Cons.appKey
        )
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception("Error: ${response.code()}")
        }
    }

    override suspend fun getRecipeDetails(recipeId: String): Flow<Resource<SingleRecipeDto>> = flow {
        emit(Resource.Loading)
        try {
            val response = recipeApi.getRecipeDetails(
                recipeId = recipeId,
                type = "public",
                appId = Cons.appId,
                appKey = Cons.appKey
            )
            if (response.isSuccessful) {
                saveRecipe(
                    HistoryEntity(
                        uniqueId = recipeId,
                        singleRecipeDto = response.body()!!
                    )
                )
                emit(Resource.Success(response.body()!!))
            } else {
                emit(Resource.Error("Error: ${response.code()}"))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown error"))
        }
    }
    override suspend fun saveRecipe(recipe: HistoryEntity) = appDao.insertRecipe(recipe)
    override fun getSavedRecipes(): Flow<List<HistoryEntity>> {
        return appDao.getSavedRecipes()
    }
}

object Cons {
    const val appKey = "6b4d33464451b16430455f5d7c0a9f68"
    const val appId = "f42f8ae0"
}