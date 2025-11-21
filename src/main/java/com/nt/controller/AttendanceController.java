package com.nt.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.AttendanceRequestDTO;
import com.nt.dto.AttendanceResponseDTO;
import com.nt.service.AttendanceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService service;

    @PostMapping("/add")
    public ResponseEntity<AttendanceResponseDTO> markAttendance(@RequestBody AttendanceRequestDTO dto) {
        return ResponseEntity.ok(service.markAttendance(dto));
    }

//    @GetMapping("/{employeeId}")
//    public ResponseEntity<List<AttendanceResponseDTO>> getByEmployee(@PathVariable String employeeId) {
//        return ResponseEntity.ok(service.getAttendanceByEmployee(employeeId));
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AttendanceResponseDTO> update(@PathVariable String id, @RequestBody AttendanceRequestDTO dto) {
        return ResponseEntity.ok(service.updateAttendance(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        service.deleteAttendance(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
    @GetMapping("/all")
    public ResponseEntity<List<AttendanceResponseDTO>> getAllAttendance() {
        return ResponseEntity.ok(service.getAllAttendance());
    }

}
