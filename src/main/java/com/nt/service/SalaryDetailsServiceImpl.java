package com.nt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nt.dto.SalaryRequestDTO;
import com.nt.dto.SalaryResponseDTO;
import com.nt.entity.SalaryDetails;
import com.nt.repository.SalaryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalaryDetailsServiceImpl implements SalaryDetailsService {

    private final SalaryRepository salaryDetailsRepository;

    private SalaryResponseDTO mapToResponse(SalaryDetails salary) {
        return SalaryResponseDTO.builder()
                .id(salary.getId())
                .employeeName(salary.getEmployeeName())
                .salary(salary.getSalary())
                .fromDate(salary.getFromDate())
                .toDate(salary.getToDate())
                .paymentMode(salary.getPaymentMode())
                .payCycle(salary.getPayCycle())
                .bank(salary.getBank())
                .build();
    }

    @Override
    public SalaryResponseDTO saveSalaryDetails(SalaryRequestDTO dto) {
        SalaryDetails salary = SalaryDetails.builder()
                .employeeName(dto.getEmployeeName())
                .salary(dto.getSalary())
                .fromDate(dto.getFromDate())
                .toDate(dto.getToDate())
                .paymentMode(dto.getPaymentMode())
                .payCycle(dto.getPayCycle())
                .bank(dto.getBank())
                .accountNo(dto.getAccountNo())
                .ifscCode(dto.getIfscCode())
                .build();
        return mapToResponse(salaryDetailsRepository.save(salary));
    }

//    @Override
//    public List<SalaryResponseDTO> getSalaryDetailsByEmployee(String employeeId) {
//        return salaryDetailsRepository.findByEmployeeId(employeeId)
//                .stream().map(this::mapToResponse).collect(Collectors.toList());
//    }

    @Override
    public List<SalaryResponseDTO> getAllSalaryDetails() {
        return salaryDetailsRepository.findAll()
                .stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public SalaryResponseDTO updateSalaryDetails(String id, SalaryRequestDTO dto) {
        SalaryDetails existing = salaryDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salary not found"));
        existing.setEmployeeName(dto.getEmployeeName());
        existing.setSalary(dto.getSalary());
        existing.setFromDate(dto.getFromDate());
        existing.setToDate(dto.getToDate());
        existing.setPaymentMode(dto.getPaymentMode());
        existing.setPayCycle(dto.getPayCycle());
        existing.setBank(dto.getBank());
        existing.setAccountNo(dto.getAccountNo());
        existing.setIfscCode(dto.getIfscCode());
        return mapToResponse(salaryDetailsRepository.save(existing));
    }

    @Override
    public void deleteSalaryDetails(String id) {
        salaryDetailsRepository.deleteById(id);
    }
}
