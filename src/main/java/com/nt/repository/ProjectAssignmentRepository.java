package com.nt.repository;

import com.nt.entity.ProjectAssignment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectAssignmentRepository extends MongoRepository<ProjectAssignment, String> {
    //List<ProjectAssignment> findByEmployeeId(String employeeId);
}
