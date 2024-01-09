package com.prafullkumar.recipeharbour.presentations.searchScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.prafullkumar.recipeharbour.presentations.searchScreen.components.RecipeSearchBar

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreenMain(searchViewModel: SearchViewModel) {
    val focusRequester = remember {
        FocusRequester()
    }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    Scaffold (
        topBar = {
            RecipeSearchBar(
                modifier = Modifier,
                onSearched = {
                             focusManager.clearFocus()
                },
                keyboardController = keyboardController,
                focusRequester = focusRequester,
                onValueChange = {

                }
            )
        }
    ){  paddingValues ->
        LazyColumn(
            contentPadding = paddingValues
        ) {

        }
    }
}
