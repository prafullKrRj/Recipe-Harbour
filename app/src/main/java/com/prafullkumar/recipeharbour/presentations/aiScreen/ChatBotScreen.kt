package com.prafullkumar.recipeharbour.presentations.aiScreen

import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun ChatBotScreenMain(chatBotMainViewModel: ChatBotMainViewModel) {
    val chatState = chatBotMainViewModel.chatStateFlow.collectAsState()
    Scaffold (
        bottomBar = {
            var text by rememberSaveable { mutableStateOf("") }
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Label") },
                trailingIcon = {
                    IconButton(onClick = {
                        if (text.isNotEmpty()) {
                            chatBotMainViewModel.generateContent(text = text)
                            text = ""
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Send, contentDescription = null)
                    }
                }
            )
        }
    ){paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ) {
            repeat(chatState.value.messages.size) {
                Text(text = chatState.value.messages[0].parts[0].toString())
            }
        }
    }
}