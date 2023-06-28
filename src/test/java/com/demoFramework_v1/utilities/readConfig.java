package com.demoFramework_v1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
	
	Properties pro;
	
	//constructor
	public readConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {		
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			}
		catch(Exception e) {
				System.out.println("Exception is" + e.getMessage());
		    }
	}
	
	public String getAppURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getuser() {
		String user = pro.getProperty("username");
		return user;
	}
	
	public String getpass() {
		String pass = pro.getProperty("password");
		return pass;
	}
	
	public String getChromeDriver() {
		String chromeDriverPath = pro.getProperty("chromeDriver");
		return chromeDriverPath;
	}
	
	public String getMicrosoftDriver() {
		String microsoftDriverPath = pro.getProperty("microsoftDriver");
		return microsoftDriverPath;
	}


}
