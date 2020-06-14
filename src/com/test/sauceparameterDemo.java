package com.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utils.CommonMethods;

public class sauceparameterDemo extends CommonMethods {
	
	
	@Parameters({"username","password"})
	@Test
	public void login(String username,String password) {
		
		
		
		sendText(sauceDemoPage.userNameTextBox, username);
		sendText(sauceDemoPage.passwordTextBox, password);
		click(sauceDemoPage.loginButton);
		sleep(3);
		
	}

}
