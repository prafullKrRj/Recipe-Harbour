package com.prafullkumar.recipeharbour.data.repositories

import com.prafullkumar.recipeharbour.data.local.AppDao
import com.prafullkumar.recipeharbour.data.local.entities.HistoryNameEntity
import com.prafullkumar.recipeharbour.data.remote.RecipeApi
import com.prafullkumar.recipeharbour.model.Resource
import com.prafullkumar.recipeharbour.model.recipeFromNameDto.RecipeFromNameDto
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

interface SearchRepository {
    suspend fun searchRecipes(recipeName: String): Flow<Resource<RecipeFromNameDto>>
    suspend fun addRecipeToDb(recipe: String)
    fun getAllHistory(): Flow<List<HistoryNameEntity>>
}

class SearchRepositoryImpl(
    private val recipeApi: RecipeApi,
    private val recipeDao: AppDao
) : SearchRepository {

    override suspend fun searchRecipes(recipeName: String): Flow<Resource<RecipeFromNameDto>> {
        return callbackFlow {
            trySend(Resource.Loading)
            try {
                val response = recipeApi.searchRecipes(
                    type = "public",
                    query = recipeName,
                    appId = Cons.appId,
                    appKey = Cons.appKey
                )
                if (response.isSuccessful) {
                    response.body()?.let {
                        trySend(Resource.Success(it))
                    }
                } else {
                    trySend(Resource.Error(response.message()))
                }
            } catch (e: Exception) {
                trySend(Resource.Error(e.message ?: "An error occurred"))
            }
            awaitClose {  }
        }
    }

    override suspend fun addRecipeToDb(recipe: String) {
        recipeDao.insertHistoryName(HistoryNameEntity(name = recipe))
    }

    override fun getAllHistory(): Flow<List<HistoryNameEntity>> {
        return recipeDao.getAllHistory()
    }

}