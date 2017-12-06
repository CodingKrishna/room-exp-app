package com.pioneercoders.roomexp.test;

public interface IsendMail {

	final String fromEmail = "javamail321@gmail.com"; // requires valid gmail id
	final String password = "bytecode"; // correct password for gmail id
	final String toEmail = null; // can be any email id

	// Properties props = null;
	// Authenticator auth = null;

	abstract void setSessionObject(final String fromEmail, final String password);

}
