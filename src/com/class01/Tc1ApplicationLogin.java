package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.ConfigMethodArguments;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class Tc1ApplicationLogin extends CommonMethods{
	
	@BeforeMethod
	private void openAndNavigate() {
		setUp();

	}
	
	@AfterMethod
	private void quotBrowser() {
		tearDown();

	}
	
	@Test
	private void validLogin() {
		
		WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		
		sendText(username, ConfigsReader.getProperty("username"));
		
		WebElement password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
		
		sendText(password, ConfigsReader.getProperty("password"));
		
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		WebElement verifyLogo=driver.findElement(By.xpath("//div[@id='branding']/a/img"));
		
		boolean displayed= verifyLogo.isDisplayed();
		
		if(displayed) {
			System.out.println("Logo is displayed");
			
		}else {
			System.out.println("Logo is displayed");
		}
		sleep(2);
		
	}

}
