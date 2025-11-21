package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.EmployeeRequestDTO;
import com.nt.dto.EmployeeResponseDTO;
import com.nt.entity.User;
import com.nt.repository.UserRepository;
import com.nt.service.EmployeeService;
import com.nt.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    private final UserRepository userRepository;
    
    @Autowired
	private UserService userService;
    


//    @PostMapping("/add")
//    public ResponseEntity<EmployeeResponseDTO> createEmployee(
//            @Valid @RequestBody EmployeeRequestDTO employee,@RequestHeader("Authorization") String jwt) {
//    	
//    	User user=userService.getUserProfile(jwt);
//    	
//        return ResponseEntity.ok(service.createEmployee(employee , user.getId()));
//    }
    
//    @GetMapping("/profile")
//    public ResponseEntity<EmployeeResponseDTO> getEmployeeProfile(
//            @RequestHeader("Authorization") String jwt) {
//
//        // Extract user details from JWT
//        User user = userService.getUserProfile(jwt);
//
//        // Fetch employee details using userId (not employee id)
//        EmployeeResponseDTO employeeProfile = service.getEmployeeByUserId(user.getId());
//
//        return ResponseEntity.ok(employeeProfile);
//    }
    
 // ---------------- Create or Update Employee ----------------
    @PostMapping("/createOrUpdate")
    public ResponseEntity<EmployeeResponseDTO> createOrUpdateEmployee(
            @RequestHeader("Authorization") String jwt,
            @Valid @RequestBody EmployeeRequestDTO request
    ) {
        EmployeeResponseDTO response = service.createOrUpdateEmployee(request, jwt);
        return ResponseEntity.ok(response);
    }

    // ---------------- Update Employee by ID ----------------
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(
            @RequestHeader("Authorization") String jwt,
            @PathVariable("id") String employeeId,
            @Valid @RequestBody EmployeeRequestDTO request
    ) {
        EmployeeResponseDTO response = service.updateEmployee(employeeId, request, jwt);
        return ResponseEntity.ok(response);
    }

    // ---------------- Get Employee Profile ----------------
    @GetMapping("/profile")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeProfile(
            @RequestHeader("Authorization") String jwt
    ) {
        EmployeeResponseDTO response = service.getEmployeeProfile(jwt);
        return ResponseEntity.ok(response);
    }
    


    
  
//    @PutMapping("/update/{id}")
//    public ResponseEntity<EmployeeResponseDTO> updateEmployee(
//            @PathVariable String id,
//            @Valid @RequestBody EmployeeRequestDTO employee,@RequestHeader("Authorization") String jwt) {
//    	User user=userService.getUserProfile(jwt);
//        return ResponseEntity.ok(service.updateEmployee(id, employee,user.getId()));
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id,@RequestHeader("Authorization") String jwt) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable String id) {
//        return ResponseEntity.ok(service.getEmployeeById(id));
//    }

    @GetMapping("/all")
    public ResponseEntity<Page<EmployeeResponseDTO>> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size,
            @RequestParam(defaultValue = "firstName") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,
            @RequestParam(required = false) String search,@RequestHeader("Authorization") String jwt
    ) {
        return ResponseEntity.ok(service.getAllEmployees(page, size, sortBy, sortDir, search));
    }
}
