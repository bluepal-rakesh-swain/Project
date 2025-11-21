package com.nt.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRequestDTO {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Contact must be 10 digits")
    private String contact;

    @NotBlank(message = "Department is required")
    private String department;

    @Min(0)
    private int experience;

    @Min(18)
    private int age;

    @NotBlank
    private String gender;

    @NotBlank
    private String city;

    @Pattern(regexp = "\\d{6}")
    private String pincode;

    @Min(0)
    private double salary;
    
	private String createdBy;
	
	private String updatedBy;

  
}
