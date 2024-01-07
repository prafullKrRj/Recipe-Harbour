package com.prafullkumar.recipeharbour

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prafullkumar.recipeharbour.presentations.homeScreen.HomeScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HOME.route) {
        composable(Screen.HOME.route) {
            HomeScreen(viewModel = viewModel(factory = ViewModelProvider.HomeScreenVM))
        }
    }
}
enum class Screen(val route: String) {
    HOME("home"),
    FAVOURITE("recipe_details"),
    SEARCH("search"),
    AI("ai")
}