package com.upc.chatbot.controller

import com.upc.chatbot.dto.MessageDto
import com.upc.chatbot.service.BotService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/chatbot")
class ChatBotController(var ibmService: BotService) {

    @GetMapping("/{userId}/create-session")
    fun createSession(@PathVariable("userId") userId: String): ResponseEntity<MessageDto> {
        return ResponseEntity.ok(ibmService.createSession(userId))
    }

    @PostMapping("/{userId}/chat")
    fun sendMessage(
        @PathVariable("userId") userId: String,
        @RequestBody messageDto: MessageDto
    ): ResponseEntity<MessageDto> {
        return ResponseEntity.ok(ibmService.chat(userId, messageDto))
    }

}