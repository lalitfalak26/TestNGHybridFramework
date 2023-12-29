package com.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.HomePage;
import com.qa.pages.RegisterAccountPage;
import com.qa.utils.Utilities;


public class RegisterTest extends Base {
	
	public RegisterTest()
	{
		super();
	}
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup()
	{
		driver = initializebrowserandappurl(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.ClickonMyAccount();
		homepage.RegisterClick();
		
	    
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test(dataProvider="Registerdetails")
	public void registerwithmandatory(String fname,String lname,String email,String telephone,String passw,String confirmPassw)
	
	{
		
	    RegisterAccountPage regaccountpage = new RegisterAccountPage(driver);
	    regaccountpage.enterFirstName(fname);
	    regaccountpage.enterLastName(lname);
	    regaccountpage.enteremailAddress(email);
	    regaccountpage.entertelephoneNo(telephone);
	    regaccountpage.enterpassword(passw);
	    regaccountpage.enterConfirmpassword(confirmPassw);
	    regaccountpage.ClickonAgreeCheckBox();
	    
	 	        
	    
	}

	
	@DataProvider(name = "Registerdetails")
	public Object[][] supplyTestData()
	{
		Object[][] data = Utilities.getTestDataFromExcel("Register");
		
		return data;
		
	}
}
