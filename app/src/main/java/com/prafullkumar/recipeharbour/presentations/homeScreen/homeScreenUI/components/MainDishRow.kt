package com.prafullkumar.recipeharbour.presentations.homeScreen.homeScreenUI.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prafullkumar.recipeharbour.R
import com.prafullkumar.recipeharbour.presentations.homeScreen.HomeScreen.RECIPE_DETAILS
import com.prafullkumar.recipeharbour.presentations.homeScreen.homeScreenUI.HomeScreen
import com.prafullkumar.recipeharbour.ui.theme.grey

@Composable
fun MainDishRow(homeNavController: NavController) {
    HeadingText(id = R.string.main_dish)
    val food = listOf("Pizza", "Burger", "Pasta", "Noodles", "Sandwich", "Rolls", "Biryani", "Fried Rice")
    LazyRow {
        items(food.size) {
            ItemCircleWithName(food[it]) {
                homeNavController.navigate(RECIPE_DETAILS.route)
            }
        }
    }
}

@Composable
fun ItemCircleWithName(food: String, onClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                onClick()
            }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Box(modifier = Modifier.clip(CircleShape).background(Color.White).shadow(4.dp)) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(80.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit
            )
        }
        Text(text = food, color = grey, fontWeight = FontWeight.W300)
    }
}