package com.eShoppingCart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eShoppingCart.dao.DepartmentDao;
import com.eShoppingCart.model.Department;
import com.eShoppingCart.model.Product;
import com.eShoppingCart.service.CategoryService;
import com.eShoppingCart.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@RequestMapping("/")
	public String home(Model model,HttpSession session){
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
List<Department> dept= departmentDao.getDepartmentList();
		
		
		model.addAttribute("dept", dept);
		
		
		List<Object> attribValue=new ArrayList<Object>();
		List<Object> attribValue1=new ArrayList<Object>();
		
		for(Product prod1:products) {
		attribValue=categoryService.getAttributeValues(prod1.getId());
		attribValue1=categoryService.getAttributeValues1(prod1.getId());
		break;
		}
		//List<AttributeValue> attribValue=categoryService.getAttributeValues()
		session.setAttribute("attribValue", attribValue);
		session.setAttribute("attribValue1", attribValue1);
		
		
		
		return "productList1";
		
	}
	
	@RequestMapping("/login")
    public String login(@RequestParam (value="error", required = false) String error,
                        @RequestParam (value="logout", required = false) String logout, Model model
                        ) {

        if(error != null) {
            model.addAttribute("error", "Invalid username and password!");
        }

        if(logout!= null) {
            model.addAttribute("msg", "You have been logged out successfully.");
        }

        return "login";
    }

}
