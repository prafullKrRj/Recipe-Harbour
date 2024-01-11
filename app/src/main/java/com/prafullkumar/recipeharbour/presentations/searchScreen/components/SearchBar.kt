package com.prafullkumar.recipeharbour.presentations.searchScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.prafullkumar.recipeharbour.presentations.searchScreen.SearchViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RecipeSearchBar(
    modifier: Modifier,
    searchViewModel: SearchViewModel,
    keyboardController: SoftwareKeyboardController?,
    focusRequester: FocusRequester
) {
    val color = MaterialTheme.colorScheme.secondaryContainer
    LaunchedEffect(key1 = Unit, block = {
        focusRequester.requestFocus()
    })
    OutlinedTextField(
        modifier = modifier
            .padding(16.dp)
            .padding(top = 8.dp)
            .fillMaxWidth()
            .focusRequester(focusRequester = focusRequester),
        value = searchViewModel.searchQuery.value,
        onValueChange = {
            searchViewModel.searchQuery.value = it
        },
        shape = RoundedCornerShape(55.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = color,
            focusedContainerColor = color,
            unfocusedContainerColor = color,
            unfocusedIndicatorColor = color,
            focusedLabelColor = MaterialTheme.colorScheme.onTertiaryContainer
        ),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        trailingIcon = {
            IconButton(onClick = {
                keyboardController?.hide()
                if (searchViewModel.searchQuery.value.isNotEmpty()) {
                    searchViewModel.searchDishes(searchViewModel.searchQuery.value)
                }
            }) {
                Icon(imageVector = Icons.Default.Send, contentDescription = null)
            }
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            keyboardController?.hide()
            if (searchViewModel.searchQuery.value.isNotEmpty()) {
                searchViewModel.searchDishes(searchViewModel.searchQuery.value)
            }
        })
        , singleLine = true,
        maxLines = 1,
        label = {
            Text(text = "Search")
        }
    )
}