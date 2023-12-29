package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {
	
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement firstName;
	
	@FindBy(id="input-lastname")
	private WebElement lastName;
	
	@FindBy(id="input-email")
	private WebElement emailAddress;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneNo;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(name="agree")
	private WebElement agreeCheckbox;
	
	public RegisterAccountPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String firstname)
	{
		firstName.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname)
	{
		lastName.sendKeys(lastname);
	}
	
	public void enteremailAddress(String emailAdd)
	{
		emailAddress.sendKeys(emailAdd);
	}
	
	public void entertelephoneNo(String telephone)
	{
		telephoneNo.sendKeys(telephone);
	}
	
	public void enterpassword(String passw)
	{
		password.sendKeys(passw);
	}
	
	public void enterConfirmpassword(String confirmPassw)
	{
		confirmPassword.sendKeys(confirmPassw);
	}
	
	public void ClickonAgreeCheckBox()
	{
		agreeCheckbox.click();
	}
}
