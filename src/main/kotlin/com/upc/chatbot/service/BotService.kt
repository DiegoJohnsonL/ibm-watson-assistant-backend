package com.upc.chatbot.service

import com.upc.chatbot.dto.MessageDto

interface BotService {
    fun createSession(userId: String): MessageDto
    fun chat(userId: String, messageDto: MessageDto): MessageDto
}