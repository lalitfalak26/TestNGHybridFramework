package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='content']//a[contains(text(),'Edit your account information')]")
	private WebElement EditYourInfo;
	
	public AccountPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getDisplayedEditYourInfoLink()
	{
		boolean displayStatus = EditYourInfo.isDisplayed();
		return displayStatus;
	}

	
	
}
