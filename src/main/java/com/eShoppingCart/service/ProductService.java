package com.eShoppingCart.service;

import java.util.List;

import com.eShoppingCart.model.Product;
import com.eShoppingCart.model.ProductCategory;

public interface ProductService {
	
	List<Product> getProductList();

    Product getProductById(int productId);
    
    void deleteProduct(Product product);
    
    void addProduct(Product product);
    
    void addProductCategory(ProductCategory product);
    
    void editProduct(Product product);

}
