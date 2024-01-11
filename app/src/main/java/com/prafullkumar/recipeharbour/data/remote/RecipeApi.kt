package com.prafullkumar.recipeharbour.data.remote

import com.prafullkumar.recipeharbour.model.recipeFromNameDto.RecipeFromNameDto
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApi {
    @GET("api/recipes/v2")
    suspend fun searchRecipes(
        @Query("type") type: String,
        @Query("q") query: String,
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String
    ): RecipeFromNameDto


    @GET("api/recipes/v2/{id}")
    suspend fun getRecipeDetails(
        @Path("id") recipeId: String,
        @Query("type") type: String,
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String
    ): SingleRecipeDto
}