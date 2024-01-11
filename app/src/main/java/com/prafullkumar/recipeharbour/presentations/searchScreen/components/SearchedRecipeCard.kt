package com.prafullkumar.recipeharbour.presentations.searchScreen.components

import android.media.ImageReader
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.prafullkumar.recipeharbour.R
import com.prafullkumar.recipeharbour.model.recipeFromNameDto.Hits
import com.prafullkumar.recipeharbour.ui.theme.darkBlue

@Composable
fun SearchedRecipeCard(
    hit: Hits
) {
    ElevatedCard(
        modifier = Modifier
            .padding(
                8.dp
            )
            .width(150.dp)
            .height(220.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable {

            }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            SearchedDishImage(data = hit.recipe?.image ?: "")
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
            Text(text = hit.recipe?.label ?: "", modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomStart),
                color = Color.White
            )
        }
    }
}

@Composable
fun SearchedDishImage(data: String) {
    AsyncImage(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp)),
        model = ImageRequest.Builder(LocalContext.current)
            .data(data)
            .build(),
        contentScale = ContentScale.FillBounds,
        contentDescription = null,
        placeholder = painterResource(id = R.drawable.loading_img),
        error = painterResource(id = R.drawable.ic_broken_image)
    )
}