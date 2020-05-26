package com.class01;

import org.testng.annotations.*;

public class DifferentAnnotations {
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
		
	}
	
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
		
	}
	
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
		
	}
	
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	
	
	@Test
	public void test() {
		
		System.out.println("Actual Test is running");
		
	}

}
