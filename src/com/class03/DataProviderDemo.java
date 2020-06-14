package com.class03;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class DataProviderDemo extends CommonMethods {
	
//	@Test
//	public void login() {
//		sendText(login.username, "Admin");
//		sendText(login.password, "Hum@nhrm123");
//		click(login.loginBtn);
//		boolean isDisplayed=dashboard.welcome.isDisplayed();
//		Assert.assertTrue(isDisplayed,"Welcome msg is not displayed");
//		
//	}
	
	@Test
	public void login1(String username,String password,int age) {
	
		
		sendText(login.username, username);
		sendText(login.password, password);
		System.out.println(age);
		click(login.loginBtn);
		
		boolean isDisplayed=dashboard.welcome.isDisplayed();
		Assert.assertTrue(isDisplayed,"Welcome msg is not displayed");
		
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data={
				           {"Admin","Hum@nhrm123",25},
				           {"Syntax","Syntax123!",24},
				           {"SyntaxUser","Syntax123",22} 
				          };
		return data;
	}
	

}
