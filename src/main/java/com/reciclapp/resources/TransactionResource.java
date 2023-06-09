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

import com.reciclapp.domain.Transaction;
import com.reciclapp.services.TransactionService;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionResource {

	@Autowired
	private TransactionService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Transaction> findById(@PathVariable String id) {
		Transaction obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insertTransaction(@RequestBody Transaction transaction) {
		service.newUserTransaction(transaction);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transaction.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
}

