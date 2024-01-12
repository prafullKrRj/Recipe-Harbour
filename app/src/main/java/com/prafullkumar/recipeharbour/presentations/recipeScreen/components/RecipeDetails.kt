package com.prafullkumar.recipeharbour.presentations.recipeScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow.Companion
import androidx.compose.ui.text.style.TextOverflow.Companion.Clip
import androidx.compose.ui.text.style.TextOverflow.Companion.Visible
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto
import com.prafullkumar.recipeharbour.ui.theme.PoppinsMedium
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
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                overflow = Visible,
                textAlign = TextAlign.Center
            )
        }
        if (recipeDto.recipe?.mealType != null && recipeDto.recipe?.totalTime != null) {
            Text(
                text = "${recipeDto.recipe?.mealType?.get(0)} | ${recipeDto.recipe?.totalTime} min",
                fontFamily = PoppinsRegular,
                fontSize = 16.sp,
                fontWeight = FontWeight.W200,
                modifier = Modifier.fillMaxWidth(),
                overflow = Visible,
                textAlign = TextAlign.Center
            )
        } else if (recipeDto.recipe?.mealType != null) {
            Text(
                text = recipeDto.recipe?.mealType?.get(0) ?: "",
                fontFamily = PoppinsMedium,
                fontSize = 16.sp,
                fontWeight = FontWeight.W200,
                modifier = Modifier.fillMaxWidth(),
                overflow = Visible,
                textAlign = TextAlign.Center
            )
        } else if (recipeDto.recipe?.totalTime != null) {
            Text(
                text = "${recipeDto.recipe?.totalTime} min",
                fontFamily = PoppinsMedium,
                fontSize = 16.sp,
                fontWeight = FontWeight.W200,
                modifier = Modifier.fillMaxWidth(),
                overflow = Visible,
                textAlign = TextAlign.Center
            )
        }
    }
}