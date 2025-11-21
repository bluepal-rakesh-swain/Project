package com.nt.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HrResponseDTO {

    private String id;
    private String userId;
    private String fullName;
    private String email;
    private String contactNo;
    private String department;
}
