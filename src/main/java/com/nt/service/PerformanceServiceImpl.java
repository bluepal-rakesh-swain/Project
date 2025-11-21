package com.nt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nt.dto.PerformanceRequestDTO;
import com.nt.dto.PerformanceResponseDTO;
import com.nt.entity.Performance;
import com.nt.repository.PerformanceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PerformanceServiceImpl implements PerformanceService {

    private final PerformanceRepository repository;

    @Override
    public PerformanceResponseDTO addPerformance(PerformanceRequestDTO dto) {
        Performance performance = Performance.builder()
                .employeeName(dto.getEmployeeName())
                
                .rating(dto.getRating())
                .remarks(dto.getRemarks())
                .build();
        Performance saved = repository.save(performance);
        return toResponse(saved);
    }

//    @Override
//    public List<PerformanceResponseDTO> getByEmployee(String employeeId) {
//        return repository.findByEmployeeId(employeeId)
//                .stream().map(this::toResponse).collect(Collectors.toList());
//    }

    @Override
    public PerformanceResponseDTO updatePerformance(String id, PerformanceRequestDTO dto) {
        Performance performance = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Performance not found"));
        performance.setEmployeeName(dto.getEmployeeName());
        performance.setRating(dto.getRating());
        performance.setRemarks(dto.getRemarks());
        Performance updated = repository.save(performance);
        return toResponse(updated);
    }

    @Override
    public void deletePerformance(String id) {
        repository.deleteById(id);
    }

    private PerformanceResponseDTO toResponse(Performance performance) {
        PerformanceResponseDTO dto = new PerformanceResponseDTO();
        dto.setId(performance.getId());
        dto.setEmployeeName(performance.getEmployeeName());
       // dto.setReviewPeriod(performance.getReviewPeriod());
        dto.setRating(performance.getRating());
        dto.setRemarks(performance.getRemarks());
        return dto;
    }

    @Override
    public List<PerformanceResponseDTO> getAllPerformance() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    // 🔹 Utility method for mapping Entity -> DTO
    private PerformanceResponseDTO mapToResponseDTO(Performance performance) {
        return PerformanceResponseDTO.builder()
                .id(performance.getId())
                .employeeName(performance.getEmployeeName())
                //.reviewPeriod(performance.getReviewPeriod())
                .rating(performance.getRating())
                .remarks(performance.getRemarks())
                .build();
    }
}
