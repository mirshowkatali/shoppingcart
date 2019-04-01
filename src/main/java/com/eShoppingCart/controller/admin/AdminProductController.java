package com.eShoppingCart.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;

import com.eShoppingCart.model.Category;
import com.eShoppingCart.model.Product;
import com.eShoppingCart.model.ProductCategory;
import com.eShoppingCart.service.CategoryService;
import com.eShoppingCart.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminProductController {

	
	private Path path;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/product/addProduct")
	public String addProduct(Map model){
		Product product = new Product();
		List<Category> cat=categoryService.getCategoryAll();
		ProductCategory pc=new ProductCategory();
		model.put("pc", pc);
		model.put("cat", cat);
		model.put("product", product);
		return "addProduct";
	}
	
	@RequestMapping(value="/product/addProduct", method=RequestMethod.POST)
	public String addProduct(HttpServletRequest request){
		
		String name=request.getParameter("name");
		String category=request.getParameter("category");
		int category1=Integer.parseInt(category);
		String description=request.getParameter("description");
	    String price=request.getParameter("price");
	    double price1=Double.parseDouble(price);
	    String discountedPrice=request.getParameter("discountedPrice");
	    double discountedPrice1=Double.parseDouble(discountedPrice);
	    String image=request.getParameter("image");
	    String image_2=request.getParameter("image_2");
	    String thumbnail=request.getParameter("thumbnail");
	    
	    Product product= new Product();
	    product.setName(name);
	    product.setDescription(description);
	    product.setPrice(price1);
	    product.setDiscountedPrice(discountedPrice1);
	    product.setImage(image);
	    product.setImage_2(image_2);
	    product.setThumbnail(thumbnail);
	    
	    ProductCategory pc=new ProductCategory();
	    pc.setCategoryId(category1);
	    
		productService.addProduct(product);
		pc.setProductId(product.getId());
		productService.addProductCategory(pc);
		
		MultipartFile productImage = product.getImag();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getId()+".gif");
		
		if(productImage != null  && !productImage.isEmpty()){
			try{
				 productImage.transferTo(new File(path.toString()));
			}catch (Exception e) {
				 e.printStackTrace();
	             throw new RuntimeException("Product image saving failed", e);
			}
		}
		
		return "redirect:/admin/productInventory";
		
	}
	
	@RequestMapping("/product/editProduct/{id}")
	public String editProduct(@PathVariable(value="id") int id, Model model){
		Product product = productService.getProductById(id);
		List<Category> cat=categoryService.getCategoryAll();
		model.addAttribute("product", product);
		model.addAttribute("cat", cat);
		return "editProduct";
	}
	
	@RequestMapping(value="/product/editProduct", method=RequestMethod.POST)
	public String editProduct(HttpServletRequest request){
		String id=request.getParameter("id");
		int id1=Integer.parseInt(id);
		Product product = productService.getProductById(id1);
		
		String name=request.getParameter("name");
		String category=request.getParameter("category");
		int category1=Integer.parseInt(category);
		String description=request.getParameter("description");
	    String price=request.getParameter("price");
	    double price1=Double.parseDouble(price);
	    String discountedPrice=request.getParameter("discountedPrice");
	    double discountedPrice1=Double.parseDouble(discountedPrice);
	    String image=request.getParameter("image");
	    
	    
	    product.setName(name);
	    product.setDescription(description);
	    product.setPrice(price1);
	    product.setDiscountedPrice(discountedPrice1);
	    
		
		
		
		
		MultipartFile productImage = product.getImag();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getId()+".png");
		
		if(productImage != null  && !productImage.isEmpty()){
			try{
				 productImage.transferTo(new File(path.toString()));
			}catch (Exception e) {
				 e.printStackTrace();
	             throw new RuntimeException("Product image saving failed", e);
			}
		}
		
		productService.editProduct(product);
		
		return "redirect:/admin/productInventory";
		
	}
	
	@RequestMapping("/product/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id,Model model,HttpServletRequest request) {
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		System.out.println(rootDirectory);
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+id +".png");
		
		if(Files.exists(path)){
			try{
				Files.delete(path);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		productService.deleteProduct(productService.getProductById(id));
		
		return "redirect:/admin/productInventory";
	}
	
}
