package com.prafullkumar.recipeharbour.presentations.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.prafullkumar.recipeharbour.R
import com.prafullkumar.recipeharbour.ui.theme.grey

@Composable
fun MainDishRow() {
    HeadingText(id = R.string.main_dish)
    val food = listOf("Pizza", "Burger", "Pasta", "Noodles", "Sandwich", "Rolls", "Biryani", "Fried Rice")
    LazyRow {
        items(food.size) {
            ItemCircleWithName(food[it])
        }
    }
}

@Composable
fun ItemCircleWithName(food: String) {
    Column(
        modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Text(text = food, color = grey, fontWeight = FontWeight.W300)
    }
}