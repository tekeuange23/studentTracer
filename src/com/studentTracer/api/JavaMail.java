package com.studentTracer.api;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {
	
	public static void sendMail(String recepientAdress) {
		System.out.println("Preparing to send the mail!");
		
		Properties properties = new Properties(); //to configure the mail properties
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String STAccountEmail = "teststudenttracer@gmail.com";
		String STAccountPassW = "teststudenttracer12345";
		
		Session session  = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(STAccountEmail, STAccountPassW);
			}
		});
		
		Message message = prepareMessage(session, STAccountEmail, recepientAdress);
		try {
			Transport.send(message);
			System.out.println("Message was send succesfully!");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	private static Message prepareMessage(Session s, String senderAdress, String recepientAdress){
		try {
			Message message = new MimeMessage(s);
			message.setFrom(new InternetAddress(senderAdress));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepientAdress));
			message.setSubject("My first email from java app!");
			String content = "<h1>STUDENT-TRACER</h1></br>"
					       + "<h2>Hey there, look my email!</h2>";
			message.setContent(content, "text/html");
			return message;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
