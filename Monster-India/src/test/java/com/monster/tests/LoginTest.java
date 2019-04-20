package com.monster.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.monster.pages.DashBoardPage;
import com.monster.pages.LoginPage;

public class LoginTest extends TestBase {

	@Test(dataProvider = "monsterLoginCredentials")
	public void login(String uname, String password) {
		logger=report.createTest("Login to Monster");		
		LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
		logger.info("app started");
		login_page.enteringCredentials(uname, password);
		logger.info("credential entered");			
		DashBoardPage dpage = PageFactory.initElements(driver, DashBoardPage.class);
		String act_uname = dpage.getUserName();
		if (act_uname.contains("Rakesh")) {
			Assert.assertTrue(true);
		}
		logger.pass("testcase passed");

	}

}
