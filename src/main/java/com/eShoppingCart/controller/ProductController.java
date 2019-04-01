package com.eShoppingCart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eShoppingCart.dao.DepartmentDao;
import com.eShoppingCart.model.AttributeValue;
import com.eShoppingCart.model.Category;
import com.eShoppingCart.model.Department;
import com.eShoppingCart.model.Product;
import com.eShoppingCart.service.CategoryService;
import com.eShoppingCart.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/category/{id}")
	public String category(@PathVariable(value="id") int id, Model model){
		List<Category> cat = categoryService.getCategoryById(id);
		model.addAttribute("cat", cat);
		return "productList";
	}
	
	@RequestMapping("/category1/{id}")
	public String category1(@PathVariable(value="id") int id, Model model, HttpSession session){
		List<Integer> cat = categoryService.getProductByCategoryId(id);
		List<Product> prod= new ArrayList<Product>();
		List<Object> attribValue=new ArrayList<Object>();
		List<Object> attribValue1=new ArrayList<Object>();
		for(Integer cat1:cat) {
			
			Product prod1=categoryService.getProductByProductId(cat1);
			prod.add(prod1);
			
			//attribValue.add(av);
			
		}
		for(Product prod1:prod) {
		attribValue=categoryService.getAttributeValues(prod1.getId());
		attribValue1=categoryService.getAttributeValues1(prod1.getId());
		break;
		}
		//List<AttributeValue> attribValue=categoryService.getAttributeValues()
		session.setAttribute("attribValue", attribValue);
		session.setAttribute("attribValue1", attribValue1);
		model.addAttribute("prod", prod);
		return "productList";
	}
	
	@RequestMapping("/productList/all")
	public String getProducts(Model model,HttpSession session){
		List<Department> dept= departmentDao.getDepartmentList();
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		model.addAttribute("dept", dept);
		List<Object> attribValue=new ArrayList<Object>();
		List<Object> attribValue1=new ArrayList<Object>();
		
		for(Product prod1:products) {
		attribValue=categoryService.getAttributeValues(prod1.getId());
		attribValue1=categoryService.getAttributeValues1(prod1.getId());
		
		}
		//List<AttributeValue> attribValue=categoryService.getAttributeValues()
		session.setAttribute("attribValue", attribValue);
		session.setAttribute("attribValue1", attribValue1);
		
		return "productList1";
	}
	
	@RequestMapping("/viewProduct/{id}")
	public String viewProduct(@PathVariable(value="id") int id, Model model,HttpSession session){
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		
		return "viewProductDetail";
	
	}
	
	@RequestMapping("/productList")
	public String getProductByCategory(@RequestParam("searchCondition") String searchCondition, Model model){
		
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		model.addAttribute("searchCondition", searchCondition);
		
		return "productList";
	}
	
}
