package com.upc.chatbot.service

import com.upc.chatbot.entity.MeetingRecord

interface MeetingRecordService {
    fun create(meetingRecord: MeetingRecord): MeetingRecord
    fun getAll(): Iterable<MeetingRecord>
    fun getAllByStudentId(studentId: String): Iterable<MeetingRecord>
    fun getAllByDoctorId(doctorId: String): Iterable<MeetingRecord>
}