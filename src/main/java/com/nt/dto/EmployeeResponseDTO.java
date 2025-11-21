package com.nt.dto;

import com.nt.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponseDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String createdBy;	
	private String updatedBy;
    private String email;
    private String contact;
    private String department;
    private int experience;
    private int age;
    private String gender;
    private String city;
    private String pincode;
    private double salary;
    
    
    
    public EmployeeResponseDTO(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.createdBy = employee.getCreatedBy();
        this.updatedBy = employee.getUpdatedBy();
        this.email = employee.getEmail();
        this.contact = employee.getContact();
        this.department = employee.getDepartment();
        this.experience = employee.getExperience();
        this.age = employee.getAge();
        this.gender = employee.getGender();
        this.city = employee.getCity();
        this.pincode = employee.getPincode();
        this.salary = employee.getSalary();
    }

    
}
