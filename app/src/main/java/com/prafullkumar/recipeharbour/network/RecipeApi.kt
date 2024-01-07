package com.prafullkumar.recipeharbour.network

import com.prafullkumar.recipeharbour.model.recipeFromNameDto.RecipeFromNameDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {
    @GET("api/recipes/v2")
    suspend fun searchRecipes(
        @Query("type") type: String,
        @Query("q") query: String,
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String
    ): RecipeFromNameDto
}