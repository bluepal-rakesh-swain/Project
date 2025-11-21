package com.nt.service;

import com.nt.dto.SalaryRequestDTO;
import com.nt.dto.SalaryResponseDTO;

import java.util.List;

public interface SalaryDetailsService {
    SalaryResponseDTO saveSalaryDetails(SalaryRequestDTO dto);
    //List<SalaryResponseDTO> getSalaryDetailsByEmployee(String employeeId);
    List<SalaryResponseDTO> getAllSalaryDetails();
    SalaryResponseDTO updateSalaryDetails(String id, SalaryRequestDTO dto);
    void deleteSalaryDetails(String id);
}
