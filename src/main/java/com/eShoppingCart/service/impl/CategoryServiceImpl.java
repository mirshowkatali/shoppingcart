package com.eShoppingCart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eShoppingCart.dao.CategoryDao;
import com.eShoppingCart.model.AttributeValue;
import com.eShoppingCart.model.Category;
import com.eShoppingCart.model.Product;
import com.eShoppingCart.service.CategoryService;
@Service
public class CategoryServiceImpl  implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> getCategoryById(int id) {
		List<Category> cat=categoryDao.getCategoryById(id);
		
		return cat;
	}

	@Override
	public void deleteCategory(int cat) {
		categoryDao.deleteCategory(cat);
		
	}

	@Override
	public void addCategory(Category cat) {
		categoryDao.addCategory(cat);
		
	}

	@Override
	public void editCategory(Category cat) {
		categoryDao.editCategory(cat);
		
	}

	@Override
	public Category getCategoryById1(int id) {
		return categoryDao.getCategoryById1(id);
	}

	@Override
	public List<Category> getCategoryAll() {
List<Category> cat=categoryDao.getCategoryAll();
		
		return cat;
	}

	@Override
	public List<Integer> getProductByCategoryId(int id) {
List<Integer> cat=categoryDao.getProductByCategoryId(id);
		
		return cat;
	}
	@Override
	public Product getProductByProductId(int id) {
Product cat=categoryDao.getProductByProductId(id);
		
		return cat;
	}

	@Override
	public List<Object> getAttributeValues(int id) {
		List<Object> cat=categoryDao.getAttributeValues(id);
		
		return cat;
	}
	
	@Override
	public List<Object> getAttributeValues1(int id) {
		List<Object> cat=categoryDao.getAttributeValues1(id);
		
		return cat;
	}
}
