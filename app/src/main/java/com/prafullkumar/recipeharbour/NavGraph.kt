package com.prafullkumar.recipeharbour

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prafullkumar.recipeharbour.presentations.favouritesScreen.FavouriteScreen
import com.prafullkumar.recipeharbour.presentations.homeScreen.HomeNavGraph

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HOME.route) {
        composable(Screen.HOME.route) {
            HomeNavGraph(navController = navController)
        }
        composable(Screen.FAVOURITE.route) {
            FavouriteScreen(
                viewModel = viewModel(factory = ViewModelProvider.FavouritesScreenVM),
                navController
            )
        }
    }
}
enum class Screen(val route: String) {
    HOME("home"),
    FAVOURITE("favourites"),
    SEARCH("search"),
    AI("ai")
}