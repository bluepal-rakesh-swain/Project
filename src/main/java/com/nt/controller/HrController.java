package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nt.dto.HrRequestDTO;
import com.nt.dto.HrResponseDTO;
import com.nt.service.HrService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/hr")
public class HrController {

    @Autowired
    private HrService hrService;

    @PostMapping("/add")
    public ResponseEntity<HrResponseDTO> createHr(@Valid @RequestBody HrRequestDTO request,@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(hrService.createHr(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HrResponseDTO> updateHr(@PathVariable String id, @Valid @RequestBody HrRequestDTO request,@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(hrService.updateHr(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHr(@PathVariable String id,@RequestHeader("Authorization") String jwt) {
        hrService.deleteHr(id);
        return ResponseEntity.ok("HR deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<HrResponseDTO> getHrById(@PathVariable String id) {
        return ResponseEntity.ok(hrService.getHrById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<HrResponseDTO>> getAllHrs(@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(hrService.getAllHrs());
    }
}
