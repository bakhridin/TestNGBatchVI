package com.class03;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class DataProviderHW extends CommonMethods {
	@Test(dataProvider = "getData",groups = "regression")
	public void employeeAdd(String firstName, String lastName,String username,String password,String confirmPassword,String screenShot) {
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		
		employeePage.navigateToAddEmployee();
		sendText(employeePage.firstName, firstName);
		sendText(employeePage.lastName, lastName);
		click(employeePage.credentialButton);
		
		sendText(employeePage.credenUserName, username);
		sendText(employeePage.credenUserPasswor, password);
		sendText(employeePage.confirmCredenPassword, confirmPassword);
		click(employeePage.saveButton);
		String expectedValue=firstName+" "+lastName;
		Assert.assertEquals(employeePage.profilePic.getText(), expectedValue);
		sleep(2);
		takeScreenshots(screenShot);
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data= {
				{"Elion","Lemenay","ELION","Elion@!$Lemenay123","lion@!$Lemenay123","screenshots/employee/imag1.png"},
				{"Faridun","Rasulov","FARIDUN","FARIDUN!@$123Ras","FARIDUN!@$123Ras","screenshots/employee/imag2.png"},
				{"Abdul","Nabiev","ABDUL","ABDUL!@#123Nabiev","ABDUL!@#123Nabiev","screenshots/employee/imag3.png"},
				{"Jamshed","Umarov","James","Jam!@#123Uma","Jam!@#123Uma","screenshots/employee/imag4.png"},
				{"Hamro","Kurbanov","Kurban","Hamro!@#123Kurb","Hamro!@#123Kurb","screenshots/employee/imag5.png"}
		};
		return data;
		
	}
	
	

}
