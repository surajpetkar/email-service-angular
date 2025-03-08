package com.email.service;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Value(value = "${mail.username}")
	String username;
	@Value(value = "${mail.password}")
	String password;

	public boolean sendEmail(String subject, String message, String to) {
		
		String from = "spetkar27@gmail.com";
		
		String host = "smtp.gmail.com";
		
		Properties properties = System.getProperties();
		System.out.println("Properties -"+properties);
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		session.setDebug(true);
		
		MimeMessage m = new MimeMessage(session);
		
		try {
			m.setFrom(from);
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			//m.setText(message);
			
			// send email attachment
			MimeMultipart mimeMultipart = new MimeMultipart();
			
			MimeBodyPart text = new MimeBodyPart();
			MimeBodyPart file = new MimeBodyPart();
			
			text.setText(message);
			file.attachFile(new File("C:\\Users\\suraj\\Downloads\\connectwise1.png"));
			
			mimeMultipart.addBodyPart(text);
			mimeMultipart.addBodyPart(file);
			
			m.setContent(mimeMultipart);
			Transport.send(m);
			
			System.out.println("Sent Success........");
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
