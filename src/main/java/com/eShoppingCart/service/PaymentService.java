package com.eShoppingCart.service;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface PaymentService {
	
	
	public Map<String,String> handleAuthorizePayment(String methodName,HttpServletRequest request,String amount) throws IOException;
	public  HashMap handleConfirmPayment(String accesToken,String payerId,String token,String amount) throws IOException;
}
