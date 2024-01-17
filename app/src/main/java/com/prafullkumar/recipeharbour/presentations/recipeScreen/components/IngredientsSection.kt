package com.prafullkumar.recipeharbour.presentations.recipeScreen.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prafullkumar.recipeharbour.model.singleRecipeDto.Ingredients
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto
import com.prafullkumar.recipeharbour.ui.theme.lightGrey

@Composable
fun IngredientsSection(recipeDto: SingleRecipeDto, modifier: Modifier) {
    val ingredients = recipeDto.recipe?.ingredients ?: emptyList()
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, lightGrey, RoundedCornerShape(8.dp))
    ) {
        Text(
            text = "Ingredients",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(12.dp)
        )
        IngredientTable(modifier = Modifier.padding(12.dp), ingredient = ingredients)
    }
}

@Composable
fun IngredientTable(modifier: Modifier, ingredient: List<Ingredients>) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, lightGrey, RoundedCornerShape(8.dp))
    ) {
        HeadingRow()
        ingredient.forEach {
            Row(Modifier.fillMaxWidth()) {
                IngredientAndQuantityBox(modifier = Modifier.weight(.45f), text = it.food?.capitalize() ?: "")
                IngredientAndQuantityBox(modifier = Modifier.weight(.55f), text = "${it.quantity ?: ""} ${it.measure ?: ""}")
            }
        }
    }
}

@Composable
fun HeadingRow() {
    Row(Modifier.fillMaxWidth()) {
        IngredientAndQuantityBox(modifier = Modifier.weight(.45f), text = "Ingredient", isBold = true)
        IngredientAndQuantityBox(modifier = Modifier.weight(.55f), text = "Quantity", isBold = true)
    }
}

@Composable
fun IngredientAndQuantityBox(modifier: Modifier, text: String, isBold: Boolean = false) {
    Box(modifier = modifier
        .fillMaxSize()
        .border(1.dp, lightGrey, RoundedCornerShape(topEnd = 8.dp))
        .padding(6.dp), contentAlignment = androidx.compose.ui.Alignment.Center) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal,
            overflow = TextOverflow.Ellipsis,
            textAlign = androidx.compose.ui.text.style.TextAlign.Start,
            modifier = Modifier.padding(start = 6.dp)
        )
    }
}

