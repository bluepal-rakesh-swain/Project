package com.nt.controller;

import com.nt.dto.DepartmentRequestDTO;
import com.nt.dto.DepartmentResponseDTO;
import com.nt.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<DepartmentResponseDTO> create(@RequestBody DepartmentRequestDTO dto,@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(departmentService.createDepartment(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentResponseDTO>> getAll(@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DepartmentResponseDTO> update(@PathVariable String id,
                                                        @RequestBody DepartmentRequestDTO dto,@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id,@RequestHeader("Authorization") String jwt) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department deleted successfully");
    }
}
