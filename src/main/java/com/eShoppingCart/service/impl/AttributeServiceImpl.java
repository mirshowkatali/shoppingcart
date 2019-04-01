package com.eShoppingCart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eShoppingCart.dao.AttributeDao;
import com.eShoppingCart.model.Attribute;
import com.eShoppingCart.model.AttributeValue;
import com.eShoppingCart.service.AttributeService;


@Service
public class AttributeServiceImpl implements AttributeService {

	
	@Autowired
	private AttributeDao attributeDao;
	
	
	@Override
	public List<Attribute> getAttributeAll() {
		List<Attribute> att=attributeDao.getAttributeAll();
		return att;
	}


	@Override
	public void addAttribute(Attribute att) {
		attributeDao.addAttribute(att);
		
	}


	@Override
	public void deleteAttribute(int att) {
		attributeDao.deleteAttribute(att);
		
	}


	@Override
	public Attribute getAttributeById(int id) {
		
		return attributeDao.getAttributeById(id);
	}


	@Override
	public void editAttribute(Attribute att) {
		 attributeDao.editAttribute(att);
		
	}


	@Override
	public List<AttributeValue> getAttributeValue(int id) {
		return (List<AttributeValue>) attributeDao.getAttributeValue(id);
	}


	@Override
	public void addAttributeValue(AttributeValue att) {
		attributeDao.addAttributeValue(att);
		
	}


	@Override
	public void deleteAttributeValue(int att) {
		attributeDao.deleteAttributeValue(att);
		
	}

}
