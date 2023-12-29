package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.AccountPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.Utilities;

public class LoginTest extends Base {
	
	public LoginTest()
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
		homepage.LoginClick();
	    
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test(dataProvider="LoginTestData")
	public void verifyLoginwithvalid(String email,String password) throws InterruptedException
	{
		
	    LoginPage loginpage = new LoginPage(driver);
	    loginpage.enterEmailAddress(email);
	    loginpage.enterPassword(password);
	    loginpage.clickLogin();
		AccountPage accountpage = new AccountPage(driver);
	    Assert.assertTrue(accountpage.getDisplayedEditYourInfoLink(),"Expected msg not macthed");
	 	
		
	}
	
	@DataProvider(name = "LoginTestData")
	public Object[][] supplyTestData()
	{
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		
		return data;
		
	}
	
}

