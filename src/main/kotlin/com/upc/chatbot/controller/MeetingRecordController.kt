package com.upc.chatbot.controller

import com.upc.chatbot.entity.MeetingRecord
import com.upc.chatbot.service.MeetingRecordService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/meeting")
class MeetingRecordController(private val meetingRecordService: MeetingRecordService) {

    @PostMapping
    fun create(@RequestBody meetingRecord: MeetingRecord): ResponseEntity<MeetingRecord> {
        return ResponseEntity.ok(meetingRecordService.create(meetingRecord))
    }

    @GetMapping
    fun getAll(): ResponseEntity<Iterable<MeetingRecord>> {
        return ResponseEntity.ok(meetingRecordService.getAll())
    }

    @GetMapping("/student/{studentId}")
    fun getAllByStudentId(@PathVariable studentId: String): ResponseEntity<Iterable<MeetingRecord>> {
        return ResponseEntity.ok(meetingRecordService.getAllByStudentId(studentId))
    }

    @GetMapping("/doctor/{doctorId}")
    fun getAllByDoctorId(@PathVariable doctorId: String): ResponseEntity<Iterable<MeetingRecord>> {
        return ResponseEntity.ok(meetingRecordService.getAllByDoctorId(doctorId))
    }
}