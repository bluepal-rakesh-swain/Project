package com.nt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryDetailsResponseDTO {
    private String employee;
    private String employeeName;
    private double salary;
    private String payCycle;
    private String bank;
}
