package com.eShoppingCart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="attribute_value")
public class AttributeValue {

@Id
@Column(name="attribute_value_id")
@GeneratedValue
private int id;


@Column(name="attribute_id")
private int attributeId;

@Column(name="value")
private String value;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getAttributeId() {
	return attributeId;
}

public void setAttributeId(int attributeId) {
	this.attributeId = attributeId;
}

public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
}






}
