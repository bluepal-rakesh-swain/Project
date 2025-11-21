package com.nt.dto;

import lombok.Data;

@Data
public class ManagerRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private String department;
    private String contactNo;
    private int age;
    private int experience;
    private String city;
    private String pincode;
//    private String userId;
	private String createdBy;
	
	private String updatedBy;
}
