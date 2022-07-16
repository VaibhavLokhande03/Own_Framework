package pom.utility;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Library {

public static ExtentTest tast;
	
public static void custom_sendkeys(WebElement element,String Value,String Fieldname) {
	try {
		element.sendKeys(Value);
		tast.log(Status.PASS,Fieldname+ "= Value Sucessfully Send ="+Value);
	}catch(Exception e) {
		tast.log(Status.FAIL, e.getMessage());
	}
}

public static void custom_click(WebElement element,String Fieldname) {
	try {
		element.click();
		tast.log(Status.PASS, "Clicked Succesfully on = "+Fieldname);
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
}

}
