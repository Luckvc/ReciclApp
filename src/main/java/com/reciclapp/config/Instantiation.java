package com.reciclapp.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.reciclapp.DTO.CostumerDTO;
import com.reciclapp.domain.Transaction;
import com.reciclapp.domain.User;
import com.reciclapp.domain.Withdraw;
import com.reciclapp.repository.TransactionRepository;
import com.reciclapp.repository.UserRepository;
import com.reciclapp.repository.WithdrawRepository;


@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private WithdrawRepository withdrawRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		transactionRepository.deleteAll();
		withdrawRepository.deleteAll();
	
		User lucas = new User(null, "454865", "lucas@gmail.com", "Lucas", "11977982366", "Rua Capitao");
		User maria = new User(null, "453945", "maria@gmail.com", "Maria", "19977982366", "Rua Capitao fariah");
		User joao = new User(null, "462452", "joao@gmail.com", "Joao", "17977982366", "Elias Gabriel");
		
		userRepository.saveAll(Arrays.asList(lucas, maria, joao));
		
		Transaction trans1 = new Transaction(null, 450L, 2000L, sdf.parse("10/04/2023"), new CostumerDTO(lucas));
		Transaction trans2 = new Transaction(null, 1000L, 5000L, sdf.parse("11/04/2023"),  new CostumerDTO(lucas));
		Withdraw withdraw1 = new Withdraw(null, 1450L, sdf.parse("12/04/2023"),  new CostumerDTO(lucas));
		
		transactionRepository.saveAll(Arrays.asList(trans1, trans2));
		withdrawRepository.save(withdraw1);
		
		lucas.getTransactions().addAll(Arrays.asList(trans1, trans2));
		lucas.getWithdraws().add(withdraw1);
		userRepository.save(lucas); 
	}

}