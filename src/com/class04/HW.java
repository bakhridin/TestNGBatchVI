package com.class04;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;
import com.utils.ExcelUtility;

public class HW  extends CommonMethods{
	
	@Test(dataProvider = "getData2FromExcel",groups = {"regression","addEmp","HomeWork"})
	public void test(String firstName, String lastName, String username, String password) {
		// System.out.println(firstName + " " + lastName + " " + username + " " +
		// password);

		// login into HRMS
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

		// navigate to Add Employee page
		dashboard.navigateToAddEmployee();
		sleep(1);

		// add employee information
		sendText(employeePage.firstName, firstName);
		sendText(employeePage.lastName, lastName);
		// get EmployeeID
		String expectedEmpId = employeePage.employeeId.getAttribute("value");

		// click on Create Login Details
		click(employeePage.credentialButton);
		sleep(1);
		sendText(employeePage.credenUserName, username);
		sendText(employeePage.credenUserPasswor, password);
		sendText(employeePage.confirmCredenPassword, password);
		sleep(1);
		//jsClick(employeePage.credentialButton);
//		sleep(1);
//		// validation
//		waitForVisibility(pdetails.lblPersonalDetails);
//		String actualEmpId = pdetails.employeeId.getAttribute("value");
//		Assert.assertEquals(actualEmpId, expectedEmpId, "Employee ID did not match!");
//
//		// take screeshot
//		takeScreenshots(firstName + "_" + lastName);
	
	}
	@DataProvider(name = "userData")
	public Object[][] getData() {
		Object[][] data = {
				{ "Raj", "Capoor", "raj123", "AmirKhan_@123" }, 
				{ "John", "Smith", "john123", "AmirKhan_@123" }, 
				{ "Mary", "Ann", "mary123", "AmirKhan_@123" }, 
				{ "Rohani", "Sakhi", "rohani123", "AmirKhan_@123" },
				{ "Ali", "Tarlaci", "ali123", "AmirKhan_@123" },
		};
		return data;
	
	
	}
	
	@DataProvider(name = "getData2FromExcel")
	public Object[][] getData2() {
		Object[][] getData2=ExcelUtility.getDataFromExcel(System.getProperty("user.dir")+"/excel/file.xlsx", "Sheet2");
		
		return getData2;
	}

}

