package com.prafullkumar.recipeharbour.presentations.homeScreen.homeScreenUI.components

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.prafullkumar.recipeharbour.R
import com.prafullkumar.recipeharbour.presentations.homeScreen.HomeScreen
import com.prafullkumar.recipeharbour.ui.theme.darkBlue

@Composable
fun CategoriesRow(homeNavController: NavController) {
    val foodItems = listOf("Pizza", "Chicken", "Paneer", "Mutton", "Fish", "Egg", "Veg")
    HeadingText(id = R.string.category)
    LazyRow {
        items(foodItems.size) { index ->
            DishCard(img = R.drawable.img,index = index, homeNavController = homeNavController, foodItems = foodItems)
        }
    }
}

@Composable
fun DishCard(
    @DrawableRes img: Int,
    index: Int,
    homeNavController: NavController,
    foodItems: List<String>
) {
    val context = LocalContext.current
    ElevatedCard(
        modifier = Modifier
            .padding(
                start = if (index == 0) 16.dp else 0.dp,
                end = 8.dp
            )
            .width(150.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable(
                role = Role.Image
            ) {
                homeNavController.navigate(HomeScreen.RECIPE_DETAILS.route)
            }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = img,
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
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
            Text(text = foodItems[index], modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomStart)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onLongPress = {
                            copyToClipboard(context, foodItems[index])
                        }
                    )
                },
                color = Color.White
            )
        }
    }
}
fun copyToClipboard(context: Context, text: String) {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("label", text)
    clipboard.setPrimaryClip(clip)
    Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show()
}