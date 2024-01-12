package com.prafullkumar.recipeharbour.data.repositories

import com.prafullkumar.recipeharbour.data.local.AppDao
import com.prafullkumar.recipeharbour.data.local.entities.HistoryNameEntity
import com.prafullkumar.recipeharbour.data.remote.RecipeApi
import com.prafullkumar.recipeharbour.model.recipeFromNameDto.RecipeFromNameDto
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun searchRecipes(recipeName: String): RecipeFromNameDto
    suspend fun addRecipeToDb(recipe: String)
    fun getAllHistory(): Flow<List<HistoryNameEntity>>
}

class SearchRepositoryImpl(
    private val recipeApi: RecipeApi,
    private val recipeDao: AppDao
) : SearchRepository {

    override suspend fun searchRecipes(recipeName: String): RecipeFromNameDto {
        return recipeApi.searchRecipes(
            type = "public",
            query = recipeName,
            appId = Cons.appId,
            appKey = Cons.appKey
        )
    }

    override suspend fun addRecipeToDb(recipe: String) {
        recipeDao.insertHistoryName(HistoryNameEntity(name = recipe))
    }

    override fun getAllHistory(): Flow<List<HistoryNameEntity>> {
        return recipeDao.getAllHistory()
    }

}