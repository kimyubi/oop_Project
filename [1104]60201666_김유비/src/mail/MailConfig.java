package mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailConfig extends Authenticator {
	
	PasswordAuthentication authentication;
	
	public MailConfig() {
	
		String id = "ddingdongmj@gmail.com";
		String pwd= "xjmgnljqnqoosbvb";
		
		authentication = new PasswordAuthentication(id, pwd);
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return authentication;
	}
	

}
