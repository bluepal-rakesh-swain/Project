package com.nt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.HrRequestDTO;
import com.nt.dto.HrResponseDTO;
import com.nt.entity.Hr;
import com.nt.repository.HrRepository;
import com.nt.service.HrService;

@Service
public class HrServiceImpl implements HrService {

    @Autowired
    private HrRepository repository;

    private HrResponseDTO mapToDTO(Hr hr) {
        return HrResponseDTO.builder()
                .id(hr.getId())
                .userId(hr.getUserId())
                .fullName(hr.getFullName())
                .email(hr.getEmail())
                .contactNo(hr.getContactNo())
                .department(hr.getDepartment())
                .build();
    }

    private Hr mapToEntity(HrRequestDTO dto) {
        return Hr.builder()
                .userId(dto.getUserId())
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .contactNo(dto.getContactNo())
                .department(dto.getDepartment())
                .build();
    }

    @Override
    public HrResponseDTO createHr(HrRequestDTO request) {
        Hr hr = repository.save(mapToEntity(request));
        return mapToDTO(hr);
    }

    @Override
    public HrResponseDTO updateHr(String id, HrRequestDTO request) {
        Hr existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("HR not found with id: " + id));
        Hr updated = mapToEntity(request);
        updated.setId(existing.getId());
        return mapToDTO(repository.save(updated));
    }

    @Override
    public void deleteHr(String id) {
        repository.deleteById(id);
    }

    @Override
    public HrResponseDTO getHrById(String id) {
        Hr hr = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("HR not found with id: " + id));
        return mapToDTO(hr);
    }

    @Override
    public List<HrResponseDTO> getAllHrs() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
