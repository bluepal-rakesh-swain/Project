package com.nt.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "salary_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryDetails {
    @Id
    private String id;
    private String employeeName;   // Reference to Employee
    private double salary;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String paymentMode;
    private String payCycle;
    private String bank;
    private String accountNo;
    private String ifscCode;
}


