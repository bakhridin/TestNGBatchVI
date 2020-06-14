package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.CommonMethods;

public class sauceDemoLoginpage extends CommonMethods {
	@FindBy(id="user-name")
	public WebElement userNameTextBox;
	
	@FindBy(id="password")
	public WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@class='btn_action']")
	public WebElement loginButton;
	
	@FindBy(xpath="//div[text()='Products']")
	public WebElement headerText;
	
	@FindBy(xpath="//h3[contains(text(),'e')]")
	public WebElement errorMsg;
	
	
	public sauceDemoLoginpage() {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
