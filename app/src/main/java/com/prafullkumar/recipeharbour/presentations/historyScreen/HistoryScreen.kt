package com.prafullkumar.recipeharbour.presentations.historyScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.prafullkumar.recipeharbour.presentations.searchScreen.components.SearchedDishImage
import com.prafullkumar.recipeharbour.ui.theme.darkBlue

@Composable
fun HistoryScreen(viewModel: HistoryViewModel, navController: NavHostController) {
    val history = viewModel.history.collectAsState()
    Scaffold {  paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(history.value) {

            }
        }
    }
}
