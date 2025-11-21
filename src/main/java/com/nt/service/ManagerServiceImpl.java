package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nt.dto.ManagerRequestDTO;
import com.nt.dto.ManagerResponseDTO;
import com.nt.entity.Employee;
import com.nt.entity.Manager;
import com.nt.entity.User;
import com.nt.repository.ManagerRepository;
import com.nt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    private final UserRepository userRepository;

//    private ManagerResponseDTO convertToResponse(Manager manager) {
//        return ManagerResponseDTO.builder()
//                .id(manager.getId())
//                .fullName(manager.getFirstName() + " " + manager.getLastName())
//                .email(manager.getEmail())
//                .gender(manager.getGender())
//                .createdBy(manager.getCreatedBy())
//                .updatedBy(manager.getUpdatedBy())
//                .department(manager.getDepartment())
//                .contactNo(manager.getContactNo())
//                .age(manager.getAge())
//                .experience(manager.getExperience())
//                .city(manager.getCity())
//                .pincode(manager.getPincode())
//                .build();
//    }
//
//    @Override
//    public ManagerResponseDTO createManager(ManagerRequestDTO dto, String userId) {
//        Manager manager = Manager.builder()
//                .firstName(dto.getFirstName())
//                .lastName(dto.getLastName())
//                .email(dto.getEmail())
//                .password(dto.getPassword())
//                .gender(dto.getGender())
//                .createdBy(manager.getCreatedBy())
//                .updatedBy(manager.getUpdatedBy())
//                .department(dto.getDepartment())
//                .contactNo(dto.getContactNo())
//                .age(dto.getAge())
//                .experience(dto.getExperience())
//                .city(dto.getCity())
//                .pincode(dto.getPincode())
//                
//                .build();
//        
//        Optional<Manager> byId = managerRepository.findById(userId);
//    	String userId1=byId.get().getId();
//    	dto.setCreatedBy(userId1);
//        Employee emp = managerRepository.save(mapToEntity(dto));
//        return convertToResponse(managerRepository.save(manager));
//    }
    
 // Convert Manager entity -> DTO
    private ManagerResponseDTO convertToResponse(Manager manager) {
        return ManagerResponseDTO.builder()
                .id(manager.getId())
                .fullName(manager.getFirstName() + " " + manager.getLastName())
                .email(manager.getEmail())
                .gender(manager.getGender())
                .createdBy(manager.getCreatedBy())
                .updatedBy(manager.getUpdatedBy())
                .department(manager.getDepartment())
                .contactNo(manager.getContactNo())
                .age(manager.getAge())
                .experience(manager.getExperience())
                .city(manager.getCity())
                .pincode(manager.getPincode())
                .build();
    }

    // Convert DTO -> Manager entity
    private Manager mapToEntity(ManagerRequestDTO dto) {
        return Manager.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .gender(dto.getGender())
                .department(dto.getDepartment())
                .contactNo(dto.getContactNo())
                .age(dto.getAge())
                .experience(dto.getExperience())
                .city(dto.getCity())
                .pincode(dto.getPincode())
                .createdBy(dto.getCreatedBy())
                .updatedBy(dto.getUpdatedBy())
                .build();
    }

    @Override
    public ManagerResponseDTO createManager(ManagerRequestDTO dto, String userId) {
        // Find the user with proper error handling
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        
        // Map to entity and set createdBy
        Manager manager = mapToEntity(dto);
        manager.setCreatedBy(user.getId());
        
        // Save and return
        Manager savedManager = managerRepository.save(manager);
        
        return convertToResponse(savedManager);
    }
    
    

    @Override
    public ManagerResponseDTO getManagerById(String id) {
        return managerRepository.findById(id)
                .map(this::convertToResponse)
                .orElseThrow(() -> new RuntimeException("Manager not found with id: " + id));
    }

    @Override
    public List<ManagerResponseDTO> getAllManagers() {
        return managerRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ManagerResponseDTO updateManager(String id, ManagerRequestDTO dto) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found with id: " + id));

        manager.setFirstName(dto.getFirstName());
        manager.setLastName(dto.getLastName());
        manager.setEmail(dto.getEmail());
        manager.setPassword(dto.getPassword());
        manager.setGender(dto.getGender());
        manager.setDepartment(dto.getDepartment());
        manager.setContactNo(dto.getContactNo());
        manager.setAge(dto.getAge());
        manager.setExperience(dto.getExperience());
        manager.setCity(dto.getCity());
        manager.setPincode(dto.getPincode());

        return convertToResponse(managerRepository.save(manager));
    }

    @Override
    public void deleteManager(String id) {
        managerRepository.deleteById(id);
    }
}
