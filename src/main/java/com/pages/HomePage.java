package com.pages;

import com.qa.factory.DriverFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class HomePage {

	private WebDriver driver;

	// Locator
	private By accountSection = By.cssSelector("div#center_column span");

	// Constructor

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// page actions
	public int getAccountSectionCount(){
		return driver.findElements(accountSection).size();
	}

	public List<String> getAccountsPageSectionList(){

		List<String> accountsList =  new ArrayList<>();
		List<WebElement> accountSections = driver.findElements(accountSection);
	 	for(WebElement e: accountSections){
			String text = e.getText();
			accountsList.add(text);
	 }
	 	return accountsList;
	}

	public String getAccountsPageTitle(){
		return driver.getTitle();
	}


}
