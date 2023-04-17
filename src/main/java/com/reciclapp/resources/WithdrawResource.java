package com.reciclapp.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.reciclapp.domain.Withdraw;
import com.reciclapp.services.WithdrawService;

@RestController
@RequestMapping(value = "/withdraws")
public class WithdrawResource {

	@Autowired
	private WithdrawService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Withdraw> findById(@PathVariable String id) {
		Withdraw obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> insertWithdraw(@RequestBody Withdraw withdraw) {
		
		Long balance = service.newUserWithdraw(withdraw);
		
		if (balance.compareTo(0L) >= 0) {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(withdraw.getId()).toUri();
			return ResponseEntity.created(uri).body("Saque efetuado. Saldo remanecente: " + balance);			
		} else {
			return ResponseEntity.unprocessableEntity().body("Saldo Insuficiente.");
		}
		
	}
	
}

