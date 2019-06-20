package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
		
	    prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\piyushgupta7\\eclipse-workspace\\Framework\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
		}catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();
		
		}
		
	}

    public static void initialisation(){
	String browsername = prop.getProperty("browser");
	if(browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C://Users//piyushgupta7//Pictures//chromedriver.exe");
		driver=new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(70,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	WebDriverWait wait=new WebDriverWait(driver,10);
	
	
}



}