package com.prafullkumar.recipeharbour.presentations.homeScreen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prafullkumar.recipeharbour.ViewModelProvider
import com.prafullkumar.recipeharbour.presentations.homeScreen.homeScreenUI.HomeScreen
import com.prafullkumar.recipeharbour.presentations.homeScreen.recipeDetails.RecipeDetailsScreen

@Composable
fun HomeNavGraph(navController: NavController) {

    val homeNavController = rememberNavController()
    NavHost(navController = homeNavController, startDestination = HomeScreen.HOME.route) {
        composable(HomeScreen.HOME.route) {
            HomeScreen(
                viewModel = viewModel(factory = ViewModelProvider.HomeScreenVM),
                homeNavController
            )
        }
        composable(HomeScreen.RECIPE_DETAILS.route) {
            RecipeDetailsScreen(
                viewModel = viewModel(factory = ViewModelProvider.getRecipesViewModel("")),
                homeNavController
            )
        }
    }
}
enum class HomeScreen(val route: String) {
    HOME("home"),
    RECIPE_DETAILS("recipe_details")
}