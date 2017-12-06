package com.pioneercoders.roomexp.mail;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.pioneercoders.roomexp.common.ReadPropertiesFile;

public class MailManaer implements IMail {

	private static final MailManaer mailManaer= new MailManaer();
	private MailManaer(){
		
	}
	public static MailManaer getInstance(){
		return mailManaer;
	}
	
	public Session getSssion() {

		String host = ReadPropertiesFile.getProperty("mail.smtp.host");
		String port = ReadPropertiesFile.getProperty("mail.smtp.port");

		Properties props = new Properties(); // TLSEmail Start
		props.put("mail.smtp.host", host); // SMTP Host
		props.put("mail.smtp.port", port); // TLS Port
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		// create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				String fromEmail = ReadPropertiesFile.getProperty("fromMailId");
				String pwd = ReadPropertiesFile.getProperty("password");
				return new PasswordAuthentication(fromEmail, pwd);
			}
		};
		return Session.getInstance(props, auth);
	}

	@Override
	public void sendEmail(String toEmailId) {

		String fromEmail = ReadPropertiesFile.getProperty("fromMailId");
		String subject = ReadPropertiesFile.getProperty("megSubject");
		String body = ReadPropertiesFile.getProperty("msgBody");
		String ccMailId = ReadPropertiesFile.getProperty("ccMailId");
		try {
			MimeMessage mimeMessage = new MimeMessage(getSssion());
			// set message headers
			setHeaders(mimeMessage);
			mimeMessage.setFrom(new InternetAddress(fromEmail, "Room_Rent"));
			mimeMessage.setReplyTo(InternetAddress.parse(fromEmail, false));
			mimeMessage.setSubject(subject, "UTF-8");

			Multipart multipart = addAttachment(body);
			// Send the complete message parts
			mimeMessage.setContent(multipart);
			// Send message
			mimeMessage.setSentDate(new Date());

			mimeMessage.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toEmailId, false));
			mimeMessage.setRecipient(Message.RecipientType.CC,
					new InternetAddress(ccMailId));

			Transport.send(mimeMessage);

			System.out.println("EMail Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Multipart addAttachment(String body) {
		// Create the message part
		BodyPart messageBodyPart = new MimeBodyPart();
		// Create a multipart message
		Multipart multipart = new MimeMultipart();

		try {
			// Fill the message
			messageBodyPart.setText(body);
			// Set text message part
			multipart.addBodyPart(messageBodyPart);
			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(XL_FILE_NAME);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(XL_FILE_NAME);

			multipart.addBodyPart(messageBodyPart);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return multipart;

	}

	private void setHeaders(MimeMessage mimeMessage) throws MessagingException {
		mimeMessage.addHeader("Content-type", "text/HTML; charset=UTF-8");
		mimeMessage.addHeader("format", "flowed");
		mimeMessage.addHeader("Content-Transfer-Encoding", "8bit");
	}

	
}
