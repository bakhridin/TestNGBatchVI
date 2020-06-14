package com.class03;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class GroupsDemo {
	@Test(dependsOnGroups = "smoke")
	public void test1() {
		System.out.println("test1");
	}
	
	
	@Test(groups="smoke")
	public void test2() {
		System.out.println("test2");
		//Assert.assertTrue(false);
		
		
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(false);
		soft.assertAll();
	}
	
	@Test(groups= {"regretion"})
	public void test3() {
		System.out.println("test3");
	}
	
	@Test(groups= {"smoke","regretion"})
	public void test4() {
		System.out.println("test4");
	}


}
