package com.prafullkumar.recipeharbour.presentations.recipeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow.Companion.Visible
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto
import com.prafullkumar.recipeharbour.ui.theme.PoppinsRegular
import com.prafullkumar.recipeharbour.ui.theme.PoppinsSemiBold

@Composable
fun RecipeDetails(modifier: Modifier = Modifier, recipeDto: SingleRecipeDto) {

    Column(
        modifier = modifier,
        horizontalAlignment = CenterHorizontally,
    ) {
        recipeDto.recipe?.label?.let {
            Text(
                text = it,
                fontFamily = PoppinsSemiBold,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                overflow = Visible,
                textAlign = TextAlign.Center
            )
        }
        if (recipeDto.recipe?.mealType != null && recipeDto.recipe?.totalTime != null) {
            RecipeDetailsFieldText(text = "${recipeDto.recipe?.mealType?.get(0)} | ${recipeDto.recipe?.totalTime} min")
        } else if (recipeDto.recipe?.mealType != null) {
            RecipeDetailsFieldText(text = recipeDto.recipe?.mealType?.get(0) ?: "")
        } else if (recipeDto.recipe?.totalTime != null) {
            RecipeDetailsFieldText(text = "${recipeDto.recipe?.totalTime} min")
        }
        HealthChartRow()
    }
}
// procnt, fat, energy, chocdf, chocdf.net
@Composable
fun HealthChartRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        repeat(4) {
            HealthChartRowItem(modifier = Modifier.weight(.25f))
        }
    }
}

@Composable
fun HealthChartRowItem(modifier: Modifier) {
    Box(modifier = modifier
        .padding(8.dp)
        .size(80.dp)
        .clip(CircleShape)
        .shadow(1.dp, CircleShape),
        contentAlignment = Center
    ) {

    }
}
@Composable
fun RecipeDetailsFieldText(
    text: String,
) {
    Text(
        text = text,
        fontFamily = PoppinsRegular,
        fontSize = 16.sp,
        fontWeight = FontWeight.W200,
        modifier = Modifier.fillMaxWidth(),
        overflow = Visible,
        textAlign = TextAlign.Center
    )
}