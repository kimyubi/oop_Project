package mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import valueObject.VUser;

public class MailSender {

	private Properties properties;
	private Authenticator authenticator;
	private Session session;
	
	public MailSender() {
		this.properties = System.getProperties();
		this.properties.put("mail.smtp.starttls.enable", "true");
		this.properties.put("mail.smtp.host", "smtp.gmail.com");
		this.properties.put("mail.smtp.auth", "true");
		this.properties.put("mail.smtp.port", "587");

		this.authenticator = new MailConfig();
		
		
		this.session = Session.getDefaultInstance(properties, authenticator);
	}
	
	public void sendEmailToFindId(VUser vUser) throws MessagingException {
		MimeMessage msg = new MimeMessage(this.session);
		msg.setSentDate(new Date());
		msg.setFrom(new InternetAddress("ddingdongmj@gmail.com"));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(vUser.getEmail()));
		msg.setSubject("명지대학교 수강신청 - 계정 찾기","utf-8");
		msg.setText("안녕하세요 "+vUser.getName()+"님,\n 아이디 : "+ vUser.getUserId(),"utf-8");
		Transport.send(msg);
		
		
		
	}

	public void sendEmailToFindPwd(VUser vUser) throws MessagingException {
		MimeMessage msg = new MimeMessage(this.session);
		msg.setSentDate(new Date());
		msg.setFrom(new InternetAddress("ddingdongmj@gmail.com"));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(vUser.getEmail()));
		msg.setSubject("명지대학교 수강신청 - 계정 찾기","utf-8");
		msg.setText("안녕하세요 "+vUser.getName()+"님,\n 비밀번호 : "+ vUser.getUserpwd(),"utf-8");
		Transport.send(msg);
		
	}
}
