package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountMenu;
	
	@FindBy(linkText="Login")
	private WebElement Loginlink;
	
	@FindBy (linkText="Register")
	private WebElement RegisterLink;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void ClickonMyAccount()
	{
		myAccountMenu.click();
	}

	public void LoginClick()
	{
		Loginlink.click();
	}
	
	public void RegisterClick()
	{
		RegisterLink.click();
	}
}
