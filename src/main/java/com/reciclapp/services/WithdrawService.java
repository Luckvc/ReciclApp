package com.reciclapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reciclapp.domain.Withdraw;
import com.reciclapp.domain.User;
import com.reciclapp.repository.WithdrawRepository;
import com.reciclapp.repository.UserRepository;
import com.reciclapp.services.exception.ObjectNotFoundException;

@Service
public class WithdrawService {
	
	@Autowired
	private WithdrawRepository repo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;
		
	public Withdraw findById(String id) {
		Optional<Withdraw> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Long newUserWithdraw(Withdraw withdraw) {
		User user = userService.findById(withdraw.getCostumer().getIdCostumer());
		if (user.getBalanceInCents() > withdraw.getCentsWithdraw()) {			
			//Save Withdraw
			repo.insert(withdraw);
			//add withdraw to referred list 
			user.getWithdraws().add(withdraw);
			//add balance
			user.setBalanceInCents(user.getBalanceInCents() - withdraw.getCentsWithdraw());		
			userRepo.save(user);
			return user.getBalanceInCents();
		} else {
			return -1L;
		}
		
	}
	
}
	
