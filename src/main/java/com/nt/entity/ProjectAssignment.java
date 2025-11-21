package com.nt.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "project_assignments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectAssignment {

    @Id
    private String id;

    private String employeeName;     // Reference to Employee
    private String projectName;    // Project Name (instead of projectId)
    private String role;           // Developer, Tester, Manager
    private LocalDate startDate;
    private LocalDate endDate;
    private int hoursWorked;
}
