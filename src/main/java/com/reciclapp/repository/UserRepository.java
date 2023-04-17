package com.reciclapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.reciclapp.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	

}
