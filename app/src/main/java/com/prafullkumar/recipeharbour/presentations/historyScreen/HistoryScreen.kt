package com.prafullkumar.recipeharbour.presentations.historyScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
    val history by viewModel.history.collectAsState()
    Scaffold {  paddingValues ->
        LazyVerticalGrid(contentPadding = paddingValues, columns = GridCells.Adaptive(150.dp)) {
            items(history) { item ->
                ElevatedCard(
                    modifier = Modifier
                        .padding(
                            8.dp
                        )
                        .width(150.dp)
                        .height(220.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable {

                        }
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        SearchedDishImage(data = item.singleRecipeDto?.recipe?.image ?: "")
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        darkBlue
                                    )
                                )
                            )) {
                        }
                        Text(text = item.singleRecipeDto?.recipe?.label ?: "", modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.BottomStart),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
