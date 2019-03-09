package com.eShoppingCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.eShoppingCart.dao.CustomerDao;
import com.eShoppingCart.model.Cart;
import com.eShoppingCart.model.CartItem;
import com.eShoppingCart.model.Customer;
import com.eShoppingCart.model.Product;
import com.eShoppingCart.service.CartItemService;
import com.eShoppingCart.service.CartService;
import com.eShoppingCart.service.ProductService;


@Controller
@RequestMapping("/rest/cart")
public class CartResources {

	@Autowired
	private CartService cartService;
	
	@Autowired 
	private CustomerDao customerDao;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@RequestMapping("/{cartId}")
	public @ResponseBody Cart getCartById(@PathVariable(value="cartId") int cartId){
		
		return cartService.getCartById(cartId);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	
	public String addItem(@RequestParam("id") int productId){
		String activeUser=getCurrentUser();
		Customer customer = customerDao.getCustomerByUsername(activeUser);
		Cart cart = customer.getCart();
		Product product = productService.getProductById(productId);
		
		List<CartItem> cartItems = cart.getCartItems();
		
		for(int i=0;i<cartItems.size();i++){
			if(product.getId() == cartItems.get(i).getProduct().getId()){
				CartItem cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
				cartItemService.addCartItem(cartItem);
				
				return "redirect:/customer/cart";
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
		
		return "redirect:/customer/cart";
		
	}
	
	@RequestMapping(value= "/remove/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable(value="id") int productId){
		CartItem cartItem = cartItemService.getCartItemByProductId(productId);
		cartItemService.removeCartItem(cartItem);
	}
	
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void clearCart(@PathVariable(value = "cartId") int cartId){
		cartItemService.removeAllCartItems(cartService.getCartById(cartId));
	}
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, Please check your data")
	public void handleClientErrors(Exception e){}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
	public void handleServerErrors(Exception e){}
	
	public String getCurrentUser() {
		 String username ="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
		return username;
	}
}
