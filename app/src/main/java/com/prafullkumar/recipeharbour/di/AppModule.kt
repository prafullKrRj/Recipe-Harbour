package com.prafullkumar.recipeharbour.di

import android.content.Context
import com.prafullkumar.recipeharbour.data.repositories.RecipeRepository
import com.prafullkumar.recipeharbour.data.repositories.RecipeRepositoryImpl
import com.prafullkumar.recipeharbour.data.remote.RecipeApi
import com.prafullkumar.recipeharbour.data.repositories.ChatBotRepository
import com.prafullkumar.recipeharbour.data.repositories.ChatBotRepositoryImpl
import com.prafullkumar.recipeharbour.data.repositories.FavouriteRepository
import com.prafullkumar.recipeharbour.data.repositories.FavouriteRepositoryImpl
import com.prafullkumar.recipeharbour.data.repositories.SearchRepository
import com.prafullkumar.recipeharbour.data.repositories.SearchRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RecipeAppContainer {
    val recipeRepository: RecipeRepository
    val favoriteRepository: FavouriteRepository
    val searchRepository: SearchRepository
    val chatBotRepository: ChatBotRepository
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
    override val favoriteRepository: FavouriteRepository by lazy {
        FavouriteRepositoryImpl(context)
    }
    override val searchRepository: SearchRepository by lazy {
        SearchRepositoryImpl(context)
    }
    override val chatBotRepository: ChatBotRepository by lazy {
        ChatBotRepositoryImpl(context)
    }
}