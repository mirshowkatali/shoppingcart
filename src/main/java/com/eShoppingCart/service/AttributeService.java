package com.eShoppingCart.service;

import java.util.List;

import com.eShoppingCart.model.Attribute;
import com.eShoppingCart.model.AttributeValue;
import com.eShoppingCart.model.Category;

public interface AttributeService {
	
	
	public List<Attribute> getAttributeAll();

	public void addAttribute(Attribute att);
	
	public void addAttributeValue(AttributeValue att);
	
	public void deleteAttribute(int att);
	
	public void deleteAttributeValue(int att);
	
	public Attribute getAttributeById(int id);
	
	public void editAttribute(Attribute att);
	
	public List<AttributeValue> getAttributeValue(int id);
}
