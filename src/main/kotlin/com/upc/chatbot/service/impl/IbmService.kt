package com.upc.chatbot.service.impl

import com.ibm.cloud.sdk.core.security.IamAuthenticator
import com.ibm.watson.assistant.v2.Assistant
import com.ibm.watson.assistant.v2.model.*
import com.upc.chatbot.dto.MessageDto
import com.upc.chatbot.service.BotService
import com.upc.chatbot.util.AppProperties
import org.springframework.stereotype.Service


@Service
class IbmService(private var appProperties: AppProperties) : BotService {

    private var authentication: IamAuthenticator = IamAuthenticator.Builder().apikey(appProperties.ibmApiKey).build()
    private var assistant: Assistant = Assistant("2022-08-22", authentication).apply {
        serviceUrl = appProperties.ibmChatBotUrl
    }

    override fun createSession(userId: String): MessageDto {
        val options = CreateSessionOptions.Builder(appProperties.ibmAssistantId).build()
        val response = assistant.createSession(options).execute().result
        val sessionId = response.sessionId
        // Start conversation with empty message.
        val messageOptions = MessageStatelessOptions.Builder(appProperties.ibmAssistantId)
            .build()
        val responseStateless = assistant.messageStateless(messageOptions)
            .execute()
            .result
        // Print the output from dialog, if any. Assumes a single text response.
        val responseGeneric: List<RuntimeResponseGeneric> = responseStateless.output.generic
        if (responseGeneric.isNotEmpty()) {
            if (responseGeneric[0].responseType().equals("text")) {
                return MessageDto(responseGeneric[0].text(), sessionId)
            }
        }
        return MessageDto("Hi", sessionId)
    }

    override fun chat(userId: String, messageDto: MessageDto): MessageDto {
        val input: MessageInput = MessageInput.Builder()
            .messageType("text")
            .text(messageDto.message)
            .build()

        val options = MessageOptions.Builder(appProperties.ibmAssistantId, messageDto.sessionId)
            .input(input)
            .userId(userId)
            .build()
        val response: MessageResponse = assistant.message(options).execute().result
        return MessageDto(response.output.generic[0].text(), messageDto.sessionId)
    }

}

