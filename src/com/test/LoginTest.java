package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class LoginTest extends CommonMethods {
	
	@Test
	public void validAdminLogin() {
		//LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		//DashboardPageElements dashboard = new DashboardPageElements();
		String expectedUser="Welcome Admin";
		String actualUser=dashboard.welcome.getText();
		Assert.assertEquals(actualUser, expectedUser, "Admin is NOT Logged in");
		Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
	}
	
	@Test
	public void invalidPasswordLogin() {
		//LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "uiuguig");
		click(login.loginBtn);
		
		String expected="Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}

	@Test(enabled=true)
	public void emptyUsernameLogin() {
		//LoginPageElements login = new LoginPageElements();
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		String expected="Username cannot be empty";
		
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}

//	@BeforeMethod
//	public void openBrowserAndNavigate() {
//		initialize();
//		setUp();
//	}
//
//	@AfterMethod
//	public void quitBrowser() {
//		sleep(3);
//		tearDown();
//	}
//
//	@Test
//	public void validAdminLogin() {
//		
//
//		sendText(login.username, ConfigsReader.getProperty("username"));
//		sendText(login.password, ConfigsReader.getProperty("password"));
//		click(login.loginBtn);
//		
//		
//		
//		String expectUser="Welcome Admin";
//		String actualUser=dashboard.welcome.getText();
//		Assert.assertEquals(actualUser, expectUser,"Admin is Not Logged in");
//		Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
//		
//		
//
//	}
//	
//	@Test
//	public void invalidPasswordLogin() {
//		
//		
//		sendText(login.username, ConfigsReader.getProperty("username"));
//		sendText(login.password, ConfigsReader.getProperty("uiuguig"));
//		click(login.loginBtn);
//		
//		String expected="Invalid credentials";
//		
//		Assert.assertEquals(login.errorMsg.getText(), expected,"Error massage text is not matched");
//		
//		
//	}
//	
//	@Test
//	public void emptyUsernameLogin() {
//		
//		//LoginPageElements loginElement = new LoginPageElements();
//		sendText(login.password, ConfigsReader.getProperty("password"));
//		click(login.loginBtn);
//		
//		String expected="Username cannot be empty";
//		Assert.assertEquals(login.errorMsg.getText(), expected,"Error message not matched");
//	}

}
