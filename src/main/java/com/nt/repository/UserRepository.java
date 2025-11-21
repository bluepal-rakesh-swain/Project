package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

		public User findByEmail(String email);
		//Optional<User> findByFullName(String fullName);
}
