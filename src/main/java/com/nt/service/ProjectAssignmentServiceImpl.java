package com.nt.service;

import com.nt.dto.ProjectAssignmentRequestDTO;
import com.nt.dto.ProjectAssignmentResponseDTO;
import com.nt.entity.ProjectAssignment;
import com.nt.repository.ProjectAssignmentRepository;
import com.nt.service.ProjectAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectAssignmentServiceImpl implements ProjectAssignmentService {

    private final ProjectAssignmentRepository repository;

    @Override
    public ProjectAssignmentResponseDTO addAssignment(ProjectAssignmentRequestDTO requestDTO) {
        ProjectAssignment assignment = ProjectAssignment.builder()
                .employeeName(requestDTO.getEmployeeName())
                .projectName(requestDTO.getProjectName())
                .role(requestDTO.getRole())
                .startDate(requestDTO.getStartDate())
                .endDate(requestDTO.getEndDate())
                .hoursWorked(requestDTO.getHoursWorked())
                .build();

        ProjectAssignment saved = repository.save(assignment);

        return mapToResponse(saved);
    }

    @Override
    public List<ProjectAssignmentResponseDTO> getAllAssignments() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<ProjectAssignmentResponseDTO> getAssignmentsByEmployee(String employeeId) {
//        return repository.findByEmployeeId(employeeId)
//                .stream()
//                .map(this::mapToResponse)
//                .collect(Collectors.toList());
//    }

    private ProjectAssignmentResponseDTO mapToResponse(ProjectAssignment assignment) {
        return ProjectAssignmentResponseDTO.builder()
                .id(assignment.getId())
                .employeeName(assignment.getEmployeeName())
                .projectName(assignment.getProjectName())
                .role(assignment.getRole())
                .startDate(assignment.getStartDate())
                .endDate(assignment.getEndDate())
                .hoursWorked(assignment.getHoursWorked())
                .build();
    }
 // ✅ Update Assignment
    @Override
    public ProjectAssignmentResponseDTO updateAssignment(String id, ProjectAssignmentRequestDTO requestDTO) {
        ProjectAssignment assignment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found with id " + id));

        assignment.setEmployeeName(requestDTO.getEmployeeName());
        assignment.setProjectName(requestDTO.getProjectName());
        assignment.setRole(requestDTO.getRole());
        assignment.setStartDate(requestDTO.getStartDate());
        assignment.setEndDate(requestDTO.getEndDate());
        assignment.setHoursWorked(requestDTO.getHoursWorked());

        ProjectAssignment updated = repository.save(assignment);
        return mapToResponse(updated);
    }

    // ✅ Delete Assignment
    @Override
    public void deleteAssignment(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Assignment not found with id " + id);
        }
        repository.deleteById(id);
    }

   
}
