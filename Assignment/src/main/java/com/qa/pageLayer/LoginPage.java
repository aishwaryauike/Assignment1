package com.qa.pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class LoginPage extends TestBase{

	public LoginPage ()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;
	
	public void enterUserName(String UserName)
	{
		username.sendKeys(UserName);
	}
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	public void enterPassword(String Password)
	{
		password.sendKeys(Password);
	}
	
	@FindBy(xpath = "//button[@id='log-in']")
	private WebElement login_button;
	
	public void clickOnLoginButton()
	{
		login_button.click();
	}
}
 