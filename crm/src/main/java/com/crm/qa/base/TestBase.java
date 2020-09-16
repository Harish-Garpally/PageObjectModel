package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.crm.qa.util.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	//public static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;
	// this is the standard code for any Test Base class you need to change the file location as needed.
	
	
	//creating constructor of the class
	public TestBase() {
		try {
			prop= new Properties();
			FileInputStream ip=new FileInputStream("D:\\workspace\\crm\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}



public static void initialization () {
	
	String browserName=prop.getProperty("Browser");
	if (browserName.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		 driver= new ChromeDriver(); 
	}else if(browserName.equals("Firefox")){

		System.setProperty("webdriver.gecko.driver", "D:\\selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver= new FirefoxDriver(); 
		
	}
	
	//e_driver=new EventFiringWebDriver(driver);
	//eventListener=new WebEventListener();
	//e_driver.register(eventListener);
	//driver=e_driver;
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
}
}