package com.monster.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashBoardPage {
	WebDriver driver;
	public DashBoardPage(WebDriver ldriver)
	{
		driver=ldriver;
	}
	@FindBy(how=How.XPATH, using="//div[@class='username']/h3") WebElement userNameDashboard;
	//getting username from dashboard
	public String getUserName()
	{
		 return userNameDashboard.getText();
		 
	}

}
