/**
 * 
 */
package com.eShoppingCart.service.impl;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.bouncycastle.crypto.tls.CertificateRequest;
import org.bouncycastle.crypto.tls.DefaultTlsClient;
import org.bouncycastle.crypto.tls.TlsAuthentication;
import org.bouncycastle.crypto.tls.TlsClientProtocol;
import org.bouncycastle.crypto.tls.TlsCredentials;
import org.springframework.stereotype.Service;

import com.eShoppingCart.service.PaymentService;

/**
 * @author Showkat
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	
	

	

	public Map<String,String> handleAuthorizePayment(String methodName,HttpServletRequest request,String amount) throws IOException {
       
		String respText = "";
		HashMap nvp=null;
		HttpSession session=request.getSession();
		
		
		String gv_APISignature = "";
		String gv_APIUserName = "";
		
		String gv_APIPassword = "";
	    String gv_PaymentAction="";
	    String gv_CurrencyCode="";
	    String version = "";
	    String cancelUrl="";
	    String returnUrl="";
	    Properties prop = new Properties();
		//String encodedData ="USER="+gv_APIUserName+"&PWD="+gv_APIPassword+"&SIGNATURE="+gv_APISignature+"&METHOD="+methodName+"&VERSION="+version+"&PAYMENTREQUEST_0_PAYMENTACTION="+gv_PaymentAction+"&PAYMENTREQUEST_0_AMT="+amount+"&PAYMENTREQUEST_0_CURRENCYCODE="+gv_CurrencyCode+"&cancelUrl="+cancelUrl+"&returnUrl="+returnUrl;
		/*InputStream inputStream = null;
		try {
			
			
 
			inputStream = getClass().getClassLoader().getResourceAsStream("sdk_config.properties");
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + "sdk_config.properties" + "' not found in the classpath");
			}
 
			
 
			// get the property value 
			 gv_APISignature = prop.getProperty("gv_APISignature");
			 gv_APIUserName = prop.getProperty("gv_APIUserName");
			 gv_APIPassword = prop.getProperty("gv_APIPassword");
			 gv_CurrencyCode = prop.getProperty("gv_CurrencyCode");
			 gv_PaymentAction = prop.getProperty("gv_PaymentAction");
			 version = prop.getProperty("version");
			 cancelUrl = prop.getProperty("cancelUrl");
			 returnUrl = prop.getProperty("returnUrl");
		     
			
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		*/
		Map<String,String> paramMap=new HashMap<String,String>();
		paramMap.put("USER","show_kat-facilitator-1_api1.yahoo.com");
		paramMap.put("PWD","XS76L5C8SFSTJGC3");
		paramMap.put("SIGNATURE","AhKjPyUAFwaeM5vZHwjU.0caZhHtAppvGhijIcA.zsWpAfw6Q3SvzGNO");
		paramMap.put("METHOD",methodName);
		paramMap.put("VERSION","95");
		paramMap.put("PAYMENTREQUEST_0_PAYMENTACTION","Authorization");
		paramMap.put("PAYMENTREQUEST_0_AMT",amount);
		paramMap.put("PAYMENTREQUEST_0_CURRENCYCODE","USD");
		paramMap.put("cancelUrl","http://127.0.0.1:8087/ShoppingCart/cancelUrl");
		paramMap.put("returnUrl","http://127.0.0.1:8087/ShoppingCart/returnUrl");
		
		

		    StringBuilder data = new StringBuilder();
		    Iterator<Entry<String, String>> paramIt = paramMap.entrySet().iterator();
		    while (paramIt.hasNext()) {
		        Entry<String, String> param = paramIt.next();
		        data.append(param.getKey()).append("=").append(param.getValue());
		        if (paramIt.hasNext()) {
		            data.append("&");
		        }
		    }

		    try {
		        URL url = new URL("https://api-3t.sandbox.paypal.com/nvp");


		        java.security.SecureRandom secureRandom = new java.security.SecureRandom();
		        Socket socket = new Socket(java.net.InetAddress.getByName(url.getHost()), 443);
		        TlsClientProtocol protocol = new TlsClientProtocol(socket.getInputStream(), socket.getOutputStream(), secureRandom);
		        DefaultTlsClient client = new DefaultTlsClient() {
		            public TlsAuthentication getAuthentication() throws IOException {
		                TlsAuthentication auth = new TlsAuthentication() {
		                    // Capture the server certificate information!
		                    public void notifyServerCertificate(org.bouncycastle.crypto.tls.Certificate serverCertificate) throws IOException {
		                    }

		                    public TlsCredentials getClientCredentials(CertificateRequest certificateRequest) throws IOException {
		                        return null;
		                    }
		                };
		                return auth;
		            }
		        };

		        protocol.connect(client);
		        java.io.OutputStream output2 = protocol.getOutputStream();
		        output2.write(("POST " + url.getPath() + " HTTP/1.1\r\n").getBytes("UTF-8"));
		        output2.write(("Host: " + url.getHost() + "\r\n").getBytes("UTF-8"));
		        output2.write("Connection: close\r\n".getBytes("UTF-8")); // So the server will close socket immediately.
		        output2.write(("Content-Length: " + data.length() + "\r\n").getBytes("UTF-8")); // So the server will close socket immediately.
		        output2.write("Content-Type:text/plain; charset=UTF-8\r\n".getBytes("UTF-8")); // So the server will close socket immediately.
		        output2.write("\r\n".getBytes("UTF-8")); // HTTP1.1 requirement: last line must be empty line.
		        output2.write(data.toString().getBytes("UTF-8"));
		        output2.flush();

		        InputStream input2 = protocol.getInputStream();
		        StringBuilder stringBuffer = new StringBuilder();
		        try {
		            InputStreamReader reader = new InputStreamReader(input2, "UTF-8");
		            int ch;
		            while ((ch = reader.read()) > -1) {
		                stringBuffer.append((char) ch);
		            }
		            reader.close();
		        } catch (Exception e) {
		            // Log some messages...
		        }

		        Map<String, String> result = new HashMap<String, String>();
		        String[] lines = stringBuffer.toString().split("\r\n");
		        String paramsLine = "";
		        for (int i = 0; i < lines.length; i++) {
		            if (lines[i].equals("")) {
		                paramsLine = lines[i + 1];
		                i = lines.length;
		            }
		        }

		        
		        for (String param : paramsLine.split("&")) {
		            String[] keyValue = param.split("=");
		            result.put(keyValue[0], URLDecoder.decode(keyValue[1], "UTF-8"));
		        }

		        return result;
		    } catch (Exception e) {
		        // Log some messages....
		        return null;
		    }
		}
		
	
	
	
	
		
		public HashMap<String,String>  handleConfirmPayment(String methodName,String payerId, String token,String amount) throws IOException {
			
			String respText = "";
			HashMap nvp=null;
			
			String gv_APISignature = "";
			String gv_APIUserName = "";
			
			String gv_APIPassword = "";
		    String gv_PaymentAction="";
		    String gv_CurrencyCode="";
		    String version = "";
		   			//String encodedData ="USER="+gv_APIUserName+"&PWD="+gv_APIPassword+"&SIGNATURE="+gv_APISignature+"&METHOD="+methodName+"&VERSION="+version+"&PAYMENTREQUEST_0_PAYMENTACTION="+gv_PaymentAction+"&PAYMENTREQUEST_0_AMT="+amount+"&PAYMENTREQUEST_0_CURRENCYCODE="+gv_CurrencyCode+"&cancelUrl="+cancelUrl+"&returnUrl="+returnUrl;
			/*InputStream inputStream = null;
			try {
				Properties prop = new Properties();
				
	 
				inputStream = getClass().getClassLoader().getResourceAsStream("sdk_config.properties");
	 
				if (inputStream != null) {
					prop.load(inputStream);
				} else {
					throw new FileNotFoundException("property file '" + "sdk_config.properties" + "' not found in the classpath");
				}
	 
				Date time = new Date(System.currentTimeMillis());
	 
				// get the property value 
				 gv_APISignature = prop.getProperty("gv_APISignature");
				 gv_APIUserName = prop.getProperty("gv_APIUserName");
				 gv_APIPassword = prop.getProperty("gv_APIPassword");
				 gv_CurrencyCode = prop.getProperty("gv_CurrencyCode");
				 gv_PaymentAction = prop.getProperty("gv_PaymentAction");
				 version = prop.getProperty("version");
				
			     
	 
				
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			} finally {
				inputStream.close();
			}
			*/
			
			// Enter Seller paypal account details,payerId and token
			Map<String,String> paramMap=new HashMap<String,String>();
			paramMap.put("USER","show_kat-facilitator-1_api1.yahoo.com");
			paramMap.put("PWD","XS76L5C8SFSTJGC3");
			paramMap.put("SIGNATURE","AhKjPyUAFwaeM5vZHwjU.0caZhHtAppvGhijIcA.zsWpAfw6Q3SvzGNO");
			paramMap.put("METHOD",methodName);
			paramMap.put("VERSION","95");
			paramMap.put("TOKEN",token);
			paramMap.put("PAYERID",payerId);
			paramMap.put("PAYMENTREQUEST_0_PAYMENTACTION","Authorization");
			paramMap.put("PAYMENTREQUEST_0_AMT",amount);
			paramMap.put("PAYMENTREQUEST_0_CURRENCYCODE","USD");
			
			

			    StringBuilder data = new StringBuilder();
			    Iterator<Entry<String, String>> paramIt = paramMap.entrySet().iterator();
			    while (paramIt.hasNext()) {
			        Entry<String, String> param = paramIt.next();
			        data.append(param.getKey()).append("=").append(param.getValue());
			        if (paramIt.hasNext()) {
			            data.append("&");
			        }
			    }

			    try {
			        URL url = new URL("https://api-3t.sandbox.paypal.com/nvp");

			       
			        java.security.SecureRandom secureRandom = new java.security.SecureRandom();
			        Socket socket = new Socket(java.net.InetAddress.getByName(url.getHost()), 443);
			        TlsClientProtocol protocol = new TlsClientProtocol(socket.getInputStream(), socket.getOutputStream(), secureRandom);
			        DefaultTlsClient client = new DefaultTlsClient() {
			            public TlsAuthentication getAuthentication() throws IOException {
			                TlsAuthentication auth = new TlsAuthentication() {
			                    // Capture the server certificate information!
			                    public void notifyServerCertificate(org.bouncycastle.crypto.tls.Certificate serverCertificate) throws IOException {
			                    }

			                    public TlsCredentials getClientCredentials(CertificateRequest certificateRequest) throws IOException {
			                        return null;
			                    }
			                };
			                return auth;
			            }
			        };

			        protocol.connect(client);
			        java.io.OutputStream output2 = protocol.getOutputStream();
			        output2.write(("POST " + url.getPath() + " HTTP/1.1\r\n").getBytes("UTF-8"));
			        output2.write(("Host: " + url.getHost() + "\r\n").getBytes("UTF-8"));
			        output2.write("Connection: close\r\n".getBytes("UTF-8")); // So the server will close socket immediately.
			        output2.write(("Content-Length: " + data.length() + "\r\n").getBytes("UTF-8")); // So the server will close socket immediately.
			        output2.write("Content-Type:text/plain; charset=UTF-8\r\n".getBytes("UTF-8")); // So the server will close socket immediately.
			        output2.write("\r\n".getBytes("UTF-8")); // HTTP1.1 requirement: last line must be empty line.
			        output2.write(data.toString().getBytes("UTF-8"));
			        output2.flush();

			        InputStream input2 = protocol.getInputStream();
			        StringBuilder stringBuffer = new StringBuilder();
			        try {
			            InputStreamReader reader = new InputStreamReader(input2, "UTF-8");
			            int ch;
			            while ((ch = reader.read()) > -1) {
			                stringBuffer.append((char) ch);
			            }
			            reader.close();
			        } catch (Exception e) {
			            // Log some messages...
			        }

			        HashMap<String, String> result = new HashMap<String, String>();
			        String[] lines = stringBuffer.toString().split("\r\n");
			        String paramsLine = "";
			        for (int i = 0; i < lines.length; i++) {
			            if (lines[i].equals("")) {
			                paramsLine = lines[i + 1];
			                i = lines.length;
			            }
			        }

			        
			        for (String param : paramsLine.split("&")) {
			            String[] keyValue = param.split("=");
			            result.put(keyValue[0], URLDecoder.decode(keyValue[1], "UTF-8"));
			        }

			        return result;
			    } catch (Exception e) {
			        // Log some messages....
			        return null;
			    }
		
}
}