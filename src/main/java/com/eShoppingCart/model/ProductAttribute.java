package com.eShoppingCart.model;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_attribute")

public class ProductAttribute {

@Id
@Column(name="product_id")
private int id;	
	
@Column(name="attribute_value_id")
private int attributeValue;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getAttributeValue() {
	return attributeValue;
}

public void setAttributeValue(int attributeValue) {
	this.attributeValue = attributeValue;
}






}
