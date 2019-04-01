package com.eShoppingCart.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eShoppingCart.service.AttributeService;
import com.eShoppingCart.service.DepartmentService;
import com.eShoppingCart.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private AttributeService attributeService;
	
	
	@Autowired
	private  DepartmentService departmentService;
	
	@RequestMapping
	public String home(){
		return "admin";
	}
	
	@RequestMapping("/productInventory")
	public String productInventory(Model model){
		model.addAttribute("products", productService.getProductList());
		 
		return "productInventory";
	}
	
	@RequestMapping("/department")
	public String department(Model model){
		model.addAttribute("dept", departmentService.getDepartmentList());
		 
		return "department";
	}
	
	@RequestMapping("/category")
	public String category(Model model){
		model.addAttribute("dept", departmentService.getDepartmentList());
		 
		return "category";
	}
	
	@RequestMapping("/attribute")
	public String attribute(Model model){
		model.addAttribute("att", attributeService.getAttributeAll());
		 
		return "attribute";
	}
}
