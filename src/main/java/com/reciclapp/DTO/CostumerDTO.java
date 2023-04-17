package com.reciclapp.DTO;

import java.io.Serializable;

import com.reciclapp.domain.User;

public class CostumerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String idCostumer;
	private String nameCostumer;
	
	public CostumerDTO() {
		
	}

	public CostumerDTO(User obj) {
		super();
		this.idCostumer = obj.getIdUser();
		this.nameCostumer = obj.getNameUser();
	}

	public String getIdCostumer() {
		return idCostumer;
	}

	public void setIdCostumer(String idCostumer) {
		this.idCostumer = idCostumer;
	}

	public String getNameCostumer() {
		return nameCostumer;
	}

	public void setNameCostumer(String nameCostumer) {
		this.nameCostumer = nameCostumer;
	}
	
	

}
