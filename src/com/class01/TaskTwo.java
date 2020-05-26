package com.class01;


import org.testng.annotations.*;


public class TaskTwo {
	
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	
	@Test
	public void task1() {
		System.out.println("Test 1");
	}
	
	@Test
	public void task2() {
		System.out.println("Test 2");
	}
	
	@Test
	public void task3() {
		System.out.println("Test 3");
	}

}
