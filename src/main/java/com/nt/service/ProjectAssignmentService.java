package com.nt.service;

import com.nt.dto.ProjectAssignmentRequestDTO;
import com.nt.dto.ProjectAssignmentResponseDTO;

import java.util.List;

public interface ProjectAssignmentService {
    ProjectAssignmentResponseDTO addAssignment(ProjectAssignmentRequestDTO requestDTO);
    List<ProjectAssignmentResponseDTO> getAllAssignments();
    //List<ProjectAssignmentResponseDTO> getAssignmentsByEmployee(String employeeId);
    
    // New Methods
    ProjectAssignmentResponseDTO updateAssignment(String id, ProjectAssignmentRequestDTO requestDTO);
    void deleteAssignment(String id);
}
