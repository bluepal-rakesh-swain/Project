//package com.nt.service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import com.nt.dto.EmployeeRequestDTO;
//import com.nt.dto.EmployeeResponseDTO;
//import com.nt.entity.Employee;
//import com.nt.entity.User;
//import com.nt.repository.EmployeeRepository;
//import com.nt.repository.UserRepository;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService {
//
//    @Autowired
//    private EmployeeRepository repository;
//    
//    @Autowired
//    private UserRepository userRepository;
//
//    private EmployeeResponseDTO mapToDTO(Employee emp) {
//        return EmployeeResponseDTO.builder()
//        		.id(emp.getId()) 
//                .firstName(emp.getFirstName())
//                .lastName(emp.getLastName())
//                .createdBy(emp.getCreatedBy())
//                .updatedBy(emp.getUpdatedBy())// Add this line
//                .email(emp.getEmail())
//                .contact(emp.getContact())
//                .department(emp.getDepartment())
//                .experience(emp.getExperience())
//                .age(emp.getAge())
//                .gender(emp.getGender())
//                .city(emp.getCity())
//                .pincode(emp.getPincode())
//                .salary(emp.getSalary())
//                .build();
//    }
//
//    private Employee mapToEntity(EmployeeRequestDTO dto) {
//        Employee emp = Employee.builder()
//                .firstName(dto.getFirstName())
//                .lastName(dto.getLastName())
//                .email(dto.getEmail())
//                .contact(dto.getContact())
//                .department(dto.getDepartment())
//                .experience(dto.getExperience())
//                .age(dto.getAge())
//                .gender(dto.getGender())
//                .city(dto.getCity())
//                .pincode(dto.getPincode())
//                .salary(dto.getSalary())
//                .build();
//
// 
//        return emp;
//    }
//
//
//    @Override
//    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO request, String userId) {
//        Optional<User> byId = userRepository.findById(userId);
//        String userId1 = byId.get().getId();
//        
//        Employee emp = mapToEntity(request);
//        emp.setCreatedBy(userId1);  // Set createdBy after mapping
//        
//        Employee savedEmp = repository.save(emp);
//        
//        return mapToDTO(savedEmp);
//    }
//
//
//    @Override
//    public EmployeeResponseDTO updateEmployee(String id, EmployeeRequestDTO request, String userId) {
//        Employee existing = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
//        
//        Employee updated = mapToEntity(request);
//        updated.setId(existing.getId());
//        updated.setCreatedBy(existing.getCreatedBy()); // Preserve the original createdBy
//        updated.setUpdatedBy(userId); // Set the updatedBy field with the current user ID
//        
//        // Preserve other fields that might not be in the DTO
//        if (updated.getSalaryDetails() == null) {
//            updated.setSalaryDetails(existing.getSalaryDetails());
//        }
//        if (updated.getAssignments() == null) {
//            updated.setAssignments(existing.getAssignments());
//        }
//        
//        return mapToDTO(repository.save(updated));
//    }
//    
//    
//    @Override
//    public void deleteEmployee(String id) {
//        repository.deleteById(id);
//    }
//
//    @Override
//    public EmployeeResponseDTO getEmployeeById(String id) {
//        Employee emp = repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
//        return mapToDTO(emp);
//    }
//
//    @Override
//    public Page<EmployeeResponseDTO> getAllEmployees(int page, int size, String sortBy, String sortDir, String search) {
//        Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
//        Pageable pageable = PageRequest.of(page, size, sort);
//
//        if (search != null && !search.isEmpty()) {
//            List<EmployeeResponseDTO> filtered = repository.findByFirstNameContainingIgnoreCase(search)
//                    .stream().map(this::mapToDTO).collect(Collectors.toList());
//            return new PageImpl<>(filtered, pageable, filtered.size());
//        }
//
//        Page<Employee> empPage = repository.findAll(pageable);
//        return empPage.map(this::mapToDTO);
//    }
//}



package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeRequestDTO;
import com.nt.dto.EmployeeResponseDTO;
import com.nt.entity.Employee;
import com.nt.entity.User;
import com.nt.repository.EmployeeRepository;
import com.nt.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final UserRepository userRepository;
    @Autowired
    private UserService userService; // to get user from JWT

