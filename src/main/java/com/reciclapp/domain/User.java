package com.reciclapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idUser;
	private String cpf;
	private String emailUser;
	private String nameUser;
	private String telUser;
	private String addressUser;
	private Long balanceInCents;
	
	@DBRef(lazy = true)
	private List<Transaction> transactions = new ArrayList<>();
	@DBRef(lazy = true)
	private List<Withdraw> withdraws = new ArrayList<>();

	public User() {
		
	}

	public User(String id, String cpf, String emailUser, String nameUser, String telUser, String addressUser) {
		super();
		this.idUser = id;
		this.cpf = cpf;
		this.emailUser = emailUser;
		this.nameUser = nameUser;
		this.telUser = telUser;
		this.addressUser = addressUser;
		this.balanceInCents = 0L;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Long getBalanceInCents() {
		return balanceInCents;
	}
	
	public void setBalanceInCents(Long balanceInCents) {
		this.balanceInCents = balanceInCents;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public List<Withdraw> getWithdraws() {
		return withdraws;
	}

	public void setWithdraws(List<Withdraw> withdraws) {
		this.withdraws = withdraws;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(idUser, other.idUser);
	}

}
