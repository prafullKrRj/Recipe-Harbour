package com.prafullkumar.recipeharbour.presentations.aiScreen

import android.graphics.Bitmap
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.Content
import com.google.ai.client.generativeai.type.content
import com.prafullkumar.recipeharbour.data.repositories.ChatBotRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ChatBotMainViewModel(
    private val chatBotRepository: ChatBotRepository
): ViewModel() {

    private val chatState: MutableStateFlow<ChatState> = MutableStateFlow(ChatState())
    val chatStateFlow = chatState.asStateFlow()

    private val generativeModel = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = "AIzaSyBZqGVCyyzROabsi4r2ccYT9HNCWZ62h58"
    )
    private val chat = generativeModel.startChat(
        history = listOf()
    )

    fun generateContent(image: Bitmap? = null, text: String) {
        chatState.update {
            it.copy(loading = true)
        }
        viewModelScope.launch {
            val content = content(
                role = Person.USER.role
            ) {
                if (image != null) {
                    image(image)
                    text("give recipe of this image")
                } else {
                    text(text)
                }
            }
            val response = chat.sendMessage(content)
            chatState.update {
                it.copy(
                    messages = it.messages + content + response.candidates[0].content,
                    loading = false
                )
            }
        }
    }
}
data class ChatState(
    val messages: List<Content> = emptyList(),
    val loading: Boolean = false,
)
enum class Person(val role: String) {
    USER("user"),
    MODEL("model")
}