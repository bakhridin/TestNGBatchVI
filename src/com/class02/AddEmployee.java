package com.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.DashBoardPageElements;
import com.pages.LoginPageElements;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

/*
 * 
 */





public class AddEmployee extends CommonMethods{
  
  @BeforeMethod
  public void openBrowser() {
	  setUp();
	  LoginPageElements loginElement =new LoginPageElements();
	  
	        boolean logoDisplayed=loginElement.logo.isDisplayed();
	        logoDisplayed=true;
	        
	 // Assert.assertTrue(logoDisplayed); //using(hard) assertion   
	        
	        SoftAssert soft=new SoftAssert();
	        soft.assertTrue(logoDisplayed);
	  
	  
	    sendText(loginElement.username, ConfigsReader.getProperty("username"));
	    sendText(loginElement.password,ConfigsReader.getProperty("password"));
	    click(loginElement.loginBtn);
	    
	    soft.assertAll();
	  
  }

  @AfterMethod
  public void closeBrowser() {
	  sleep(2);
	  tearDown();
  }
  
  @Test
  public void addEmployee() {
	  DashBoardPageElements dashbord=new DashBoardPageElements();
	  
	  moveHoverToElement(dashbord.PIM);
	  
	  click(dashbord.addEmp);
	 
	  Assert.assertTrue(dashbord.nameDisplayed.isDisplayed(),"Full name is NOT displayed");
	  
	  Assert.assertTrue(dashbord.employIdDisplayed.isDisplayed());
	  
	  Assert.assertTrue(dashbord.photoDisplayed.isDisplayed());
	  
	  sendText(dashbord.firstName,ConfigsReader.getProperty("firstName"));
	  
	  sendText(dashbord.lastName, ConfigsReader.getProperty("lastName"));
	  
	  sendText(dashbord.uploadPhoto, "/Users/macbook/Desktop/image.jpeg");
	  
	  click(dashbord.saveButton);
	  
	  String profile="Bredd Pitt";
	  Assert.assertEquals(dashbord.profilePic.getText(),profile,"Profile incorrect");
	  
	  
	  
	  
	  
	  
	  
	  
  }

}
