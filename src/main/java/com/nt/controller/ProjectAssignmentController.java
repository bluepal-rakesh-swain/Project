package com.nt.controller;

import com.nt.dto.ProjectAssignmentRequestDTO;
import com.nt.dto.ProjectAssignmentResponseDTO;
import com.nt.service.ProjectAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class ProjectAssignmentController {

    private final ProjectAssignmentService service;

    @PostMapping("/add")
    public ResponseEntity<ProjectAssignmentResponseDTO> addAssignment(@RequestBody ProjectAssignmentRequestDTO requestDTO,@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(service.addAssignment(requestDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectAssignmentResponseDTO>> getAllAssignments(@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(service.getAllAssignments());
    }

//    @GetMapping("/employee/{employeeId}")
//    public ResponseEntity<List<ProjectAssignmentResponseDTO>> getAssignmentsByEmployee(@PathVariable String employeeId) {
//        return ResponseEntity.ok(service.getAssignmentsByEmployee(employeeId));
//    }
    
 // ✅ Update
    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectAssignmentResponseDTO> updateAssignment(
            @PathVariable String id,
            @RequestBody ProjectAssignmentRequestDTO requestDTO,@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(service.updateAssignment(id, requestDTO));
    }

    // ✅ Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAssignment(@PathVariable String id,@RequestHeader("Authorization") String jwt) {
    	service.deleteAssignment(id);
        return ResponseEntity.ok("Assignment deleted successfully with id " + id);
    }
}
