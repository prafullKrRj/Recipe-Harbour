package com.prafullkumar.recipeharbour.presentations.searchScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreenMain(searchViewModel: SearchViewModel) {
    val focusRequester = remember {
        FocusRequester()
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    Scaffold (
        topBar = {
            SearchField(
                modifier = Modifier,
                onSearched = {},
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
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchField(
    modifier: Modifier,
    onSearched: (String) -> Unit,
    keyboardController: SoftwareKeyboardController?,
    focusRequester: FocusRequester,
    onValueChange: (String) -> Unit
) {

    var userSearch by rememberSaveable {
        mutableStateOf("")
    }
    val color = MaterialTheme.colorScheme.secondaryContainer

    OutlinedTextField(
        modifier = modifier
            .padding(16.dp)
            .padding(top = 8.dp)
            .focusRequester(focusRequester = focusRequester),
        value = userSearch,
        onValueChange = {
            userSearch = it
            onValueChange(it)
        },
        shape = RoundedCornerShape(55.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = color,
            unfocusedContainerColor = color,
            focusedLabelColor = MaterialTheme.colorScheme.onTertiaryContainer
        ),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        trailingIcon = {
            IconButton(onClick = {
                if (userSearch.isNotEmpty()) {
                    onSearched(userSearch)
                }
            }) {
                Icon(imageVector = Icons.Default.Send, contentDescription = null)
            }
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            keyboardController?.hide()
            if (userSearch.isNotEmpty()) {
                onSearched(userSearch)
            }
        })
        , singleLine = true,
        maxLines = 1,
        label = {
            Text(text = "Search")
        }
    )
}