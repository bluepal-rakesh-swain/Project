package com.nt.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SalaryRequestDTO {
    private String employeeName;
    private double salary;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String paymentMode;
    private String payCycle;
    private String bank;
    private String accountNo;
    private String ifscCode;
}
