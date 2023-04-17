package com.reciclapp.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.reciclapp.DTO.UserDTO;
import com.reciclapp.domain.Transaction;
import com.reciclapp.domain.User;
import com.reciclapp.domain.Withdraw;
import com.reciclapp.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
 	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUser()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
 	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
		User obj = service.fromDTO(objDto);
		obj.setIdUser(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}/transactions", method=RequestMethod.GET)
	public ResponseEntity<List<Transaction>> findTransactions(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getTransactions());
	}
	
	@RequestMapping(value="/{id}/withdraws", method=RequestMethod.GET)
	public ResponseEntity<List<Withdraw>> findWithdraws(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getWithdraws());
	}
	
	@RequestMapping(value="/{id}/balance", method=RequestMethod.GET)
	public ResponseEntity<String> findBalance(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body("Seu saldo: " + obj.getBalanceInCents());
	}
	
}