package com.wtf.workflows;

import com.wtf.domains.Login;
import com.wtf.pages.BasePage;
import com.wtf.pages.LoginPage;

public class LoginWorkFlow extends BasePage{
	
	public void userLogin(Login T){
		LoginPage page = BasePage.initPages(LoginPage.class);
		page.loginTo(T);
	}
}
