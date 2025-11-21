package com.nt.repository;

import com.nt.entity.SalaryDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SalaryRepository extends MongoRepository<SalaryDetails, String> {
    //List<SalaryDetails> findByEmployeeId(String employeeId);
}
