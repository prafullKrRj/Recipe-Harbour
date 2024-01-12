package com.prafullkumar.recipeharbour.di

import android.content.Context
import com.google.gson.GsonBuilder
import com.prafullkumar.recipeharbour.data.local.AppDatabase
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
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
interface RecipeAppContainer {
    val recipeRepository: RecipeRepository
    val favoriteRepository: FavouriteRepository
    val searchRepository: SearchRepository
    val chatBotRepository: ChatBotRepository
}
class RecipeAppContainerImpl(
    private val context: Context
) : RecipeAppContainer {
    private val gson = GsonBuilder()
    .registerTypeAdapter(Int::class.java, IntDeserializer())
    .create()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.edamam.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    private val recipeApi by lazy {
        retrofit.create(RecipeApi::class.java)
    }
    private val dao = AppDatabase.getDatabase(context).historyDao()
    override val recipeRepository: RecipeRepository by lazy {
        RecipeRepositoryImpl(recipeApi, dao)
    }
    override val favoriteRepository: FavouriteRepository by lazy {
        FavouriteRepositoryImpl(context)
    }
    override val searchRepository: SearchRepository by lazy {
        SearchRepositoryImpl(recipeApi, dao)
    }
    override val chatBotRepository: ChatBotRepository by lazy {
        ChatBotRepositoryImpl(context)
    }
}
class IntDeserializer : JsonDeserializer<Int> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Int {
        return json.asNumber.toFloat().toInt()
    }
}