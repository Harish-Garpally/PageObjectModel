package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


// assert i used to validate the actual and expected result
public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName="Contacts";


	public ContactsPageTest() {

		super();
	}

	@BeforeMethod

	public void setUp() {

		initialization();

		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		loginPage= new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickoncontactslink();

	}
	
	@DataProvider
	
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(dataProvider="getCRMTestData")

	public void validateCreateNewContact(String title,String firstaname,String lastname,String nickname,String company) {

		homePage.clickonNewContactLink();
		//contactsPage.createNewContact("Mrs.", "Tom", "henry", "nn", "texas");
		contactsPage.createNewContact(title, firstaname, lastname, nickname, company);
		

	}

	@AfterMethod

	public void tearDown() {

		driver.quit();

	}}



