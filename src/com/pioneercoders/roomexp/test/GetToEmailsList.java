package com.pioneercoders.roomexp.test;

import java.util.List;

public class GetToEmailsList {
	
	public String getToEmail() {
		
		GetEmailFromXML getEmailFromXML = new GetEmailFromXML();
		
		List<String> slist = GetEmailFromXML.getEmailList();
		StringBuilder rString = new StringBuilder();
		String seperator = ", ";
		int listSize = 1;
		for (String each : slist) {
		    rString.append(each);
		    if(listSize<slist.size()){
		    	rString.append(seperator);
		    }
		    listSize++;
		}
		
		//System.out.println("stbuild: "+rString);
		return rString.toString();
	
	}
	
	public static void main(String[] args) {
		GetToEmailsList gt = new GetToEmailsList();
		//gt.getToEmail();
		System.out.println("Email:: "+gt.getToEmail());
	}

}
