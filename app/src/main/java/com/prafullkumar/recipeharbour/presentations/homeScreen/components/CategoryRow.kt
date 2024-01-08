package com.prafullkumar.recipeharbour.presentations.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prafullkumar.recipeharbour.R
import com.prafullkumar.recipeharbour.presentations.homeScreen.HomeScreen
import com.prafullkumar.recipeharbour.ui.theme.darkBlue

@Composable
fun CategoriesRow(homeNavController: NavController) {
    val foodItems = listOf("Pizza", "Chicken", "Paneer", "Mutton", "Fish", "Egg", "Veg")
    HeadingText(id = R.string.category)
    LazyRow {
        items(foodItems.size) { index ->
            ElevatedCard(
                modifier = Modifier
                    .padding(
                        start = if (index == 0) 16.dp else 0.dp,
                        end = 8.dp
                    )
                    .width(150.dp)
                    .height(200.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        homeNavController.navigate(HomeScreen.RECIPE_DETAILS.route)
                    }
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(painter = painterResource(id = R.drawable.img), contentDescription = null, contentScale = ContentScale.FillBounds)
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
                    Text(text = foodItems[index], modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.BottomStart),
                        color = Color.White
                    )
                }
            }
        }
    }
}