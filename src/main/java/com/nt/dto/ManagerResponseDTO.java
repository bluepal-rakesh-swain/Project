package com.nt.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ManagerResponseDTO {
    private String id;
    private String fullName;
    private String email;
    private String gender;
    private String createdBy;	
	private String updatedBy;
    private String department;
    private String contactNo;
    private int age;
    private int experience;
    private String city;
    private String pincode;
}
