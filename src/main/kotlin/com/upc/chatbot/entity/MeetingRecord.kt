package com.upc.chatbot.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class MeetingRecord(
    var studentId: String,
    var doctorId: String,
    var description: String,
    var diagnosis: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
)