package com.reciclapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reciclapp.domain.Transaction;
import com.reciclapp.domain.User;
import com.reciclapp.repository.TransactionRepository;
import com.reciclapp.repository.UserRepository;
import com.reciclapp.services.exception.ObjectNotFoundException;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;
		
	public Transaction findById(String id) {
		Optional<Transaction> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public void newUserTransaction(Transaction transaction) {
		User user = userService.findById(transaction.getCostumer().getIdCostumer());
		//Save Transaction
		repo.insert(transaction);
		//add transaction to referred list 
		user.getTransactions().add(transaction);
		//add balance
		user.setBalanceInCents(user.getBalanceInCents() + transaction.getCentsTransaction());		
		userRepo.save(user);
		
	}
	
}
	
