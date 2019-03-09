package com.eShoppingCart.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.eShoppingCart.model.Customer;
import com.eShoppingCart.service.CustomerService;
import com.eShoppingCart.service.PaymentService;
import com.eShoppingCart.util.AppConstants;

import com.eShoppingCart.util.SendEmail;




@Controller
public class PaymentController {
	@Autowired 
	private CustomerService customerService;
	
    static String emailToRecipient, emailSubject, emailMessage;
    static final String emailFromRecipient = "show_kat@yahoo.com";
 
    static ModelAndView modelViewObj;
 
   
	
@Autowired
PaymentService paymentService;

@RequestMapping(value = "/home")
public String home() {
	
	return AppConstants.HOME;
	
}

	@RequestMapping(value = "/executePayment")
	public String executePayment(Map<String, String> map,HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String amount=(String)request.getParameter("amount");
		String payerId=(String)request.getParameter("payerId");
		String token=(String)request.getParameter("token");
		HashMap nvp=paymentService.handleConfirmPayment("DoExpressCheckoutPayment",payerId,token,amount);
		String ack=(String) nvp.get("ACK");
		String transactionId=(String) nvp.get("PAYMENTINFO_0_TRANSACTIONID");
		map.put("status", ack);
		map.put("transactionId", transactionId);
		if (ack.equals("Success")){
		return AppConstants.EXECUTE_PAYMENT;}
		else {
			return AppConstants.ERROR;
		}

	}	
	
	@RequestMapping(value = "/authorizePayment")
	public ModelAndView authorizePayment(Map<String, Object> map,HttpServletRequest request,
			HttpServletResponse response,Map<String,String> model) throws ServletException, IOException {
		String amount=request.getParameter("amount");
		
	Map<String,String> nvp=paymentService.handleAuthorizePayment("SetExpressCheckout",request,amount);
		String value=(String) nvp.get("TOKEN");
		String url="https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token="+value;
		HttpSession session=request.getSession();	
		session.setAttribute("amount", amount);	
		
		
		
		return new ModelAndView("redirect:" + url);
		
		//return AppConstants.RETURN_URL;

	}	
	
	
	
	
	@RequestMapping(value = "/cancelUrl")
	public String cancelUrl() {
		
		return "home";
		
	}
	
	@RequestMapping(value = "/returnUrl")
	public String returnUrl(HttpServletRequest request,Map<String,String> model,HttpSession session) throws GeneralSecurityException {
		String token=request.getParameter("token");
		String payerId=request.getParameter("PayerID");
		model.put("token", token);
		model.put("payerId", payerId);
		// Reading Email Form Input Parameters      
          
        
        String user=(String)session.getAttribute("username");
        Customer customer=customerService.getCustomerByUsername(user);
        String email=customer.getCustomerEmail();
        SendEmail send=new SendEmail(email,"Order Processed Successfully","Thank you for your business!\r\nYour order will be shipped in two business days!");
        
		return "thankCustomer";
		
	}
	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
	public String placeOrder(Map<String, Object> map,HttpServletRequest request,
			HttpServletResponse response,Map<String,String> model) throws ServletException, IOException {
		String amount=request.getParameter("orderAmount");
		model.put("amount", amount);
		return AppConstants.PLACE_ORDER;
	}
	
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public String payOrder(Map<String, Object> map,HttpServletRequest request,
			HttpServletResponse response,Map<String,String> model,HttpSession session){
		String amount=request.getParameter("orderAmount");
		String username=getCurrentUser();
        session.setAttribute("username", username);
        //EmailUtility email=new EmailUtility();
       // email.sendEmailToClient(session);
		return "redirect:authorizePayment?amount="+amount ;
	}
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
