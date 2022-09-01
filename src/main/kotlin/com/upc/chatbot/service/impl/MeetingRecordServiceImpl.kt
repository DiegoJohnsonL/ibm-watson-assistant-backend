package com.upc.chatbot.service.impl

import com.upc.chatbot.entity.MeetingRecord
import com.upc.chatbot.repository.MeetingRecordRepository
import com.upc.chatbot.service.MeetingRecordService
import org.springframework.stereotype.Service

@Service
class MeetingRecordServiceImpl(private val meetingRepository: MeetingRecordRepository) : MeetingRecordService {

    override fun create(meetingRecord: MeetingRecord): MeetingRecord {
        return meetingRepository.save(meetingRecord)
    }

    override fun getAll(): Iterable<MeetingRecord> {
        return meetingRepository.findAll()
    }

    override fun getAllByStudentId(studentId: String): Iterable<MeetingRecord> {
        return meetingRepository.getAllByStudentId(studentId)
    }

    override fun getAllByDoctorId(doctorId: String): Iterable<MeetingRecord> {
        return meetingRepository.getAllByDoctorId(doctorId)
    }
}