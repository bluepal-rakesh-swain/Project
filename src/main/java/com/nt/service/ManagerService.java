package com.nt.service;

import com.nt.dto.ManagerRequestDTO;
import com.nt.dto.ManagerResponseDTO;

import java.util.List;

public interface ManagerService {
    ManagerResponseDTO createManager(ManagerRequestDTO dto,String userId);
    ManagerResponseDTO getManagerById(String id);
    List<ManagerResponseDTO> getAllManagers();
    ManagerResponseDTO updateManager(String id, ManagerRequestDTO dto);
    void deleteManager(String id);
}
