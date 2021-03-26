package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	// 1. BY locators
	private By secretCode = By.id("pwd");
	private By secretCodeSubmit = By.cssSelector("#root > div > div > div > div > div:nth-child(3) > button");
	private By emailId = By.id("email");
	private By passwords = By.id("password");
	private By loginInButton = By.cssSelector("#header-main > div.login-modal > div > button.loginBtn");
	private By loginButtonPresent = By.id("profile_header");
	private By submitButton = By.cssSelector("#header-main > div.loginMain-bg > div > div.content > div.signup-btnBlock > button");
	private By signUpInButton = By.cssSelector("#header-main > div.login-modal > div > button.signupBtn");


	// 2.Constructor of page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3.page actions : public in nature , features/behavior of the page and form of
	// methods:

	// DONOT WRITE ASSERTIONS HERE
	public void enterSecretKey() throws InterruptedException {
		WebElement secretKeyElement = driver.findElement(secretCode);
		if (secretKeyElement.isDisplayed()) {
			secretKeyElement.sendKeys("1503");
			driver.findElement(secretCodeSubmit).click();
			Thread.sleep(5000);


		} else {
			DriverFactory.getDriver().get("http://qa.youukraft.co.in/");
		}
	}
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean loginButtonPresent() {
		return driver.findElement(loginButtonPresent).isDisplayed();
	}

	public void enterUsername(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwords).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(submitButton).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public HomePage doLogin(String username,String password) throws InterruptedException {
		System.out.println("Login with"+username+"with"+password);
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(passwords).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(submitButton).click();
		Thread.sleep(3000);
		return new HomePage(driver);
	}


	public void loginButtonClick() {
		driver.findElement(loginButtonPresent).click();
		driver.findElement(loginInButton).click();
	}

	public void signUpButtonClick() {
		driver.findElement(loginButtonPresent).click();
		driver.findElement(signUpInButton).click();
	}
}
