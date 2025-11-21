package com.nt.controller;

import com.nt.dto.ManagerRequestDTO;
import com.nt.dto.ManagerResponseDTO;
import com.nt.entity.User;
import com.nt.service.ManagerService;
import com.nt.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;
    @Autowired
	private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<ManagerResponseDTO> createManager(
            @RequestBody ManagerRequestDTO dto,
            @RequestHeader("Authorization") String jwt) {

        User user = userService.getUserProfile(jwt); // extract user from JWT
        ManagerResponseDTO response = managerService.createManager(dto, user.getId());

        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ManagerResponseDTO> getManagerById(@PathVariable String id) {
        return ResponseEntity.ok(managerService.getManagerById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ManagerResponseDTO>> getAllManagers(@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(managerService.getAllManagers());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ManagerResponseDTO> updateManager(
            @PathVariable String id,
            @RequestBody ManagerRequestDTO dto,@RequestHeader("Authorization") String jwt) {
        return ResponseEntity.ok(managerService.updateManager(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteManager(@PathVariable String id,@RequestHeader("Authorization") String jwt) {
        managerService.deleteManager(id);
        return ResponseEntity.ok("Manager deleted successfully with id: " + id);
    }
}
