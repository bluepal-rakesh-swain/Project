package com.nt.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HrRequestDTO {

    @NotBlank
    private String userId;

    @NotBlank
    private String fullName;

    @Email
    @NotBlank
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Contact must be 10 digits")
    private String contactNo;

    @NotBlank
    private String department;
}
