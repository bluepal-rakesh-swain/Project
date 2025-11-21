package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.nt.entity.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
	@Query("{ 'department' : ?0 }")
    Department findByDepartment(String department);
}
