package com.pages;

import com.qa.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1. BY locators
	private By emailId = By.id("email");
	private By passwords = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");

	// 2.Constructor of page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3.page actions : public in nature , features/behavior of the page and form of
	// methods:

	// DONOT WRITE ASSERTIONS HERE
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUsername(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwords).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}

	public AccountsPage doLogin(String username,String password){
		System.out.println("Login with"+username+"with"+password);
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(passwords).sendKeys(password);
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);
	}


}
