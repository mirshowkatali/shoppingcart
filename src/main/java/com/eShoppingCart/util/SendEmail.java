package com.eShoppingCart.util;
import javax.mail.*;
import javax.mail.internet.*;

import com.sun.mail.util.MailSSLSocketFactory;

import java.security.GeneralSecurityException;
import java.util.*;

public class SendEmail {

   final String senderEmailID = "showkat.mir8901@gmail.com";
final String senderPassword = "show_mail456";
final String emailSMTPserver = "smtp.gmail.com";
final String emailServerPort = "465";
String receiverEmailID = null;
static String emailSubject = "Order Processed Successfully";
static String emailBody = "Thank you for your business!\r\n" + 
		"Your order will be shipped in two business days!";
public SendEmail(String receiverEmailID, String emailSubject, String emailBody) throws GeneralSecurityException
{
this.receiverEmailID=receiverEmailID;
this.emailSubject=emailSubject;
this.emailBody=emailBody;
MailSSLSocketFactory sf = new MailSSLSocketFactory();
sf.setTrustAllHosts(true); 
Properties props = new Properties();
props.put("mail.smtp.user",senderEmailID);
props.put("mail.smtp.host", emailSMTPserver);
props.put("mail.smtp.port", emailServerPort);
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.socketFactory.port", emailServerPort);
props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.socketFactory.fallback", "false");
props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
props.put("mail.smtp.ssl.socketFactory", sf);
props.put("mail.transport.protocol", "smtps");
SecurityManager security = System.getSecurityManager();
try
{
Authenticator auth = new SMTPAuthenticator();
Session session = Session.getInstance(props, auth);
MimeMessage msg = new MimeMessage(session);
msg.setText(emailBody);
msg.setSubject(emailSubject);
msg.setFrom(new InternetAddress(senderEmailID));
msg.addRecipient(Message.RecipientType.TO,
new InternetAddress(receiverEmailID));
Transport.send(msg);
System.out.println("Message send Successfully:)");
}
catch (Exception mex)
{
mex.printStackTrace();
}
}
public class SMTPAuthenticator extends javax.mail.Authenticator
{
public PasswordAuthentication getPasswordAuthentication()
{
return new PasswordAuthentication(senderEmailID, senderPassword);
}
}
}