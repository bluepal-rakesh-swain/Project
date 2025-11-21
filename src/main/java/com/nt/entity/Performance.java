package com.nt.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "performance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Performance {
    @Id
    private String id;
    private String employeeName;
   // private String reviewPeriod; // Q1-2025, Q2-2025 etc.
    private String rating;       // Excellent, Good, Average, Poor
    private String remarks;
}
