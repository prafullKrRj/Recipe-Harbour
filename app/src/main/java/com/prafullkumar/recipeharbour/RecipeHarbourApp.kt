package com.prafullkumar.recipeharbour

import android.app.Application
import com.prafullkumar.recipeharbour.data.RecipeAppContainer
import com.prafullkumar.recipeharbour.data.RecipeAppContainerImpl

class RecipeHarbourApp: Application() {

    lateinit var appContainer: RecipeAppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = RecipeAppContainerImpl(this)
    }
}