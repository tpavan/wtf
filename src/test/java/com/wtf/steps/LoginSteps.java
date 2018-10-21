package com.wtf.steps;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.wtf.domains.Login;
import com.wtf.utils.JsonUtils;

public class LoginSteps extends BaseFlows {

	Logger logger = Logger.getLogger(LoginSteps.class);
	
	@Test
	public void loginApp(){		
		Login loginData = JsonUtils.initTestData(Login.class);
		logger.info("Login app test");
		loginFlow.userLogin(loginData);
		Reporter.log("Reporteer");
	}
}
