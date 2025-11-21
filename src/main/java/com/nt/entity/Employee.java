package com.nt.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String contact;
    private String department;
    private int experience;
    private int age;
    private String gender;
    private String city;
    private String pincode;
    private double salary;
    
 // Link to User for authentication
    private String userId;
    
    
    private String createdBy;
	
	private String updatedBy;

 // One Employee has one SalaryDetails
    private SalaryDetails salaryDetails;
    // One Employee → Many Assignments
    private List<ProjectAssignment> assignments;
 
}
