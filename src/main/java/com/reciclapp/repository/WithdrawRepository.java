package com.reciclapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.reciclapp.domain.Withdraw;

@Repository
public interface WithdrawRepository extends MongoRepository<Withdraw, String> {
	
	

}
