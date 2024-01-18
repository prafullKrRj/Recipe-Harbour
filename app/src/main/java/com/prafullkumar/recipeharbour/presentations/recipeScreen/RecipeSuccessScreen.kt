package com.prafullkumar.recipeharbour.presentations.recipeScreen

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
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

@Composable
fun RecipeSuccessScreen(viewModel: RecipeDetailsViewModel, recipeDto: SingleRecipeDto, navController: NavController) {
    val context = LocalContext.current
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
        item {
            if (recipeDto.recipe?.url?.isNotEmpty() == true) {
                RecipeUrl(modifier = Modifier.padding(horizontal = 12.dp)) {
                    goToRecipeUrl(recipeDto.recipe?.url ?: "", context)
                }
            }
        }
        item {
            if (recipeDto.recipe?.healthLabels?.isNotEmpty() == true) {
                FoodLabelsSection(
                    heading = "Health Labels",
                    modifier = Modifier
                        .padding(horizontal = 12.dp),
                    foodLabels = recipeDto.recipe?.healthLabels ?: emptyList()
                )
            }
        }
        item {
            if (recipeDto.recipe?.dietLabels?.isNotEmpty() == true) {
                FoodLabelsSection(
                    heading = "Diet Labels",
                    modifier = Modifier
                        .padding(horizontal = 12.dp),
                    foodLabels = recipeDto.recipe?.dietLabels ?: emptyList()
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FoodLabelsSection(
    modifier: Modifier = Modifier,
    foodLabels: List<String>,
    heading: String
) {
    Text(
        text = heading,
        modifier = modifier.padding(top = 12.dp, start = 12.dp, end = 12.dp, bottom = 4.dp),
        fontSize = 20.sp,
        fontFamily = PoppinsMedium,
    )
    FlowRow (
        modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )){
        if (foodLabels.size > 8) {
            foodLabels.take(8).forEach {
                Tag(tag = it)
            }
        } else {
            foodLabels.forEach {
                Tag(tag = it)
            }
        }
    }
}
@Composable
fun Tag(tag: String) {
    Box(
        modifier = Modifier
            .padding(6.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(10.dp)
    ) {
        Text(
            text = tag,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun RecipeUrl(
    modifier: Modifier,
    onUrlClick: () -> Unit
) {
    Button(onClick = onUrlClick, modifier = modifier) {
        Text(text = "Preparation")
        Spacer(modifier = Modifier.width(8.dp))
        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
    }
}
fun goToRecipeUrl(url: String, context: Context) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse(url)
    context.startActivity(intent)
}
