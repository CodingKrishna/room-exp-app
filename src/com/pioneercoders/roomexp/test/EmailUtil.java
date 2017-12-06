package com.pioneercoders.roomexp.test;

import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public abstract class EmailUtil implements IsendMail {

	public static void sendEmail(String subject, String body) {
		try {

			MimeMessage mimeMessage = new MimeMessage(
					EmailConfiguration.session);
			// set message headers
			mimeMessage.addHeader("Content-type", "text/HTML; charset=UTF-8");
			mimeMessage.addHeader("format", "flowed");
			mimeMessage.addHeader("Content-Transfer-Encoding", "8bit");

			mimeMessage.setFrom(new InternetAddress(fromEmail, "Room_Rent"));

			mimeMessage.setReplyTo(InternetAddress.parse(fromEmail, false));

			mimeMessage.setSubject(subject, "UTF-8");

			// mimeMessage.setText(body, "UTF-8");

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message
			messageBodyPart.setText(body);

			// Create a multipart message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			
			// String filename ="C:/Users/Jakesh/Downloads/designPatterns.docx";
			String filename = "C://Users/Jakesh/Downloads/November-2014.xlsx";
			
			DataSource source = new FileDataSource(filename);
			
			messageBodyPart.setDataHandler(new DataHandler(source));
			
			messageBodyPart.setFileName(filename);
			
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			mimeMessage.setContent(multipart);

			// Send message
			mimeMessage.setSentDate(new Date());

			mimeMessage.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(new GetToEmailsList().getToEmail(), false));
			mimeMessage.setRecipient(Message.RecipientType.CC,
					new InternetAddress("javajakesh@gmail.com"));
			System.out.println("Message is ready");

			Transport.send(mimeMessage);

			System.out.println("EMail Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
