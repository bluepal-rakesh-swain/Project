//package com.nt.service;
//
//import com.nt.dto.DepartmentRequestDTO;
//import com.nt.dto.DepartmentResponseDTO;
//import com.nt.entity.Department;
//import com.nt.repository.DepartmentRepository;
//import com.nt.service.DepartmentService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class DepartmentServiceImpl implements DepartmentService {
//
//    private final DepartmentRepository departmentRepository;
//
//    @Override
//    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto) {
//        Department dept = Department.builder()
//                .department(dto.getDepartment())
//                .description(dto.getDescription())
//                .build();
//        Department saved = departmentRepository.save(dept);
//        return mapToDTO(saved);
//    }
//
//    @Override
//    public DepartmentResponseDTO getDepartmentById(String id) {
//        Department dept = departmentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Department not found"));
//        return mapToDTO(dept);
//    }
//
//    @Override
//    public List<DepartmentResponseDTO> getAllDepartments() {
//        return departmentRepository.findAll().stream()
//                .map(this::mapToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public DepartmentResponseDTO updateDepartment(String id, DepartmentRequestDTO dto) {
//        Department dept = departmentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Department not found"));
//        dept.setDepartment(dto.getDepartment());
//        dept.setDescription(dto.getDescription());
//        return mapToDTO(departmentRepository.save(dept));
//    }
//
//    @Override
//    public void deleteDepartment(String id) {
//        departmentRepository.deleteById(id);
//    }
//
//    private DepartmentResponseDTO mapToDTO(Department dept) {
//        return DepartmentResponseDTO.builder()
//                .id(dept.getId())
//                .department(dept.getDepartment())
//                .description(dept.getDescription())
//                .build();
//    }
//}



package com.nt.service;

import com.nt.dto.DepartmentRequestDTO;
import com.nt.dto.DepartmentResponseDTO;
import com.nt.entity.Department;
import com.nt.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j   // Lombok will inject a logger named "log"
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto) {
        log.info("Creating new department: {}, description: {}", dto.getDepartment(), dto.getDescription());

        Department dept = Department.builder()
                .department(dto.getDepartment())
                .description(dto.getDescription())
                .build();

        Department saved = departmentRepository.save(dept);
        log.debug("Department saved with ID: {}", saved.getId());

        return mapToDTO(saved);
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(String id) {
        log.info("Fetching department with ID: {}", id);

        Department dept = departmentRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Department not found for ID: {}", id);
                    return new RuntimeException("Department not found");
                });

        log.debug("Department found: {}", dept.getDepartment());
        return mapToDTO(dept);
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        log.info("Fetching all departments");

        List<DepartmentResponseDTO> list = departmentRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

        log.debug("Total departments fetched: {}", list.size());
        return list;
    }

    @Override
    public DepartmentResponseDTO updateDepartment(String id, DepartmentRequestDTO dto) {
        log.info("Updating department with ID: {}", id);

        Department dept = departmentRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Department not found for ID: {}", id);
                    return new RuntimeException("Department not found");
                });

        dept.setDepartment(dto.getDepartment());
        dept.setDescription(dto.getDescription());

        Department updated = departmentRepository.save(dept);
        log.debug("Department updated successfully with ID: {}", updated.getId());

        return mapToDTO(updated);
    }

    @Override
    public void deleteDepartment(String id) {
        log.warn("Deleting department with ID: {}", id);
        departmentRepository.deleteById(id);
        log.info("Department deleted successfully for ID: {}", id);
    }

    private DepartmentResponseDTO mapToDTO(Department dept) {
        return DepartmentResponseDTO.builder()
                .id(dept.getId())
                .department(dept.getDepartment())
                .description(dept.getDescription())
                .build();
    }
}

