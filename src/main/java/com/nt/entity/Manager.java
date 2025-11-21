package com.nt.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "managers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Manager {
    @Id
    private String id;
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
    
 // Link to User for authentication
    //private String userId;
    private String createdBy;
	
   	private String updatedBy;
    

}
