package com.class02;

import org.testng.annotations.Test;

import com.utils.CommonMethods;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class TaskFromReviewClass extends CommonMethods {
	
	
	
	
 
  @BeforeMethod
  public void openBrowser() {
	  
	  setUp();
  }

  @AfterMethod
  public void closeBrowser() {
	  
	  tearDown();
  }
  
  @Test
  public void verifyProduct() {
	  
	  driver.findElement(By.id("user-name")).sendKeys("standard_user");
	  
	  sleep(1);
	  
	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  sleep(1);
	  
	  driver.findElement(By.xpath("//input[@class='btn_action']")).click();
	  
	  
	  sleep(2);
	  
	  WebElement logoEl=driver.findElement(By.xpath("//div[text()='Products']"));
	  
	  if(logoEl.isEnabled()) {
		  
		  System.out.println("Logo is enabled");
		  
	  }else {
		  System.out.println("Logo is not enabled");
		  
	  }
	  
	  
	  
	  
  }

}
