package com.prafullkumar.recipeharbour.di

import android.content.Context
import com.prafullkumar.recipeharbour.data.RecipeRepository
import com.prafullkumar.recipeharbour.data.RecipeRepositoryImpl
import com.prafullkumar.recipeharbour.data.remote.RecipeApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RecipeAppContainer {
    val recipeRepository: RecipeRepository
}
class RecipeAppContainerImpl(
    private val context: Context
) : RecipeAppContainer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.edamam.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val recipeApi by lazy {
        retrofit.create(RecipeApi::class.java)
    }
    override val recipeRepository: RecipeRepository by lazy {
        RecipeRepositoryImpl(recipeApi, context)
    }
}