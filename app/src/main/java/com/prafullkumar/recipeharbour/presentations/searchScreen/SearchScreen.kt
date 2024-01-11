package com.prafullkumar.recipeharbour.presentations.searchScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prafullkumar.recipeharbour.R
import com.prafullkumar.recipeharbour.model.recipeFromNameDto.Hits
import com.prafullkumar.recipeharbour.presentations.searchScreen.components.RecipeSearchBar
import com.prafullkumar.recipeharbour.presentations.searchScreen.components.SearchedRecipeCard
import com.prafullkumar.recipeharbour.ui.theme.PoppinsMedium
import com.prafullkumar.recipeharbour.ui.theme.PoppinsRegular

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreenMain(searchViewModel: SearchViewModel) {
    val focusRequester = remember {
        FocusRequester()
    }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val searchState = searchViewModel.searchState.collectAsState()

    Scaffold (
        topBar = {
            RecipeSearchBar(
                modifier = Modifier,
                searchViewModel = searchViewModel,
                keyboardController = keyboardController,
                focusRequester = focusRequester
            )
        }
    ){  paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .pointerInput(Unit) {
                    focusManager.clearFocus()
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (searchState.value) {
                is SearchState.Success -> {
                    SuccessScreen(items = (searchState.value as SearchState.Success).dishes.hits)
                }
                is SearchState.Error -> {
                    Text(text = (searchState.value as SearchState.Error).error, fontSize = 50.sp, fontFamily = PoppinsMedium)
                }
                is SearchState.Empty -> {
                    EmptyScreen(historyItem = searchViewModel.history.value) {
                        searchViewModel.searchDishes(it)
                        searchViewModel.searchQuery.value = it
                    }
                }
                is SearchState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}

@Composable
fun EmptyScreen(historyItem: List<String>, onClick: (String) -> Unit = {}) {
    LazyColumn(
        Modifier.fillMaxSize()
    ) {
        items(historyItem) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        onClick(item)
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item,
                    fontSize = 16.sp,
                    fontFamily = PoppinsRegular,
                    fontWeight = FontWeight.W300
                )
                Icon(
                    painter = painterResource(id = R.drawable.sharp_arrow_outward_24),
                    contentDescription = "Go To",
                    modifier = Modifier.rotate(-90f)
                )
            }
        }
    }
}
@Composable
fun SuccessScreen(items: List<Hits>) {
    LazyVerticalGrid(columns = GridCells.Adaptive(150.dp)) {
        items(items) { item ->
            SearchedRecipeCard(hit = item)
        }
    }
}
