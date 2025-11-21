package com.nt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerformanceResponseDTO {
    private String id;
    private String employeeName;
    //private String reviewPeriod;
    private String rating;
    private String remarks;
}
