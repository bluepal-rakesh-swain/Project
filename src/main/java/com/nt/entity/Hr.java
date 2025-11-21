package com.nt.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Document(collection = "hr")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hr {
    @Id
    private String id;

    private String userId;      // Link to User entity for login credentials
    private String fullName;
    private String email;
    private String contactNo;
    private String department;  // HR department
}
