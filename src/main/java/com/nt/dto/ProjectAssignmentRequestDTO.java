package com.nt.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectAssignmentRequestDTO {
    private String employeeName;
    private String projectName;
    private String role;
    private LocalDate startDate;
    private LocalDate endDate;
    private int hoursWorked;
}
