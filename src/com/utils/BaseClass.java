package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	
	public static  WebDriver driver;
	     
	  @BeforeMethod// to make this method run before every @Test method
	 public static WebDriver setUp() {
		 
		 ConfigsReader.readProperties(Constans.CONFIGURATIONS_FILEPATH);
		 System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		 
		 switch(ConfigsReader.getProperty("browser").toLowerCase()) {
		 
		 case "chrome":
			 System.setProperty("webdriver.chrome.driver", Constans.CHROME_DRIVER_PATH);
			    driver=new ChromeDriver();
			    break;
			    
		 case "firefox":
			 System.setProperty("webdriver.gecko.driver", Constans.GECKO_DRIVER_PATH);
			 driver=new FirefoxDriver();
			 break;
			 default:
				 throw new RuntimeException("Browser is not supported");
			   
			   
		 
		 }
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Constans.IMPLISIT_WAIT_TIME, TimeUnit.SECONDS);
		 driver.get(ConfigsReader.getProperty("url"));
		 //initialize all page objects as part of setup
		 PageInitializer.initialize();
		 return driver;
		 
	 }
	  @AfterMethod//to make this method to run after every @Test method
	 public static void tearDown() {
		 if(driver!=null) {
			 CommonMethods.sleep(3);
			 driver.quit();
		 }
	 }
         
}
