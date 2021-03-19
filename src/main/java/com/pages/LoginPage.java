package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	
	//1. BY locators
	private	By emailId = By.id("email");
	private	By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");
	
	//2.Constructor of page class
	public LoginPage() {
		this.driver = driver;
	}
	
	//3.page actions : public in nature , features/behavior of the page and form of methods:
	
	//DONOT WRITE ASSERTIONS HERE
	public String getLoginPageTitle() {
	 return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
		
	}

}