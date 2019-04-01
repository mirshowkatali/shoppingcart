package com.eShoppingCart.dao;

import java.util.List;

import com.eShoppingCart.model.Attribute;
import com.eShoppingCart.model.AttributeValue;

public interface AttributeDao {
	
	public List<Attribute> getAttributeAll();
	
	public void addAttribute(Attribute att);
	
	public void addAttributeValue(AttributeValue att);
	
	public void deleteAttribute(int att);
	
	public void deleteAttributeValue(int att);
	
	public Attribute getAttributeById(int id);
	
	public void editAttribute(Attribute att);
	
	public List<AttributeValue> getAttributeValue(int id);

}
