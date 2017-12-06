package com.pioneercoders.roomexp.common;

import com.pioneercoders.roomexp.mail.MailManaer;
import com.pioneercoders.roomexp.xls.XLExpenditureImpl;
import com.pioneercoders.roomexp.xml.XMLManagerImpl;

public class AppManager {

	private static final AppManager appManager = new AppManager();
	
	private AppManager() {

	}

	public static AppManager getInstance() {
		return appManager;
	}

	public void addRoommate(String name, String email, String mobile) {
		XMLManagerImpl.getInstance().addRoommate(name, email, mobile);
	}

	public void removeRoommate(String email) {
		XMLManagerImpl.getInstance().removeRoommate(email);
	}

	public void addExpenditure(String name, String description, String amount){
		XLExpenditureImpl.getInstance().insertExpenditure(name, description, amount);
	}

	public Object[][] getExpenditureSheet(){
		return XLExpenditureImpl.getInstance().getExpenditureSheet();
	}
	
	public void sendEmail() {
		String toEmailId = XMLManagerImpl.getInstance().getRoomatesEmailList();
		MailManaer.getInstance().sendEmail(toEmailId);
	}
	
	public void getCalculatedSheet(){
		//need impl
	}
}
