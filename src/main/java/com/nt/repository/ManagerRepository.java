package com.nt.repository;

import com.nt.entity.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ManagerRepository extends MongoRepository<Manager, String> {
}
