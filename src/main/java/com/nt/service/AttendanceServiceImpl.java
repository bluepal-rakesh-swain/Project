//package com.nt.service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.stereotype.Service;
//
//import com.nt.dto.AttendanceRequestDTO;
//import com.nt.dto.AttendanceResponseDTO;
//import com.nt.entity.Attendance;
//import com.nt.repository.AttendanceRepository;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class AttendanceServiceImpl implements AttendanceService {
//
//    private final AttendanceRepository repository;
//
//    @Override
//    public AttendanceResponseDTO markAttendance(AttendanceRequestDTO dto) {
//        Attendance attendance = Attendance.builder()
//                .employeeName(dto.getEmployeeName())
//                .date(dto.getDate())
//                .status(dto.getStatus())
//                .build();
//        Attendance saved = repository.save(attendance);
//
//        return toResponse(saved);
//    }
//
//    @Override
//    public AttendanceResponseDTO updateAttendance(String id, AttendanceRequestDTO dto) {
//        Attendance attendance = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Attendance not found"));
//        attendance.setEmployeeName(dto.getEmployeeName());
//        attendance.setDate(dto.getDate());
//        attendance.setStatus(dto.getStatus());
//        Attendance updated = repository.save(attendance);
//        return toResponse(updated);
//    }
//
//    @Override
//    public void deleteAttendance(String id) {
//        repository.deleteById(id);
//    }
//
//    private AttendanceResponseDTO toResponse(Attendance attendance) {
//        AttendanceResponseDTO dto = new AttendanceResponseDTO();
//        dto.setId(attendance.getId());
//        dto.setEmployeeName(attendance.getEmployeeName());
//        dto.setDate(attendance.getDate());
//        dto.setStatus(attendance.getStatus());
//        return dto;
//    }
//    
//
//    @Override
//    public List<AttendanceResponseDTO> getAllAttendance() {
//        return repository.findAll()
//                .stream()
//                .map(a -> new AttendanceResponseDTO(a.getId(), a.getEmployeeName(), a.getDate(), a.getStatus()))
//                .collect(Collectors.toList());
//    }
//}




package com.nt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nt.dto.AttendanceRequestDTO;
import com.nt.dto.AttendanceResponseDTO;
import com.nt.entity.Attendance;
import com.nt.repository.AttendanceRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j   // <-- This gives you a "log" object
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository repository;

    @Override
    public AttendanceResponseDTO markAttendance(AttendanceRequestDTO dto) {
        log.info("Marking attendance for employee: {}, date: {}, status: {}",
                dto.getEmployeeName(), dto.getDate(), dto.getStatus());

        Attendance attendance = Attendance.builder()
                .employeeName(dto.getEmployeeName())
                .date(dto.getDate())
                .status(dto.getStatus())
                .build();

        Attendance saved = repository.save(attendance);
        log.debug("Attendance saved with ID: {}", saved.getId());

        return toResponse(saved);
    }

    @Override
    public AttendanceResponseDTO updateAttendance(String id, AttendanceRequestDTO dto) {
        log.info("Updating attendance with ID: {}", id);

        Attendance attendance = repository.findById(id)
                .orElseThrow(() -> {
                    log.error("Attendance not found for ID: {}", id);
                    return new RuntimeException("Attendance not found");
                });

        attendance.setEmployeeName(dto.getEmployeeName());
        attendance.setDate(dto.getDate());
        attendance.setStatus(dto.getStatus());

        Attendance updated = repository.save(attendance);
        log.debug("Attendance updated successfully for ID: {}", updated.getId());

        return toResponse(updated);
    }

    @Override
    public void deleteAttendance(String id) {
        log.warn("Deleting attendance with ID: {}", id);
        repository.deleteById(id);
        log.info("Attendance deleted successfully for ID: {}", id);
    }

    private AttendanceResponseDTO toResponse(Attendance attendance) {
        return new AttendanceResponseDTO(
                attendance.getId(),
                attendance.getEmployeeName(),
                attendance.getDate(),
                attendance.getStatus()
        );
    }

    @Override
    public List<AttendanceResponseDTO> getAllAttendance() {
        log.info("Fetching all attendance records");
        List<AttendanceResponseDTO> list = repository.findAll()
                .stream()
                .map(a -> new AttendanceResponseDTO(a.getId(), a.getEmployeeName(), a.getDate(), a.getStatus()))
                .collect(Collectors.toList());

        log.debug("Total attendance records found: {}", list.size());
        return list;
    }
}

