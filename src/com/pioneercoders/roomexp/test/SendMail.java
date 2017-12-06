package com.pioneercoders.roomexp.test;

public abstract class SendMail implements IsendMail {

	public static void main(String[] args) {

		String subject = "Last Month Room rent";
		String body = "Hi Room_Mates,/n/t/t Kindly Find the Attachment";
		IsendMail isendMail = new EmailConfiguration();
		isendMail.setSessionObject(fromEmail, password);
		EmailUtil.sendEmail(subject, body);

	}

}
