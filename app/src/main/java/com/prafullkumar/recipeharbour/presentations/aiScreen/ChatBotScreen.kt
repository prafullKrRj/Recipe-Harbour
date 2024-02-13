package com.prafullkumar.recipeharbour.presentations.aiScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.dp
import com.prafullkumar.recipeharbour.ui.theme.oceanBlue

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
        ChatScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            messages = chatBotMainViewModel.messages,
            state = chatState
        )
    }
}
@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    messages: List<Message> = emptyList(),
    state: ChatUiState = ChatUiState.Initial
) {
    LazyColumn(modifier = modifier, reverseLayout = true) {
        item {
            if (state == ChatUiState.Loading) {
                CircularProgressIndicator()
            }
        }
        messages.forEach { message ->
            item {
                ChatBubble(message = message)
            }
        }
    }
}
@Composable
fun ChatBubble(modifier: Modifier = Modifier, message: Message) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = if (message.person == Participant.USER) {
            Arrangement.End
        } else {
            Arrangement.Start
        }
    ) {
        Card (
            modifier = Modifier
                .padding(
                    vertical = 8.dp,
                )
                .padding(
                    start = if (message.person == Participant.USER) 32.dp else 8.dp,
                    end = if (message.person == Participant.USER) 8.dp else 32.dp
                )
                .fillMaxWidth()
            ,
            colors = CardDefaults.cardColors(
                containerColor = if (message.person == Participant.USER) oceanBlue else Color(0xFFBDBDBD)
            )
        ){
            Text(text = message.text, modifier = Modifier.padding(16.dp))
        }
    }
}
