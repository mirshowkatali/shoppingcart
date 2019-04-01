package com.eShoppingCart.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
import org.springframework.web.multipart.MultipartFile;

import com.eShoppingCart.model.Department;
import com.eShoppingCart.model.Product;
import com.eShoppingCart.service.DepartmentService;
import com.eShoppingCart.service.ProductService;


@Controller
@RequestMapping("/admin")
public class AdminDepartmentController {
	
	
	
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/department/addDepartment")
	public String addDepartment(Model model){
		Department dept = new Department();
			
		model.addAttribute("dept", dept);
		return "addDepartment";
	}
	@RequestMapping(value="/department/addDepartment", method=RequestMethod.POST)
	public String addDepartment(@Valid @ModelAttribute(value="dept") Department department, BindingResult result, HttpServletRequest request){
		
		if(result.hasErrors()){
			return "addDepartment";
		}
		
		
		departmentService.addDepartment(department);
		
		return "redirect:/admin/department";
		
	}
	@RequestMapping("/department/editDepartment/{id}")
	public String editProduct(@PathVariable(value="id") int id, Model model){
		Department dept = departmentService.getDepartmentById(id);
		
		model.addAttribute("dept", dept);
		return "editDepartment";
	}
	@RequestMapping(value="/department/editDepartment", method=RequestMethod.POST)
	public String editProduct(@Valid @ModelAttribute(value="dept") Department department, BindingResult result, HttpServletRequest request){
		
		if(result.hasErrors()){
			return "editDepartment";
		}
		
		
		
		departmentService.editDepartment(department);
		
		return "redirect:/admin/department";
		
	}
	@RequestMapping("/department/deleteDepartment/{id}")
	public String deleteDepartment(@PathVariable int id,Model model,HttpServletRequest request) {
		
		
		
		
		departmentService.deleteDepartment(departmentService.getDepartmentById(id));
		
		return "redirect:/admin/department";
	}
	
	@RequestMapping("/department/viewDepartment/{id}")
	public String viewDepartment(@PathVariable int id,Model model,HttpServletRequest request) {
		
		
		
		
		Department department=departmentService.getDepartmentById(id);
		model.addAttribute("department", department);
		
		return "redirect:/admin/department";
	}
	
}
