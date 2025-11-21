package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.dto.EmployeeRequestDTO;
import com.nt.dto.EmployeeResponseDTO;
import com.nt.entity.Employee;

public interface EmployeeService {
    
	//EmployeeResponseDTO createEmployee(EmployeeRequestDTO request , String userId);
	//EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto, String loggedInUserId);
    //EmployeeResponseDTO updateEmployee(String id, EmployeeRequestDTO request , String userId);
    void deleteEmployee(String id);
   // EmployeeResponseDTO getEmployeeById(String id);
    Page<EmployeeResponseDTO> getAllEmployees(int page, int size, String sortBy, String sortDir, String search);
 // 👇 New method
    //EmployeeResponseDTO getEmployeeByUserId(String userId);
    //EmployeeResponseDTO getemployeeProfile(EmployeeRequestDTO request,String userId);
    EmployeeResponseDTO createOrUpdateEmployee(EmployeeRequestDTO request, String jwt);
    EmployeeResponseDTO getEmployeeProfile(String jwt);
    EmployeeResponseDTO updateEmployee(String employeeId, EmployeeRequestDTO request, String jwt);

}
