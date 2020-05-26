package com.utils;



import com.pages.DashBoardPageElements;

import com.pages.LoginPageElements;
import com.pages.PersonalDetailsPageElements;
import com.pages.addEmplopyeePage;

public class PageInitializer extends BaseClass {
	
	public static LoginPageElements login;
	public static DashBoardPageElements dashboard;
	public static PersonalDetailsPageElements pdetails;
	public static addEmplopyeePage employeePage;
	
	
	public static void initialize() {
		 login=new LoginPageElements();
		 dashboard=new DashBoardPageElements();
		 pdetails=new PersonalDetailsPageElements();
		 employeePage = new addEmplopyeePage();
	}

}
