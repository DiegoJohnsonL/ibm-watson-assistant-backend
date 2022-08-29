package com.upc.chatbot.util

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class AppProperties {

    @Value("\${ibm.api.key}")
    lateinit var ibmApiKey: String

    @Value("\${ibm.api.base.url}")
    lateinit var ibmApiUrl: String

    @Value("\${ibm.api.chatbot.url}")
    lateinit var ibmChatBotUrl: String

    @Value("\${ibm.assistant.id}")
    lateinit var ibmAssistantId: String

}