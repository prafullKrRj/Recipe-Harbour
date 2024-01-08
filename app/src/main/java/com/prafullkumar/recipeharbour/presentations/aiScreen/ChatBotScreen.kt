package com.prafullkumar.recipeharbour.presentations.aiScreen

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun ChatBotScreenMain(chatBotMainViewModel: ChatBotMainViewModel) {
    Text(
        modifier = Modifier,
        text = "ChatBotScreenMain",
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Start,
    )
}