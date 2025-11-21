package com.nt.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AttendanceRequestDTO {
    private String employeeName;
    private LocalDate date;
    private String status;
}
