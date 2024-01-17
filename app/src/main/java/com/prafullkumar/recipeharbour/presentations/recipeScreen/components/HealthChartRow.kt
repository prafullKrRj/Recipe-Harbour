package com.prafullkumar.recipeharbour.presentations.recipeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto
import com.prafullkumar.recipeharbour.ui.theme.PoppinsMedium
import com.prafullkumar.recipeharbour.ui.theme.PoppinsRegular
import com.prafullkumar.recipeharbour.ui.theme.oceanBlue
import com.prafullkumar.recipeharbour.ui.theme.white

@Composable
fun HealthChartRow(modifier: Modifier = Modifier, recipeDto: SingleRecipeDto) {
    val value = getValues(recipeDto)
    val type = getTypes(recipeDto)
    val unit = getUnits(recipeDto)
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        repeat(4) {
            HealthChartRowItem(
                modifier = Modifier.weight(.25f),
                type = type[it],
                value = value[it],
                unit = unit[it]
            )
        }
    }
}
@Composable
private fun HealthChartRowItem(
    modifier: Modifier,
    type: String,
    value: String,
    unit: String
) {
    Box(modifier = modifier
        .padding(8.dp)
        .size(80.dp)
        .clip(CircleShape)
        .background(white)
        .border(1.dp, oceanBlue, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "$value $unit", fontFamily = PoppinsMedium, fontSize = 14.sp)
            Text(text = type, fontFamily = PoppinsRegular, fontSize = 13.sp, fontWeight = FontWeight.W300)
        }
    }
}

private fun getTypes(recipeDto: SingleRecipeDto) : List<String> {
    return listOf(
        recipeDto.recipe?.totalNutrients?.PROCNT?.label ?: "",
        recipeDto.recipe?.totalNutrients?.FAT?.label ?: "",
        recipeDto.recipe?.totalNutrients?.ENERCKCAL?.label ?: "",
        recipeDto.recipe?.totalNutrients?.CHOCDF?.label ?: "",
        recipeDto.recipe?.totalNutrients?.CHOLE?.label ?: "",
    )
}
private fun getValues(recipeDto: SingleRecipeDto) : List<String> {
    return listOf(
        recipeDto.recipe?.totalNutrients?.PROCNT?.quantity?.toInt().toString(),
        recipeDto.recipe?.totalNutrients?.FAT?.quantity?.toInt().toString(),
        recipeDto.recipe?.totalNutrients?.ENERCKCAL?.quantity?.toInt().toString(),
        recipeDto.recipe?.totalNutrients?.CHOCDF?.quantity?.toInt().toString(),
        recipeDto.recipe?.totalNutrients?.CHOLE?.quantity?.toInt().toString(),
    )
}
private fun getUnits(recipeDto: SingleRecipeDto) : List<String> {
    return listOf(
        recipeDto.recipe?.totalNutrients?.PROCNT?.unit ?: "",
        recipeDto.recipe?.totalNutrients?.FAT?.unit ?: "",
        recipeDto.recipe?.totalNutrients?.ENERCKCAL?.unit ?: "",
        recipeDto.recipe?.totalNutrients?.CHOCDF?.unit ?: "",
        recipeDto.recipe?.totalNutrients?.CHOLE?.unit ?: "",
    )
}