package com.nt.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.PerformanceRequestDTO;
import com.nt.dto.PerformanceResponseDTO;
import com.nt.service.PerformanceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/performance")
@RequiredArgsConstructor
public class PerformanceController {

    private final PerformanceService service;

    @PostMapping("/add")
    public ResponseEntity<PerformanceResponseDTO> addPerformance(@RequestBody PerformanceRequestDTO dto,@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(service.addPerformance(dto));
    }

//    @GetMapping("/{employeeId}")
//    public ResponseEntity<List<PerformanceResponseDTO>> getByEmployee(@PathVariable String employeeId) {
//        return ResponseEntity.ok(service.getByEmployee(employeeId));
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PerformanceResponseDTO> update(@PathVariable String id, @RequestBody PerformanceRequestDTO dto,@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(service.updatePerformance(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id,@RequestHeader("Authorization") String jwt) {
        service.deletePerformance(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
    // 📋 Get all performance records
    @GetMapping("/all")
    public ResponseEntity<List<PerformanceResponseDTO>> getAllPerformance(@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(service.getAllPerformance());
    }
}
