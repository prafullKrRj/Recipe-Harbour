package com.prafullkumar.recipeharbour.presentations.recipeScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.prafullkumar.recipeharbour.R
import com.prafullkumar.recipeharbour.model.singleRecipeDto.Images
import com.prafullkumar.recipeharbour.presentations.recipeScreen.RecipeDetailsViewModel


@Composable
fun RecipeImage(
    modifier: Modifier,
    images: Images = Images(),
    isBookMarked: Boolean,
    viewModel: RecipeDetailsViewModel,
    backHandler: () -> Unit = {}
) {
    val context = LocalContext.current
    var imageType by rememberSaveable {
        mutableStateOf(ImageTypes.LARGE.name)
    }
    var imageData by rememberSaveable {
        mutableStateOf(
            when (imageType) {
                ImageTypes.LARGE.name -> images.LARGE?.url
                ImageTypes.REGULAR.name -> images.REGULAR?.url
                ImageTypes.SMALL.name -> images.SMALL?.url
                ImageTypes.THUMBNAIL.name -> images.THUMBNAIL?.url
                else -> images.LARGE?.url
            }
        )
    }
    var bookmarked by rememberSaveable {
        mutableStateOf(isBookMarked)
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context).data(imageData).build(), contentDescription = null,
            placeholder = painterResource(id = R.drawable.loading_img),
            error = painterResource(id = R.drawable.loading_img),
            onSuccess = {

            },
            contentScale = ContentScale.FillWidth,
            onError = {
                imageData = when (imageType) {
                    ImageTypes.LARGE.name -> images.REGULAR?.url
                    ImageTypes.REGULAR.name -> images.SMALL?.url
                    ImageTypes.SMALL.name -> images.THUMBNAIL?.url
                    ImageTypes.THUMBNAIL.name -> images.LARGE?.url
                    else -> images.LARGE?.url
                }
            },
            modifier = Modifier.fillMaxSize()
        )
        Row(
            Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = backHandler
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Go Back",
                    tint = Color.White
                )
            }
            IconButton(
                onClick = {
                    bookmarked = !bookmarked
                }
            ) {
                Icon(
                    painterResource(id =
                    if (bookmarked) R.drawable.baseline_bookmark_24 else R.drawable.outline_bookmark_24
                    ),
                    contentDescription = "BookMark",
                    tint = Color.White
                )
            }
        }
    }
}
enum class ImageTypes {
    LARGE,
    REGULAR,
    SMALL,
    THUMBNAIL
}