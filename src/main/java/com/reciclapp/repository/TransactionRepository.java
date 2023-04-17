package com.reciclapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.reciclapp.domain.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
	
	

}
