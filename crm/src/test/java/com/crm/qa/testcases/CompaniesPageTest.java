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



public class CompaniesPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CompaniesPage companiesPage;


	public CompaniesPageTest() {

		super();
	}

	@BeforeMethod

	public void setUp() {

		initialization();

		testUtil=new TestUtil();
		companiesPage=new CompaniesPage();
		loginPage= new LoginPage();

		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		companiesPage = homePage.clickoncompanieslink();
	}
	@Test(priority=1)

	public void verifyCompanyPagelabel() {
		companiesPage.verifycompanieslabel();
		Assert.assertTrue(companiesPage.verifycompanieslabel(), "companies lable is missing on the page");	
	}

	@Test(priority=2)
	public void selectCompaniesTest() {
		companiesPage.selectcompaniesByname("ABC");


	}
	@AfterMethod

	public void tearDown() {

		//driver.quit();
	}}
