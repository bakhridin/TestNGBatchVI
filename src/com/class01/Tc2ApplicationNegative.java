package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class Tc2ApplicationNegative extends CommonMethods {
	
	@BeforeMethod
	private void openBrowser() {
		setUp();
	}
	
	@AfterMethod
	private void closeBrowser() {
		
		sleep(2);
		tearDown();
	
		
	}
	
	@Test
	private void negativeLogin() {
		String text1="Password cannot be empty";
	WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		
		sendText(username, ConfigsReader.getProperty("username"));
		
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		String text=driver.findElement(By.id("spanMessage")).getText();
		
		if(text.equals(text1)) {
			System.out.println("Enter password");
		}else {
			System.out.println("Password is empty");
		}
		
	}
	
	

}
