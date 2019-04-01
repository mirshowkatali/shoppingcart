package com.eShoppingCart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tax")
public class Tax {

	
@Id
@GeneratedValue
@Column(name="tax_id")
private int id;

@Column(name="tax_type")
private String taxType;

@Column(name="tax_percentage")
private double taxPercentage;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTaxType() {
	return taxType;
}

public void setTaxType(String taxType) {
	this.taxType = taxType;
}

public double getTaxPercentage() {
	return taxPercentage;
}

public void setTaxPercentage(double taxPercentage) {
	this.taxPercentage = taxPercentage;
}





}
