package com.crm.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Excel;
import com.crm.qa.util.ExcelUtils;
import com.crm.qa.util.TestUtil;
import com.sun.corba.se.spi.orbutil.fsm.Action;

import junit.framework.Assert;

@Listeners(com.crm.qa.util.listener.class)
public class LoginPageTest extends TestBase{
	
	
	LoginPage lg;
	HomePage hg;
	TestUtil tl;
	ContactsPage cp;
	
	public LoginPageTest() {
		super();
		}
	
	@BeforeMethod
	public void setup(){
		
		initialisation();
		lg=new LoginPage();
		hg=new HomePage();
		tl=new TestUtil();
		cp=new ContactsPage();
		driver.switchTo().frame("intercom-borderless-frame");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='intercom-blocks']"))).build().perform();
		driver.findElement(By.xpath("//div[@class='intercom-borderless-dismiss-button']")).click();
		lg.HomePageLogin(prop.getProperty("username"),prop.getProperty("password"));
		
		
		
	}
	

	

	/*@DataProvider
	public Object[][] getData()
	{
		Object data[][] = ExcelUtils.testData("Sheet1");
		return data;
		
		
	}*/
	
	@DataProvider
	public Object[][] getData()
	{
		Object data[][] = Excel.testData("Sheet1");
		return data;
	}
	
	@Test(dataProvider= "getData",enabled=false)
	public void ValidateCreateNewContact(String v1,String fn,String ln){
		tl.SwitchToFrame();
		hg.ClickOnContacts();
		hg.ClickOnNewContactLink();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {e.printStackTrace();}
	    cp.CreateNewContact(v1,fn,ln);
		
		
		}
	
	@Test(enabled=false)
	@Parameters({"nk"})
	public void EnterText(String nk)
	{
		tl.SwitchToFrame();
		hg.ClickOnContacts();
		hg.ClickOnNewContactLink();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cp.EnterNickName(nk);
		
	}
@Test(enabled=false)
public void datepicker()
{
	tl.SwitchToFrame();
	try {
		hg.calendar("September","2020","25");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Test
public void webtable()
{
	tl.SwitchToFrame();
	hg.ClickOnContacts();
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.findElement(By.xpath("//a[contains(text(),'Piyush Gupta')]/../..//td[1]//input[@type='checkbox']")).click();
	System.out.println("Bhaiy");
}


		
	
	@AfterMethod
	public void logout() {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}
	
	

}
