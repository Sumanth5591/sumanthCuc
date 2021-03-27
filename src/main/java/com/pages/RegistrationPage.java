package com.pages;

import com.qa.util.MockLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;
    private final By selectIndividual = By.cssSelector("#signupScrollDiv > div > div.row > ul > li.active > a");
    //Locators
    private final By firstName = By.id("fname");
    private final By lastName = By.id("lname");
    private final By phoneNumber = By.id("phone");
    private final By emailAddress = By.id("email");
    private final By password = By.id("password");
    private final By panNumber = By.id("pan");
    private final By aadhar = By.id("aadhar");
    private final By confirmPassword = By.id("confirmpassword");
    private final By signUpSubmit = By.cssSelector("#header-main > div.loginMain-bg > div > div.signup-btnBlock > button");
    private final By loginDropDown = By.cssSelector("#profile_header > a");
    //Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Page actions

    public void clickOnIndividualLink() {
        if (driver.findElement(selectIndividual).isDisplayed()) {
            driver.findElement(selectIndividual).click();
        } else {
            System.out.println("Individual link is not present");
        }
    }

    public void clickOnLoginDropDown() {
        driver.findElement(loginDropDown).click();
    }


    public void setFirstName() {
        driver.findElement(firstName).sendKeys(MockLib.firstName());
    }

    public void setLastName() {
        driver.findElement(lastName).sendKeys(MockLib.lastName());
    }

    public void setEmailAddress() {
        driver.findElement(emailAddress).sendKeys(MockLib.emailAddress());
    }

    public void setphoneNumber() {
        driver.findElement(phoneNumber).sendKeys(MockLib.indPhoneNumber());
    }

    public void setAadharNumber() {
        driver.findElement(aadhar).sendKeys(MockLib.aadharCard());
    }

    public void setPanNumber() {
        driver.findElement(panNumber).sendKeys(MockLib.pANCard());
    }

    public void setPassword() {
        driver.findElement(password).sendKeys(MockLib.setPassword(10));
    }

    public void clickOnSubmit() {
        driver.findElement(signUpSubmit).click();
    }

    public void setConfirmPassword() {
        driver.findElement(confirmPassword).sendKeys(MockLib.setConfirmPassword());
    }
}
