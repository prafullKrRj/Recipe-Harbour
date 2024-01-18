package com.prafullkumar.recipeharbour.presentations.aiScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prafullkumar.recipeharbour.data.repositories.ChatBotRepository
import com.prafullkumar.recipeharbour.data.repositories.Response
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ChatBotMainViewModel(
    private val chatBotRepository: ChatBotRepository
): ViewModel() {
    private val _uiState:MutableStateFlow<ChatUiState> =
        MutableStateFlow(ChatUiState.Initial)
    val uiState = _uiState.asStateFlow()
    val messages: MutableList<Message> = mutableListOf()
    fun sendMessage(message: String) {
        _uiState.update {
            ChatUiState.Loading
        }
        messages.add(
            Message(
                text = message,
                person = Participant.USER,
                messageType = MessageType.USER
            )
        )
        viewModelScope.launch {

            val response: Response = chatBotRepository.sendMessage(message)
            when(response) {
                is Response.Success -> {
                    messages.add(
                        Message(
                            text = response.message ?: "No response",
                            person = Participant.MODEL,
                            messageType = MessageType.USER
                        )
                    )
                    _uiState.value = ChatUiState.Success
                }
                is Response.Error -> {
                    _uiState.value = ChatUiState.Error(response.message)
                }
            }
        }
    }
}
sealed interface ChatUiState {
    data object Initial : ChatUiState
    data object Loading : ChatUiState
    data object Success : ChatUiState
    data class Error(
        val errorMessage: String
    ) : ChatUiState
}
data class Message(
    val text: String,
    val person: Participant,
    val messageType: MessageType
)
enum class Participant(val role: String) {
    USER("user"),
    MODEL("model")
}
