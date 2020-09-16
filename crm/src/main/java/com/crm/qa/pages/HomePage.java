package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement UserNameLabel;

	@FindBy(xpath="//a[contains(text(),'Companies')]")
	WebElement CompaniesLink;

	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;

	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;

	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;

	//initializing page objects:
	

	public  HomePage() {

		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyuserName() {
		return UserNameLabel.isDisplayed();
		
		
	}

	public String verifyHomepagetitle() {
		return driver.getTitle();
	}
	
	public CompaniesPage clickoncompanieslink() {
		CompaniesLink.click();
		return new CompaniesPage();
	}
	public ContactsPage clickoncontactslink() {
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickonDelaslink() {
		DealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickonTaskslink() {
		TasksLink.click();
		return new TasksPage();}

   public void clickonNewContactLink() {
	   
	   Actions action=new Actions(driver);
	   action.moveToElement(ContactsLink).build().perform();
	   newContactsLink.click();
	   
   }}


