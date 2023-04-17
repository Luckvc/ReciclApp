package com.reciclapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.reciclapp.DTO.CostumerDTO;


@Document
public class Withdraw implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idWithdraw;
	private Long centsWithdraw;
	private Date dateWithdraw;
	private CostumerDTO costumer;
	
	
	public Withdraw() {
		
	}

	public Withdraw(String idWithdraw, Long centsWithdraw, Date dateWithdraw, CostumerDTO costumer) {
		super();
		this.idWithdraw = idWithdraw;
		this.centsWithdraw = centsWithdraw;
		this.dateWithdraw = dateWithdraw;
		this.costumer = costumer;
	}

	public String getId() {
		return idWithdraw;
	}

	public void setId(String idWithdraw) {
		this.idWithdraw = idWithdraw;
	}

	public Long getCentsWithdraw() {
		return centsWithdraw;
	}

	public void setCentsWithdraw(Long centsWithdraw) {
		this.centsWithdraw = centsWithdraw;
	}

	public Date getDateWithdraw() {
		return dateWithdraw;
	}

	public void setDateWithdraw(Date dateWithdraw) {
		this.dateWithdraw = dateWithdraw;
	}

	
	public CostumerDTO getCostumer() {
		return costumer;
	}
	
	public void setCostumer(CostumerDTO costumer) {
		this.costumer = costumer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idWithdraw);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Withdraw other = (Withdraw) obj;
		return Objects.equals(idWithdraw, other.idWithdraw);
	}
	
		

}
