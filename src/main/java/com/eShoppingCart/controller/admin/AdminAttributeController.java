package com.eShoppingCart.controller.admin;

import java.util.List;
import java.util.Map;

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

import com.eShoppingCart.model.Attribute;
import com.eShoppingCart.model.AttributeValue;
import com.eShoppingCart.model.Category;
import com.eShoppingCart.model.Product;
import com.eShoppingCart.model.ProductCategory;
import com.eShoppingCart.service.AttributeService;

@Controller
@RequestMapping("/admin")
public class AdminAttributeController {
	
	@Autowired
	private AttributeService attributeService;
	
	
	@RequestMapping("/attribute/addAttribute")
	public String addAttribute(Model model){
		Attribute attrib= new Attribute();
		model.addAttribute("attrib", attrib);
		return "addAttribute";
	}
	
	@RequestMapping(value="/attribute/addAttribute", method=RequestMethod.POST)
	public String addAttribute(@Valid @ModelAttribute(value="attrib") Attribute attribute, BindingResult result, HttpServletRequest request, Model model){
			
		
		attributeService.addAttribute(attribute);
		
		return "redirect:/admin/attribute";
		
	}
	
	@RequestMapping("/attribute/editAttribute/{id}")
	public String editAttribute(@PathVariable(value="id") int id, Model model){
		Attribute attribute = attributeService.getAttributeById(id);
		List<AttributeValue> attrib=attributeService.getAttributeValue(id);
		model.addAttribute("attrib", attrib);
		return "editAttribute";
	}
	@RequestMapping(value="/attribute/editAttribute", method=RequestMethod.POST)
	public String editAttribute(@Valid @ModelAttribute(value="attrib") Attribute attribute, BindingResult result, HttpServletRequest request){
		
		if(result.hasErrors()){
			return "editAttribute";
		}
		
		
		
		attributeService.editAttribute(attribute);
		
		return "redirect:/admin/attribute";
		
	}
	@RequestMapping("/attribute/deleteAttribute/{id}")
	public String deleteAttribute(@PathVariable int id,Model model,HttpServletRequest request) {
		
		
		
		
		attributeService.deleteAttribute(id);
		
		return "redirect:/admin/attribute";
	}
	@RequestMapping("/attribute/addAttributeValue")
	public String addAttributeValue(Model model){
		AttributeValue attrib= new AttributeValue();
		List<Attribute> attributeList=attributeService.getAttributeAll();
		model.addAttribute("attrib", attrib);
		model.addAttribute("attributeList", attributeList);
		return "addAttributeValue";
	}
	
	@RequestMapping(value="/attribute/addAttributeValue", method=RequestMethod.POST)
	public String addAttributeValue(@Valid @ModelAttribute(value="attrib") AttributeValue attribute, BindingResult result, HttpServletRequest request, Model model){
			
		
		attributeService.addAttributeValue(attribute);
		
		return "redirect:/admin/attribute";
		
	}
	
	@RequestMapping("/attribute/deleteAttributeValue/{id}")
	public String deleteAttributeValue(@PathVariable int id,Model model,HttpServletRequest request) {
		
		
		
		
		attributeService.deleteAttributeValue(id);
		
		return "redirect:/admin/attribute";
	}
}
