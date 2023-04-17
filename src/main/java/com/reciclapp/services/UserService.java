package com.reciclapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reciclapp.DTO.UserDTO;
import com.reciclapp.domain.User;
import com.reciclapp.repository.UserRepository;
import com.reciclapp.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	

	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);	
	} 
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = repo.findById(obj.getIdUser()).get();
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setCpf(obj.getCpf());
		newObj.setEmailUser(obj.getEmailUser());
		newObj.setAddressUser(obj.getAddressUser());
		newObj.setNameUser(obj.getNameUser());
		newObj.setTelUser(obj.getTelUser());
				
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getIdUser(), objDto.getCpf(), objDto.getEmailUser(), objDto.getNameUser(), objDto.getTelUser(), objDto.getAddressUser());
	}

	
}
	
