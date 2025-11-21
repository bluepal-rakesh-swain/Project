package com.nt.controller;

import com.nt.dto.SalaryRequestDTO;
import com.nt.dto.SalaryResponseDTO;
import com.nt.service.SalaryDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salary")
@RequiredArgsConstructor
public class SalaryDetailsController {

    private final SalaryDetailsService salaryDetailsService;

    @PostMapping("/add")
    public ResponseEntity<SalaryResponseDTO> addSalaryDetails(@RequestBody SalaryRequestDTO dto,@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(salaryDetailsService.saveSalaryDetails(dto));
    }

//    @GetMapping("/employee/{employeeId}")
//    public ResponseEntity<List<SalaryResponseDTO>> getByEmployee(@PathVariable String employeeId) {
//        return ResponseEntity.ok(salaryDetailsService.getSalaryDetailsByEmployee(employeeId));
//    }

    @GetMapping("/all")
    public ResponseEntity<List<SalaryResponseDTO>> getAll(@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(salaryDetailsService.getAllSalaryDetails());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SalaryResponseDTO> update(@PathVariable String id, @RequestBody SalaryRequestDTO dto,@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(salaryDetailsService.updateSalaryDetails(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id,@RequestHeader("Authorization") String jwt) {
        salaryDetailsService.deleteSalaryDetails(id);
        return ResponseEntity.ok("Deleted successfully!");
    }
}
