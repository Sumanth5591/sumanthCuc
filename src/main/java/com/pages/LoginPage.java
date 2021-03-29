package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class LoginPage {

    private final WebDriver driver;
    ElementUtil eu =  new ElementUtil();

    // 1. BY locators
    private final By secretCode = By.id("pwd");
    private final By secretCodeSubmit = By.cssSelector("#root > div > div > div > div > div:nth-child(3) > button");
    private final By emailId = By.id("email");
    private final By passwords = By.id("password");
    private final By loginInButton = By.cssSelector("#header-main > div.login-modal > div > button.loginBtn");
    private final By loginButtonPresent = By.id("profile_header");
    private final By submitButton = By.cssSelector("#header-main > div.loginMain-bg > div > div.content > div.signup-btnBlock > button");
    private final By signUpInButton = By.cssSelector("#header-main > div.login-modal > div > button.signupBtn");
    private By hoverForDropdown = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/div[3]/div[2]/div[3]/div[1]/ul[1]/li[2]/a[1]");
    private By logoutButton = By.xpath("//span[contains(text(),'Logout')]");
    private By welcomeScreenElement = By.xpath("//span[contains(text(),'Welcome')]");


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
            Thread.sleep(2000);


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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doLogin(String username, String password) throws InterruptedException {
        System.out.println("Login with ---- " + username + " with ---- " + password);
        loginButtonPresent();
        loginButtonClick();
        Thread.sleep(2000);
        driver.findElement(emailId).sendKeys(username);
        driver.findElement(passwords).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(submitButton).click();
        Thread.sleep(2000);
    }


    public void loginButtonClick() {
        driver.findElement(loginButtonPresent).click();
        driver.findElement(loginInButton).click();
    }

    public void signUpButtonClick() {
        driver.findElement(loginButtonPresent).click();
        driver.findElement(signUpInButton).click();
    }

    public void doLogout() {
        driver.navigate().to("http://qa.youukraft.co.in/");
        driver.navigate().refresh();
        eu.syncWait(5000);
        System.out.println("Logout Procedure started");
        eu.findElementAndClick_SKIP(hoverForDropdown);
        eu.sleep(2000);
        eu.findElementAndClick_SKIP(logoutButton);
        System.out.println("Successfully Logout");
        try{
            eu.waitUntilElementIsDisplayedOnScreen(welcomeScreenElement,5);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }
}
