package com.prafullkumar.recipeharbour.presentations.recipeScreen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prafullkumar.recipeharbour.model.singleRecipeDto.Ingredients
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto
import com.prafullkumar.recipeharbour.ui.theme.lightGrey
import com.prafullkumar.recipeharbour.ui.theme.lightGrey100

@Composable
fun IngredientsSection(recipeDto: SingleRecipeDto, modifier: Modifier) {
    val ingredients = recipeDto.recipe?.ingredients ?: emptyList()
    Column {
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
        Row(Modifier.fillMaxWidth()) {
            Box(modifier = Modifier
                .weight(.3f)
                .border(1.dp, lightGrey, RoundedCornerShape(topStart = 8.dp)).padding(6.dp), contentAlignment = androidx.compose.ui.Alignment.Center) {
                Text(
                    text = "Ingredient",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Box(modifier = Modifier
                .weight(.3f)
                .border(1.dp, lightGrey, RoundedCornerShape(topEnd = 8.dp)).padding(6.dp), contentAlignment = androidx.compose.ui.Alignment.Center) {
                Text(
                    text = "Quantity",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
