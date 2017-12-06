package com.pioneercoders.roomexp.test;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

final public class EmailConfiguration implements IsendMail {

	public static Session session;

	public void setSessionObject(final String fromEmail, final String password) {

		Properties props = new Properties(); // TLSEmail Start
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
		props.put("mail.smtp.port", "587"); // TLS Port
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		// create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		session = Session.getInstance(props, auth);
	}

	public Session getSessionObject() {

		// System.out.println("session:: "+session);
		return session;

	}

}