//    private EmployeeResponseDTO mapToDTO(Employee emp) {
//        return EmployeeResponseDTO.builder()
//                .id(emp.getId())
//                .firstName(emp.getFirstName())
//                .lastName(emp.getLastName())
//                .createdBy(emp.getCreatedBy())
//                .updatedBy(emp.getUpdatedBy())
//                .email(emp.getEmail())
//                .contact(emp.getContact())
//                .department(emp.getDepartment())
//                .experience(emp.getExperience())
//                .age(emp.getAge())
//                .gender(emp.getGender())
//                .city(emp.getCity())
//                .pincode(emp.getPincode())
//                .salary(emp.getSalary())
//                .build();
//    }
//
//    private Employee mapToEntity(EmployeeRequestDTO dto) {
//        return Employee.builder()
//                .firstName(dto.getFirstName())
//                .lastName(dto.getLastName())
//                .email(dto.getEmail())
//                .contact(dto.getContact())
//                .department(dto.getDepartment())
//                .experience(dto.getExperience())
//                .age(dto.getAge())
//                .gender(dto.getGender())
//                .city(dto.getCity())
//                .pincode(dto.getPincode())
//                .salary(dto.getSalary())
//                .build();
//    }
//
//    @Override
//    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO request, String userId) {
//        log.info("Creating new employee by userId: {}", userId);
//
//        Optional<User> byId = userRepository.findById(userId);
//        String userId1 = byId.orElseThrow(() -> {
//            log.error("User not found with ID: {}", userId);
//            return new RuntimeException("User not found");
//        }).getId();
//
//        Employee emp = mapToEntity(request);
//        emp.setCreatedBy(userId1);
//
//        Employee savedEmp = repository.save(emp);
//        log.debug("Employee created successfully with ID: {}", savedEmp.getId());
//
//        return mapToDTO(savedEmp);
//    }
    
    // Convert Entity -> DTO
    private EmployeeResponseDTO mapToDTO(Employee emp) {
        return EmployeeResponseDTO.builder()
                .id(emp.getId())
                .firstName(emp.getFirstName())
                .lastName(emp.getLastName())
                .createdBy(emp.getCreatedBy())
                .updatedBy(emp.getUpdatedBy())
                .email(emp.getEmail())
                .contact(emp.getContact())
                .department(emp.getDepartment())
                .experience(emp.getExperience())
                .age(emp.getAge())
                .gender(emp.getGender())
                .city(emp.getCity())
                .pincode(emp.getPincode())
                .salary(emp.getSalary())
                .build();
    }

    // Convert DTO -> Entity
    private Employee mapToEntity(EmployeeRequestDTO dto, Employee emp) {
        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());
        emp.setEmail(dto.getEmail());
        emp.setContact(dto.getContact());
        emp.setDepartment(dto.getDepartment());
        emp.setExperience(dto.getExperience());
        emp.setAge(dto.getAge());
        emp.setGender(dto.getGender());
        emp.setCity(dto.getCity());
        emp.setPincode(dto.getPincode());
        emp.setSalary(dto.getSalary());
        return emp;
    }

//    @Override
//    public EmployeeResponseDTO createOrUpdateEmployee(EmployeeRequestDTO request, String jwt) {
//        // Get current user from JWT
//        User user = userService.getUserProfile(jwt);
//
//        // Check if employee already exists for this user
//        Optional<Employee> optionalEmp = repository.findByUserId(user.getId());
//        Employee emp;
//        if (optionalEmp.isPresent()) {
//            // Update existing employee
//            emp = optionalEmp.get();
//            mapToEntity(request, emp);
//            emp.setUpdatedBy(user.getId());
//        } else {
//            // Create new employee
//            emp = mapToEntity(request, new Employee());
//            emp.setCreatedBy(user.getId());
//        }
//
//        Employee savedEmp = repository.save(emp);
//        return mapToDTO(savedEmp);
//    }
    @Override
    public EmployeeResponseDTO createOrUpdateEmployee(EmployeeRequestDTO request, String jwt) {
        // Get current user from JWT
        User user = userService.getUserProfile(jwt);

        // Check if employee already exists for this user
        Optional<Employee> optionalEmp = repository.findByUserId(user.getId());
        Employee emp;
        if (optionalEmp.isPresent()) {
            // Update existing employee
            emp = optionalEmp.get();
            mapToEntity(request, emp);
            emp.setUpdatedBy(user.getId());
        } else {
            // Create new employee
            emp = mapToEntity(request, new Employee());

            // ⚡ Important: Set userId and createdBy
            emp.setUserId(user.getId());   // ← must set this
            emp.setCreatedBy(user.getId());
        }

        Employee savedEmp = repository.save(emp);
        return mapToDTO(savedEmp);
    }

    
    @Override
    public EmployeeResponseDTO getEmployeeProfile(String jwt) {
        User user = userService.getUserProfile(jwt);

        Employee emp = repository.findByUserId(user.getId())
                .orElseThrow(() -> new RuntimeException("Employee profile not found"));

        return mapToDTO(emp);
    }
    
