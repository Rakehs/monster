package com.monster.tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.BrowserFactory;
import utility.ConfigDataProvider;
import utility.ExcelReader;
import utility.Helper;

public class TestBase {
	public WebDriver driver;
	public ConfigDataProvider config;
	public ExcelReader reader;
	public ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void setUpSuite()
	{
		config=new ConfigDataProvider();
		reader = new ExcelReader(config.getValue("excelPath"));
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/ExtentReports/"+Helper.getCurrentDate()+"monsterLogin.html"));
		report=new ExtentReports();
		report.attachReporter(extent);
	}
	@BeforeMethod
	public void startUp()
	{
		//initializing webdriver
		driver=BrowserFactory.startBrowser(config.getBrowser(), config.getUrl());
	}
	@AfterMethod()
	public void failedScreenshot(ITestResult result) throws IOException 
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		report.flush();		
		BrowserFactory.quitTheBrowser();		
	}	
	@DataProvider(name = "monsterLoginCredentials")
	public Object[][] testData() {		
		int noOfRows = reader.getRowNo(0);
		noOfRows = noOfRows + 1;		
		Object[][] data = new Object[noOfRows][2];
		for (int i = 0; i < noOfRows; i++) {
			data[i][0] = reader.getData(0, i, 0);
			data[i][1] = reader.getData(0, i, 1);
		}

		return data;
	}


}
