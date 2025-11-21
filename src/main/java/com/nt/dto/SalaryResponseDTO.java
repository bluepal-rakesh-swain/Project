package com.nt.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalaryResponseDTO {
    private String id;
    private String employeeName;
    private double salary;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String paymentMode;
    private String payCycle;
    private String bank;
}
