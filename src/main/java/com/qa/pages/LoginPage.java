package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy (id="input-email")
	private WebElement emailID;

	@FindBy (id="input-password")
	private WebElement password;
	
	@FindBy (xpath="//input[@value='Login']")
	private WebElement LoginBtn;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    public void enterEmailAddress(String emailText)
    {
    	emailID.sendKeys(emailText);
    }
    
    public void enterPassword(String passwordText)
    {
    	password.sendKeys(passwordText);
    }

    public void clickLogin()
    {
    	LoginBtn.click();
    	
    }
}


