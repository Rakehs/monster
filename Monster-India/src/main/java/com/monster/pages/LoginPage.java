package com.monster.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
	driver=ldriver;
	}
	@FindBy(how=How.XPATH, using="//*[@id='seekerLoginBtn']/a") WebElement seeker_login_Button;
	@FindBy(how=How.ID, using="signInName") WebElement signIn_Name;
	@FindBy(how=How.ID, using="password") WebElement password;
	@FindBy(how=How.ID, using="signInbtn") WebElement signIn_Button;
	
	public void enteringCredentials(String signInName, String upassword)
	{
		seeker_login_Button.click();
		signIn_Name.sendKeys(signInName);
		password.sendKeys(upassword);
		signIn_Button.click();
	}

}
