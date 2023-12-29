package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.qa.utils.Utilities;

public class Base {
	
	WebDriver driver;
	public Properties prop; 
	public Properties dataprop;
	
	public Base()
	{
		prop = new Properties();
		File propfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\properties\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(propfile);
			prop.load(fis);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dataprop = new Properties();
		File datapropfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\testdata\\testdata.properties");
		try {
			FileInputStream datafis = new FileInputStream(datapropfile);
			prop.load(datafis);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public WebDriver initializebrowserandappurl(String BrowserName)
	{
		
		if(BrowserName.equals("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		
			
		}
		else if(BrowserName.equals("Edge"))
		{
			EdgeOptions ops = new EdgeOptions();
	    	ops.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(ops);
		}
		
		
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
	    driver.get(prop.getProperty("url"));
	    return driver;
	}

	
	
	
}
