package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class AddEmployeeTest extends CommonMethods {
	@BeforeMethod
	public void openBrowserAndNavigate() {
		initialize();
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	
	@Test
	public void addEmployeePage() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		sleep(7);

		//LoginPageElements login = new LoginPageElements();
//
//		login.username.sendKeys(ConfigsReader.getProperty("username"));
//		login.password.sendKeys(ConfigsReader.getProperty("password"));
//		login.loginBtn.click();

		//DashboardPageElements board = new DashboardPageElements();

//		board.Pim.click();
//		jsClick(board.addEmployee);
//		
//		//AddEmployeePageElements emp1 = new AddEmployeePageElements();
//		
//		sendText(emp1.empFirstName, ConfigsReader.getProperty("employeeFirstname"));
//		sendText(emp1.empLastName, ConfigsReader.getProperty("employeeLastname"));
//		sendText(emp1.addPhoto, ConfigsReader.getProperty("filePath"));
//		waitAndClick(emp1.saveEmp);

	}
	
	
	}	


