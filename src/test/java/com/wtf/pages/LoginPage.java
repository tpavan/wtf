package com.wtf.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.wtf.domains.Login;

public class LoginPage extends BasePage {
	
	@FindBy(how =How.ID, using="")
	WebElement userInpt;
	
	@FindBy(how =How.ID, using="")
	WebElement passwordInpt;

	@FindBy(how =How.ID, using="")
	WebElement submitBtn;
	
	public void loginTo(Login loginData){
		enterText(userInpt, loginData.username);
		enterText(passwordInpt, loginData.password);
		submitBtn.click();
	}
}
