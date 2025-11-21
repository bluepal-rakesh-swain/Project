package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.nt.entity.Hr;

@Repository
public interface HrRepository extends MongoRepository<Hr, String> {
    Hr findByEmail(String email);
}