//    @Override
//    public EmployeeResponseDTO getEmployeeProfile(Long employeeId) {
//        Employee emp = repository.findById(employeeId)
//                .orElseThrow(() -> new RuntimeException("Employee profile not found"));
//
//        return mapToDTO(emp);
//    }

    
    
    @Override
    public EmployeeResponseDTO updateEmployee(String employeeId, EmployeeRequestDTO request, String jwt) {
        User user = userService.getUserProfile(jwt);

        Employee emp = repository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("❌ Employee not found with id: " + employeeId));

        // Map the request data to the existing employee
        mapToEntity(request, emp);
        emp.setUpdatedBy(user.getId());

        Employee updatedEmp = repository.save(emp);
        return mapToDTO(updatedEmp);
    }

    
//    @Override
//    public EmployeeResponseDTO getEmployeeByUserId(String userId) {
//        Employee emp = repository.findByUserId(userId)
//                .orElseThrow(() -> new RuntimeException("Employee not found for userId: " + userId));
//
//        return mapToDTO(emp);
//    }

//    @Override
//    public EmployeeResponseDTO updateEmployee(String id, EmployeeRequestDTO request, String userId) {
//        log.info("Updating employee with ID: {}", id);
//
//        Employee existing = repository.findById(id)
//                .orElseThrow(() -> {
//                    log.error("Employee not found with id: {}", id);
//                    return new RuntimeException("Employee not found with id: " + id);
//                });
//
//        Employee updated = mapToEntity(request);
//        updated.setId(existing.getId());
//        updated.setCreatedBy(existing.getCreatedBy());
//        updated.setUpdatedBy(userId);
//
//        if (updated.getSalaryDetails() == null) {
//            updated.setSalaryDetails(existing.getSalaryDetails());
//        }
//        if (updated.getAssignments() == null) {
//            updated.setAssignments(existing.getAssignments());
//        }
//
//        Employee saved = repository.save(updated);
//        log.debug("Employee updated successfully with ID: {}", saved.getId());
//
//        return mapToDTO(saved);
//    }

    @Override
    public void deleteEmployee(String id) {
        log.warn("Deleting employee with ID: {}", id);
        repository.deleteById(id);
        log.info("Employee deleted successfully with ID: {}", id);
    }

//    @Override
//    public EmployeeResponseDTO getEmployeeById(String id) {
//        log.info("Fetching employee with ID: {}", id);
//
//        Employee emp = repository.findById(id)
//                .orElseThrow(() -> {
//                    log.error("Employee not found with id: {}", id);
//                    return new RuntimeException("Employee not found with id: " + id);
//                });
//
//        log.debug("Employee fetched successfully: {} {}", emp.getFirstName(), emp.getLastName());
//        return mapToDTO(emp);
//    }

    @Override
    public Page<EmployeeResponseDTO> getAllEmployees(int page, int size, String sortBy, String sortDir, String search) {
        log.info("Fetching all employees: page={}, size={}, sortBy={}, sortDir={}, search={}",
                page, size, sortBy, sortDir, search);

        Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        if (search != null && !search.isEmpty()) {
            log.debug("Searching employees with keyword: {}", search);

            List<EmployeeResponseDTO> filtered = repository.findByFirstNameContainingIgnoreCase(search)
                    .stream().map(this::mapToDTO).collect(Collectors.toList());

            log.debug("Search result count: {}", filtered.size());
            return new PageImpl<>(filtered, pageable, filtered.size());
        }

        Page<Employee> empPage = repository.findAll(pageable);
        log.debug("Total employees found: {}", empPage.getTotalElements());
        return empPage.map(this::mapToDTO);
    }

  
}
