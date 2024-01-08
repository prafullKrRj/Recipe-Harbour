package com.prafullkumar.recipeharbour.presentations.homeScreen.homeScreenUI.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.prafullkumar.recipeharbour.R
import com.prafullkumar.recipeharbour.ui.theme.PoppinsSemiBold
import com.prafullkumar.recipeharbour.ui.theme.grey
import com.prafullkumar.recipeharbour.ui.theme.lightGrey
import com.prafullkumar.recipeharbour.ui.theme.lightGrey100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.home),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontFamily = PoppinsSemiBold,
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = lightGrey100
        )
    )
}
