package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login' and @type='submit']")
	WebElement loginBtn;
	
	
	@FindBy(xpath="//td[@class='logo_text']")
	WebElement title;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void HomePageLogin(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}
	
	
	

}
