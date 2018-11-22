package services;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailUtil {
	public static void main(String[] args) {	
		//sendMail("Devtest1@wb21.com", "652a9e338e0A2C1", "Devtest1@wb21.com", "Devtest1@wb21.com", "Hello", "<html><body><h1>How are you</h1></body></html>","text/html");
	}
	
	/////////////////Don't modify below Method//////////////////////////
	//contenttype - send text/html or text/pdf or text/plain etc..
	//body - suitable body format as per content type
	public static boolean sendMail(final String username,final String password,String from, String to,String subject, String body,String contenttype) {
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		// Get a Properties object
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.store.protocol", "pop3");
		props.put("mail.transport.protocol", "smtp");
		//username = ""; //dev test username
		//final String password = "";  //dev password
		try{
			Session session = null;
			
			/*session=Session.getDefaultInstance(props, 
					new Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}});*/
			
			session = Session.getInstance(props,new Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}});
			
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));  
			msg.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(to,false));  
			msg.setSubject(subject);
			if(contenttype.equals("text/html")){
				//msg.setText(body); //changing this to accomodate contenttype
				msg.setSentDate(new Date());
				msg.setContent(body,contenttype);
				
			}else if(contenttype.equals("text"))
				msg.setText(body);  
		  
			Transport.send(msg);
			System.out.println("Message sent !");
			return true;
		}
		/*catch (MessagingException e)
		{ 
			System.out.println("Messaging Exception : " + e);
			e.printStackTrace();
			return false;
		}*/
		catch (Exception ex)
		{ 
			System.out.println("Exception : " + ex);
			ex.printStackTrace();
			return false;
		}
	}
	/////////////////Don't modify above Method//////////////////////////
}