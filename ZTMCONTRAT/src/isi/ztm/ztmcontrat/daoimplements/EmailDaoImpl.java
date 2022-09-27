package isi.ztm.ztmcontrat.daoimplements;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Repository;

import isi.ztm.ztmcontrat.daointerface.IEmailDao;;

@Repository
public class EmailDaoImpl implements IEmailDao{
	
	@PersistenceContext
	EntityManager em;
	
	

	final String username = "zitounatamkeencontrat@gmail.com";
	final String password = "a276021dm";
	Properties props = new Properties();
	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	

	public void sendEmail(String receiver, String object) {


		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.host", "outlook.office365.com");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
		

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("zitounatamkeencontrat@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
			message.setSubject("Reset password");
			message.setText(object);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
}
