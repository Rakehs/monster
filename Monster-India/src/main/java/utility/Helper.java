package utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	//This method helps to take the screenshot
	public static String captureScreenShot(WebDriver driver)
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotPath=System.getProperty("user.dir")+"/Failed Screenshots/"+getCurrentDate()+".png";
		try {
			FileHandler.copy(src,new File(screenShotPath));
		} catch (Exception e) {
			System.out.println("can not take the screenshot");
		}
		return screenShotPath;
		
	}
	public static String getCurrentDate()
	{	
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
		
	}
	

}
