package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CompaniesPage companiesPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	
public void setUp() {
		
		initialization();
		
		testUtil=new TestUtil();
		companiesPage=new CompaniesPage();
		loginPage= new LoginPage();
		
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

}
	
	@Test(priority=1)
	
	public void verifyHomePageTitleTest() {
		
		String HomePageTitle=homePage.verifyHomepagetitle();
		
		Assert.assertEquals(HomePageTitle, "CRMPRO", "HomePageTitle not matched");
	}
	
	@Test(priority=2)
	
	public void verifyUserNameTest() {
		
		
		testUtil.switchToFrame();
		homePage.verifyuserName();
		
		Assert.assertTrue(homePage.verifyuserName());
	}
		
		@Test(priority=3)
		
		public void verifycompanieslinkTest() {
			testUtil.switchToFrame();
			companiesPage=homePage.clickoncompanieslink();
			
			
		}
			
	

	@AfterMethod
	
	public void tearDown() {
		
		driver.quit();
	}
	}
