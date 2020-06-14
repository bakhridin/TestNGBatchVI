package com.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case started "+result.getName());
		
	}
	public void onTestSucces(ITestResult result) {
		System.out.println("Test Case passed "+result.getName());
		
	}
	
	public void onTestfailure(ITestResult result) {
		System.out.println("Test Case failed "+result.getName());
		
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case skipped  "+result.getName());
		
	}
	

}
