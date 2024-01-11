package com.prafullkumar.recipeharbour.presentations.searchScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prafullkumar.recipeharbour.model.recipeFromNameDto.Hits
import com.prafullkumar.recipeharbour.presentations.searchScreen.components.RecipeSearchBar
import com.prafullkumar.recipeharbour.presentations.searchScreen.components.SearchedRecipeCard
import com.prafullkumar.recipeharbour.ui.theme.PoppinsMedium

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
                is SearchState.Loading -> {
                    CircularProgressIndicator()
                }
                is SearchState.Error -> {
                    Text(text = (searchState.value as SearchState.Error).error, fontSize = 50.sp, fontFamily = PoppinsMedium)
                }
                is SearchState.Empty -> {
                    Text(text = "Empty", fontSize = 50.sp, fontFamily = PoppinsMedium)
                }
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
