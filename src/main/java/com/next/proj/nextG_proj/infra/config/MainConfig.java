package com.next.proj.nextG_proj.infra.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.next.proj.nextG_proj.infra.Web.WebDriverType;

public class MainConfig {

	public static WebDriverType webDriverType;
	public static boolean closeBrowserTestEnd ; //To close the browser after the test, change the closeBrowserTestEnd to "True".
	public static int webDriverImplicitWaitInSeconds;
	public static String baseUrl;
	public static String username;
	public static String password;
	public static String oldPassword;
	public static String newPassword;
	
	
	public static void initFromFile(String filePath) throws IOException {

		
		Properties prop = new Properties();
		InputStream input = new FileInputStream(filePath);

		
		prop.load(input);
		
	
		webDriverType = WebDriverType.valueOf(prop.getProperty("webDriverType"));
		closeBrowserTestEnd = Boolean.parseBoolean(prop.getProperty("closeBrowserTestEnd"));
		webDriverImplicitWaitInSeconds = Integer.parseInt(prop.getProperty("webDriverImplicitWaitInSeconds"));
		baseUrl = prop.getProperty("baseUrl");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		newPassword = prop.getProperty("newPassword");
		
		input.close();
	}
	
	public static String setUpdatedPassword(String filePath, String updatePassword) throws IOException {
		FileInputStream in = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(in);
		in.close();
		FileOutputStream out = new FileOutputStream(filePath); 
		
		
		String[] str = updatePassword.split("@");
		String passNum = str[1];
		int passNumInt = Integer.parseInt(passNum);
		int newPassNum = passNumInt+1;
		String newPassNumString = Integer.toString(newPassNum); 
		String newUpdatedPassword = "galina@"+newPassNumString;
		
		
		prop.setProperty("password", updatePassword);
		prop.setProperty("newPassword", newUpdatedPassword);
		
		prop.store(out, null);
		out.close();
		
		return newUpdatedPassword;
	}
	
	
}
