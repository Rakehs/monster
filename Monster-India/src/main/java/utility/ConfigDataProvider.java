package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	public ConfigDataProvider()
	{
		File src=new File("E:\\eclipse\\MyWorkSpace\\Monster-India\\src\\main\\java\\Configuration\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}  catch (Exception e) {
			System.out.println("not able to load config file");
		}
		
	}
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	public String getUrl()
	{
		return pro.getProperty("qaUrl");
	}
	public String getValue(String key)
	{
		return pro.getProperty(key);
	}

	
	}


	