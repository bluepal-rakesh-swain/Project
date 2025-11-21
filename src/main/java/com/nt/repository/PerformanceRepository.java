package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.entity.Performance;

public interface PerformanceRepository extends MongoRepository<Performance, String> {
    //List<Performance> findByEmployeeId(String employeeId);
}
