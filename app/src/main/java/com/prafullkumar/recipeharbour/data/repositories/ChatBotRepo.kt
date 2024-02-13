package com.prafullkumar.recipeharbour.data.repositories

import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import com.prafullkumar.recipeharbour.presentations.aiScreen.Participant

interface ChatBotRepository {
    suspend fun sendMessage(message: String): Response

}

class ChatBotRepositoryImpl : ChatBotRepository {
    private val generativeModel = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = "AIzaSyBZqGVCyyzROabsi4r2ccYT9HNCWZ62h58"
    )
    private val chat = generativeModel.startChat(
        history = listOf(
            content(role = Participant.USER.role) {
                text(Constants.startingQuery)
            },
            content(role = Participant.MODEL.role) {
                text("Ok")
            }
        )
    )
    override suspend fun sendMessage(message: String): Response {
        return try {
            val response = chat.sendMessage(message)
            Response.Success(response.text)
        } catch (e: Exception) {
            Response.Error(e.message ?: "Unknown error")
        }
    }
}
sealed class Response {
    data class Success(val message: String?) : Response()
    data class Error(val message: String) : Response()
}
private object Constants {
    const val startingQuery = "Answer as you are providing me recipe or all my prompts are related to food and particular food name when to eat food which type of food and some common question related to food nutrition recipe if you think the question is out of domain then give some answer related to food and write give relevant prompts, if you think the answer can be small give short answers and if you think the answer then give some brief and asks user if they want in detail"

}