package com.test;

//import org.apache.commons.collections4.Get;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pom.pageobject.Login_Page_Pom;
import pom.utility.Base_Class;
import pom.utility.Library;

public class Verify_Login_page extends Base_Class {

	
	
	
	@Test
	public void Verify_login_with_valid_credentials() {
		Login_Page_Pom login=PageFactory.initElements(driver, Login_Page_Pom.class);
		
		Library.custom_sendkeys(login.gettxt_emailid(),excel.getStringData("Sheet1", 0, 0), "Email_Id");
		Library.custom_sendkeys(login.gettxt_password(),excel.getStringData("Sheet1", 0, 1), "Password");
		Library.custom_click(login.getbtn_login(), "Login_Button");
	}
}
