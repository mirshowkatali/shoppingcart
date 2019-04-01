package com.eShoppingCart.dao;

import java.util.List;

import com.eShoppingCart.model.AttributeValue;
import com.eShoppingCart.model.Category;
import com.eShoppingCart.model.Product;

public interface CategoryDao {
	public List<Category> getCategoryById(int id);
	
	public List<Integer> getProductByCategoryId(int id);
	
	public Product getProductByProductId(int id);
	
	public List<Object> getAttributeValues(int id);
	
	public List<Object> getAttributeValues1(int id);
	
	public List<Category> getCategoryAll();
	
	public Category getCategoryById1(int id);
	
	void deleteCategory(int cat);
    
    void addCategory(Category cat);
    
    void editCategory(Category cat);
    
    
}
