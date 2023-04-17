package com.reciclapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.reciclapp.DTO.CostumerDTO;


@Document
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idTransaction;
	private Long centsTransaction;
	private Long gramsTransaction;
	private Date dateTransaction;
	private CostumerDTO costumer;
	
	
	public Transaction() {
		
	}

	public Transaction(String idTransaction, Long centsTransaction, Long gramsTransaction, Date dateTransaction, CostumerDTO costumer) {
		super();
		this.idTransaction = idTransaction;
		this.centsTransaction = centsTransaction;
		this.gramsTransaction = gramsTransaction;
		this.dateTransaction = dateTransaction;
		this.costumer = costumer;
	}

	public String getId() {
		return idTransaction;
	}

	public void setId(String idTransaction) {
		this.idTransaction = idTransaction;
	}

	public Long getCentsTransaction() {
		return centsTransaction;
	}

	public void setCentsTransaction(Long centsTransaction) {
		this.centsTransaction = centsTransaction;
	}

	public Long getGramsTransaction() {
		return gramsTransaction;
	}

	public void setGramsTransaction(Long gramsTransaction) {
		this.gramsTransaction = gramsTransaction;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	
	public CostumerDTO getCostumer() {
		return costumer;
	}
	
	public void setCostumer(CostumerDTO costumer) {
		this.costumer = costumer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTransaction);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(idTransaction, other.idTransaction);
	}
	
		

}
