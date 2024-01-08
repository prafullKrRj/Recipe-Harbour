package com.prafullkumar.recipeharbour.presentations.homeScreen.homeScreenUI.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prafullkumar.recipeharbour.ui.theme.PoppinsRegular

@Composable
fun HeadingText(
    @StringRes id: Int,
) {
    Text(
        text = stringResource(id = id),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        fontSize = 18.sp,
        fontFamily = PoppinsRegular,
        fontWeight = FontWeight.SemiBold
    )
}