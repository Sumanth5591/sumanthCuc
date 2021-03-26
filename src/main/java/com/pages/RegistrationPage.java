package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;
    //Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators

    private By selectIndividual = By.cssSelector("#signupScrollDiv > div > div.row > ul > li.active > a");
    private By firstName = By.id("fname");
    private By lastName = By.id("lname");
    private By phoneNumber = By.id("phone");
    private By emailAddress = By.id("email");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmpassword");
    private By signUpSubmit = By.cssSelector("#header-main > div.loginMain-bg > div > div.signup-btnBlock > button");

    //Page actions


    public void clickOnIndividualLink() {
        if(driver.findElement(selectIndividual).isDisplayed()){
            driver.findElement(selectIndividual).click();
        }
        else {
            System.out.println("Individual link is not present");
        }
    }


    public void enter_first_name() {
        Test.
    }
}
