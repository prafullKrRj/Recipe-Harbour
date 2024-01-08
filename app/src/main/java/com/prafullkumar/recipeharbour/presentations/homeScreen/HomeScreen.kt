package com.prafullkumar.recipeharbour.presentations.homeScreen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prafullkumar.recipeharbour.presentations.homeScreen.components.CategoriesRow
import com.prafullkumar.recipeharbour.presentations.homeScreen.components.MainDishRow
import com.prafullkumar.recipeharbour.presentations.homeScreen.components.TopBar

@Composable
fun HomeScreen(viewModel: HomeViewModel, homeNavController: NavController) {
    Scaffold (
        topBar = { TopBar() },
    ) { paddingValues ->

        LazyColumn(modifier = Modifier, contentPadding = paddingValues) {
            item {
                CategoriesRow(homeNavController)
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                MainDishRow(homeNavController)
            }
        }
    }
}