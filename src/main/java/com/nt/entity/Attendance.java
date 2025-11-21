package com.nt.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "attendance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {
    @Id
    private String id;
    private String employeeName;
    private LocalDate date;
    private String status;  // Present, Absent, Leave, Half-Day
}
