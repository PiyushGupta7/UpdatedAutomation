package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.sun.corba.se.spi.orbutil.fsm.Action;

public class HomePage extends TestBase {

	

	@FindBy(xpath="//td[contains(text(),'User: piyush Gupta')]")
	WebElement UserNameLabel;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contacts;
	
	@FindBy(xpath="//select[@name='search_target']")
	WebElement dropdown;
	
	@FindBy(name="slctMonth")
	WebElement dropdown1;
	
	@FindBy(name="slctYear")
	WebElement dropdown2;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyHomePageTitle(){
		return driver.getTitle();
		
	}
	
	public void ClickOnContacts() {
		
		contacts.click();
	}
	
	public void dd(String d1) {
		Select s1= new Select(dropdown);
		s1.selectByValue(d1);
	}
	public void ClickOnNewContactLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contacts).build().perform();
		driver.findElement(By.xpath("//a[@title='New Contact']")).click();
	}
	public void calendar(String month,String year,String date) throws InterruptedException
	{
		
	Select s2=new Select(dropdown1);
	s2.selectByVisibleText(month);
	Thread.sleep(5000);
	Select s3=new Select(dropdown2);
	s3.selectByVisibleText(year);
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	List<WebElement> alldates = driver.findElements(By.xpath("//tbody//tr//td[@class='calendarcell']"));
	for(WebElement date1:alldates)
	{
		String date2=date1.getText();
		if (date2.equalsIgnoreCase(date))
		{
			date1.click();
			
		}
	}
	}
	
	}
	


