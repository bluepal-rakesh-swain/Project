package com.nt.service;

import java.util.List;

import com.nt.dto.AttendanceRequestDTO;
import com.nt.dto.AttendanceResponseDTO;

public interface AttendanceService {
    AttendanceResponseDTO markAttendance(AttendanceRequestDTO dto);
   // List<AttendanceResponseDTO> getAttendanceByEmployee(String employeeId);
    AttendanceResponseDTO updateAttendance(String id, AttendanceRequestDTO dto);
    void deleteAttendance(String id);
    // ✅ New method to fetch all attendance records
    List<AttendanceResponseDTO> getAllAttendance();
}
