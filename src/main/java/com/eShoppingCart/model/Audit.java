package com.eShoppingCart.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="audit")
public class Audit {

@Id
@GeneratedValue
@Column(name="audit_id")	
private int id;

@Column(name="order_id")
private int orderId;

@Column(name="created_on")
private Date createdOn;

@Column(name="message")
private String message;

@Column(name="code")
private int code;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getOrderId() {
	return orderId;
}

public void setOrderId(int orderId) {
	this.orderId = orderId;
}

public Date getCreatedOn() {
	return createdOn;
}

public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public int getCode() {
	return code;
}

public void setCode(int code) {
	this.code = code;
}



}
