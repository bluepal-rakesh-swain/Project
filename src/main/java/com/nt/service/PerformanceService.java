package com.nt.service;


import java.util.List;

import com.nt.dto.PerformanceRequestDTO;
import com.nt.dto.PerformanceResponseDTO;

public interface PerformanceService {
    PerformanceResponseDTO addPerformance(PerformanceRequestDTO dto);
    //List<PerformanceResponseDTO> getByEmployee(String employeeId);
    PerformanceResponseDTO updatePerformance(String id, PerformanceRequestDTO dto);
    void deletePerformance(String id);
 // ✅ New method to fetch all performance records 
    List<PerformanceResponseDTO> getAllPerformance();
}
