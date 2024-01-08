package com.prafullkumar.recipeharbour.presentations.homeScreen.homeScreenUI

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prafullkumar.recipeharbour.R
import com.prafullkumar.recipeharbour.presentations.homeScreen.HomeConstants
import com.prafullkumar.recipeharbour.presentations.homeScreen.homeScreenUI.components.CategoriesRow
import com.prafullkumar.recipeharbour.presentations.homeScreen.homeScreenUI.components.DishCard
import com.prafullkumar.recipeharbour.presentations.homeScreen.homeScreenUI.components.HeadingText
import com.prafullkumar.recipeharbour.presentations.homeScreen.homeScreenUI.components.MainDishRow
import com.prafullkumar.recipeharbour.presentations.homeScreen.homeScreenUI.components.TopBar
import com.prafullkumar.recipeharbour.ui.theme.lightGrey100

@Composable
fun HomeScreen(viewModel: HomeViewModel, homeNavController: NavController) {
    Scaffold (
        topBar = { TopBar() },
        containerColor = lightGrey100,
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(bottom = 4.dp), contentPadding = paddingValues) {
            item {
                CategoriesRow(homeNavController)
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                MainDishRow(homeNavController)
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                CountryCuisines(
                    cuisines = Cuisines(R.drawable.european, R.string.european_cuisines), viewModel = viewModel, homeNavController = homeNavController)
            }
            item {
                CountryCuisines(cuisines = Cuisines(R.drawable.chinese, R.string.chinese_cuisines),  viewModel = viewModel, homeNavController = homeNavController)
            }
            item {
                CountryCuisines(cuisines = Cuisines(R.drawable.indian, R.string.indian_cuisines),  viewModel = viewModel, homeNavController = homeNavController)
            }

        }
    }
}

@Composable
fun CountryCuisines(
    cuisines: Cuisines,
    viewModel: HomeViewModel,
    homeNavController: NavController,
) {
    HeadingText(id = cuisines.id)
    val items: List<String> =
        when (cuisines.id) {
            R.string.indian_cuisines -> HomeConstants.getRandom10IndianDishes()
            R.string.chinese_cuisines -> HomeConstants.getRandom10ChineseDishes()
            R.string.european_cuisines -> HomeConstants.getRandom10EuropeanDishes()
            else -> emptyList()
        }
    LazyRow {
        items(items.size) {index ->
            DishCard(img = cuisines.img, index = index, homeNavController = homeNavController, foodItems = items)
        }
    }
}
@Stable
data class Cuisines(
    val img: Int,
    val id: Int
)