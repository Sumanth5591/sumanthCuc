package com.pages;

import com.qa.util.MockLib;
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
    private By panNumber = By.id("pan");
    private By aadhar = By.id("aadhar");
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


    public void setFirstName() {
        driver.findElement(firstName).sendKeys(MockLib.firstName());
    }

    public void setLastName() {
        driver.findElement(lastName).sendKeys(MockLib.lastName());
    }

    public void setEmailAddress(){
        driver.findElement(emailAddress).sendKeys(MockLib.emailAddress());
    }

    public void setphoneNumber(){
        driver.findElement(phoneNumber).sendKeys(MockLib.indPhoneNumber());
    }


    public void setPasswords(){
        driver.findElement(password).sendKeys(MockLib.password());
    }

    public void setConfirmPassword(){
        driver.findElement(confirmPassword).sendKeys(MockLib.confirmPassword());
    }

    public void clickOnSubmit(){
        driver.findElement(signUpSubmit).click();
    }


}
