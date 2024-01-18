package com.prafullkumar.recipeharbour.presentations.aiScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ChatBotScreenMain(chatBotMainViewModel: ChatBotMainViewModel) {
    val chatState by chatBotMainViewModel.uiState.collectAsState()
    Scaffold (
        bottomBar = {
            var text by rememberSaveable { mutableStateOf("") }
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Label") },
                trailingIcon = {
                    IconButton(onClick = {
                        chatBotMainViewModel.sendMessage(text)
                    }) {
                        Icon(imageVector = Icons.Default.Send, contentDescription = null)
                    }
                }
            )
        }
    ){ paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ) {
            when (chatState) {
                is ChatUiState.Initial -> {
                    Text(text = "Initial")
                }
                is ChatUiState.Loading -> {
                    CircularProgressIndicator()
                }
                is ChatUiState.Success -> {
                    SuccessScreen(
                        messages = chatBotMainViewModel.messages
                    )
                }
                else -> {
                    Text(text = "Error")
                }
            }
        }
    }
}
@Composable
fun SuccessScreen(modifier: Modifier = Modifier, messages: List<Message> = emptyList()) {
    Column(modifier = modifier) {
        messages.forEach { message ->
            Text(
                text = message.text,
                color = if (message.person == Participant.USER) Color.Blue else Color.Green,
            )
        }
    }
}