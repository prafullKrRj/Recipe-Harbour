package com.prafullkumar.recipeharbour.presentations.recipeScreen

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.prafullkumar.recipeharbour.model.singleRecipeDto.Images
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto
import com.prafullkumar.recipeharbour.presentations.recipeScreen.components.HealthChartRow
import com.prafullkumar.recipeharbour.presentations.recipeScreen.components.IngredientsSection
import com.prafullkumar.recipeharbour.presentations.recipeScreen.components.RecipeDetails
import com.prafullkumar.recipeharbour.presentations.recipeScreen.components.RecipeImage
import com.prafullkumar.recipeharbour.ui.theme.PoppinsMedium
import com.prafullkumar.recipeharbour.ui.theme.PoppinsRegular
import com.prafullkumar.recipeharbour.ui.theme.PoppinsSemiBold
import com.prafullkumar.recipeharbour.ui.theme.grey
import com.prafullkumar.recipeharbour.ui.theme.lightGrey100
import com.prafullkumar.recipeharbour.ui.theme.oceanBlue
import com.prafullkumar.recipeharbour.ui.theme.white

@Composable
fun RecipeSuccessScreen(viewModel: RecipeDetailsViewModel, recipeDto: SingleRecipeDto, navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            RecipeImage(
                modifier = Modifier.fillMaxWidth(),
                images = recipeDto.recipe?.images ?: Images(),
                isBookMarked = recipeDto.isFavourite,
                viewModel = viewModel
            ) {
                navController.popBackStack()
            }
        }
        item {
            RecipeDetails(
                modifier = Modifier.fillMaxWidth(),
                recipeDto = recipeDto,
            )
        }
        item {
            HealthChartRow(modifier = Modifier.padding(horizontal = 12.dp), recipeDto = recipeDto)
        }
        item {
            IngredientsSection(recipeDto = recipeDto, modifier = Modifier.padding(horizontal = 12.dp))
        }
    }
}


