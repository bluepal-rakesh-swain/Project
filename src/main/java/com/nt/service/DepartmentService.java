package com.nt.service;

import com.nt.dto.DepartmentRequestDTO;
import com.nt.dto.DepartmentResponseDTO;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDTO createDepartment(DepartmentRequestDTO dto);
    DepartmentResponseDTO getDepartmentById(String id);
    List<DepartmentResponseDTO> getAllDepartments();
    DepartmentResponseDTO updateDepartment(String id, DepartmentRequestDTO dto);
    void deleteDepartment(String id);
}
