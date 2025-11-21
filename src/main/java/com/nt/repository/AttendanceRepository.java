package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.entity.Attendance;

public interface AttendanceRepository extends MongoRepository<Attendance, String> {
    //List<Attendance> findByEmployeeId(String employeeId);
}
