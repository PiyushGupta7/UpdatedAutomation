package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	//@FindBy(xpath="//select[@name='title']")
	//WebElement title;
	
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement save;
	
	@FindBy(xpath="//input[@name='nickname']")
	WebElement nickname;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void CreateNewContact(String v1,String fn,String ln) {
		
		Select s1=new Select(driver.findElement(By.name("title")));
		s1.selectByValue(v1);

		
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		save.click();
		
	}
	
	public void EnterNickName(String nk)
	{
		nickname.sendKeys(nk);
	}

}
