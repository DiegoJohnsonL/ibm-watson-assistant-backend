package com.upc.chatbot.repository

import com.upc.chatbot.entity.MeetingRecord
import org.springframework.data.repository.CrudRepository

interface MeetingRecordRepository : CrudRepository<MeetingRecord, Long> {

    fun getAllByStudentId(studentId: String): MutableList<MeetingRecord>
    fun getAllByDoctorId(doctorId: String): MutableList<MeetingRecord>

}