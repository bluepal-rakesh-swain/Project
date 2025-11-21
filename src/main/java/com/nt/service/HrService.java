package com.nt.service;

import java.util.List;
import com.nt.dto.HrRequestDTO;
import com.nt.dto.HrResponseDTO;

public interface HrService {

    HrResponseDTO createHr(HrRequestDTO request);

    HrResponseDTO updateHr(String id, HrRequestDTO request);

    void deleteHr(String id);

    HrResponseDTO getHrById(String id);

    List<HrResponseDTO> getAllHrs();
}
