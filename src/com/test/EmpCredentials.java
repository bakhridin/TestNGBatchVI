package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.addEmplopyeePage;
import com.utils.CommonMethods;
import com.utils.ConfigsReader;

public class EmpCredentials extends CommonMethods{
	
	@Test
	public void addEmoCreden() {
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		sendText(employeePage.firstName, "Bredd");
		sendText(employeePage.lastName, "Pitt");
		click(employeePage.credentialButton);
		
		sendText(employeePage.credenUserName, "Bredd1234");
		sendText(employeePage.credenUserPasswor, "piTT1234!?");
		sendText(employeePage.confirmCredenPassword, "piTT1234!?");
		takeScreenshots("screenshots/HRMS/addEmp.png");
		
		
	}
	
	
	@Test
	public void requiredFiledDisplay() {
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		//sendText(employeePage.firstName, "Bredd");
		//sendText(employeePage.lastName, "Pitt");
		click(employeePage.credentialButton);
		
		sendText(employeePage.credenUserName, "Bredd1234");
		sendText(employeePage.credenUserPasswor, "piTT1234!?");
		sendText(employeePage.confirmCredenPassword, "piTT1234!?");
		click(employeePage.saveButton);
		
		String actualValue="Required";
		
		Assert.assertEquals(employeePage.nameRequiredMsg.getText(),actualValue );
		Assert.assertEquals(employeePage.lastNameRequiredMsg.getText(), actualValue);
		takeScreenshots("screenshots/HRMS/requiredAddEmp.png");
		
		
		
		
		
		
		
		
		
		
	}

}
