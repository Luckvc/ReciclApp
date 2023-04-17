package com.reciclapp.DTO;

import java.io.Serializable;

import com.reciclapp.domain.User;

public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String idUser;
	private String cpf;
	private String emailUser;
	private String nameUser;
	private String telUser;
	private String addressUser;
	private Long balanceInCents;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User obj) {
		idUser = obj.getIdUser();
		cpf = obj.getCpf();
		emailUser = obj.getEmailUser();
		nameUser = obj.getNameUser();
		telUser = obj.getTelUser();
		addressUser = obj.getAddressUser();
		balanceInCents = obj.getBalanceInCents();
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelUser() {
		return telUser;
	}

	public void setTelUser(String telUser) {
		this.telUser = telUser;
	}

	public String getAddressUser() {
		return addressUser;
	}

	public void setAddressUser(String addressUser) {
		this.addressUser = addressUser;
	}

	public Long getBalanceInCents() {
		return balanceInCents;
	}

	public void setBalanceInCents(Long balanceInCents) {
		this.balanceInCents = balanceInCents;
	}


}
