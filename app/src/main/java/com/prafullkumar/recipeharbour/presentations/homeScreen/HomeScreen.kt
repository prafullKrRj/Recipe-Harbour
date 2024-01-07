package com.prafullkumar.recipeharbour.presentations.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prafullkumar.recipeharbour.R
import com.prafullkumar.recipeharbour.ui.theme.darkBlue
import com.prafullkumar.recipeharbour.ui.theme.grey

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    Scaffold (
        topBar = { TopBar() }
    ) { paddingValues ->

        LazyColumn(modifier = Modifier, contentPadding = paddingValues) {
            item {
                CategoriesRow()
            }
        }
    }
}


@Composable
fun CategoriesRow() {
    val foodItems = listOf("Pizza", "Chicken", "Paneer", "Mutton", "Fish", "Egg", "Veg")
    Text(
        text = stringResource(id = R.string.category),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold
    )
    LazyRow {
        items(foodItems.size) { index ->
            ElevatedCard(
                modifier = Modifier
                    .padding(
                        start = if (index == 0) 16.dp else 0.dp,
                        end = 8.dp
                    )
                    .width(150.dp)
                    .height(200.dp)

            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(painter = painterResource(id = R.drawable.img), contentDescription = null, contentScale = ContentScale.FillBounds)
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
                        .align(Alignment.BottomStart),
                        color = Color.White
                    )
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.home),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    )
}
