package com.pioneercoders.roomexp.mail;

import com.pioneercoders.roomexp.common.IConfig;

public interface IMail extends IConfig{

	public void sendEmail(String toEmail);
}
