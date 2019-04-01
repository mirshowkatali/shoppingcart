package com.eShoppingCart.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eShoppingCart.model.Category;
import com.eShoppingCart.model.Department;
import com.eShoppingCart.service.CategoryService;
import com.eShoppingCart.service.DepartmentService;

@Controller
@RequestMapping("/admin")
public class AdminCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@RequestMapping("/category/{id}")
	public String category(@PathVariable(value="id") int id, Model model){
		List<Category> cat = categoryService.getCategoryById(id);
		Department dept=departmentService.getDepartmentById(id);
		model.addAttribute("cat", cat);
		model.addAttribute("dept", dept);
		return "showCategory";
	}
	
	@RequestMapping("/category/addCategory")
	public String addDepartment(Model model){
		Category cat = new Category();
			
		model.addAttribute("cat", cat);
		return "addCategory";
	}
	@RequestMapping(value="/category/addCategory", method=RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute(value="cat") Category category, BindingResult result, HttpServletRequest request, Model model){
			
		
		categoryService.addCategory(category);
		
		return "addCategory";
		
	}
	@RequestMapping("/category/editCategory/{id}")
	public String editCategory(@PathVariable(value="id") int id, Model model){
		Category cat = categoryService.getCategoryById1(id);
		
		model.addAttribute("cat", cat);
		return "editCategory";
	}
	@RequestMapping(value="/category/editCategory", method=RequestMethod.POST)
	public String editCategory(@Valid @ModelAttribute(value="dept") Category category, BindingResult result, HttpServletRequest request){
		
		if(result.hasErrors()){
			return "editCategory";
		}
		
		
		
		categoryService.editCategory(category);
		
		return "redirect:/admin/category";
		
	}
	@RequestMapping("/category/deleteCategory/{id}")
	public String deleteCategory(@PathVariable int id,Model model,HttpServletRequest request) {
		
		
		
		
		categoryService.deleteCategory(id);
		
		return "redirect:/admin/category";
	}
	
	@RequestMapping("/category/viewCategory/{id}")
	public String viewCategory(@PathVariable int id,Model model,HttpServletRequest request) {
		
		
		
		
		Category cat=categoryService.getCategoryById1(id);
		model.addAttribute("cat", cat);
		
		return "viewCategory";
	}
}
