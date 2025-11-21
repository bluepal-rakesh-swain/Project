package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    List<Employee> findByFirstNameContainingIgnoreCase(String firstName);
    List<Employee> findByDepartmentContainingIgnoreCase(String department);
    Optional<Employee> findByUserId(String userId);
    //Optional<Employee> findByCreatedBy(String createdBy);
	Optional<Employee> findById(Long employeeId);
}
