package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CompaniesPage extends TestBase {
	
	// define page factory
	
	@FindBy(xpath="//td[contains(text(),'Companies']")
	WebElement companiesLabel;
	
	public CompaniesPage() {
		PageFactory.initElements(driver,this);
		
	}
	
	public boolean verifycompanieslabel() {
		
		return companiesLabel.isDisplayed();
	}
	
	public void selectcompaniesByname(String name) {
		
		driver.findElement(By.xpath(
         "//a[text()='"+name+"']//parent::td[@class='datalistrow']"
		+"//preceding-sibling::td[@class=datalistrow']//input[@name='client_id']")).click();
	}

}
