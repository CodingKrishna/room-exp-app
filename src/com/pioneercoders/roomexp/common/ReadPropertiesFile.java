package com.pioneercoders.roomexp.common;

import java.io.IOException;

public class ReadPropertiesFile {
    static String filePath="";
    static java.util.Properties p;
    static {
    	filePath="";
    	p = new java.util.Properties();
    	//p.load(new java.io.FileInputStream(new File(filepath)));
    	ClassLoader loader = ReadPropertiesFile.class.getClassLoader();
    	try {
			p.load(loader.getResourceAsStream("com/pioneercoders/roomexp/common/MessageResources.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	public static String getProperty(String key)
	{
		return p.getProperty(key);
	}
	
	public static void main(String[] args) {
		//ReadPropertiesFile rp = new ReadPropertiesFile();
		//String host = ReadPropertiesFile.getProperty("mail.smtp.host");
		//rp.getProperty("db_user");
	}
}
