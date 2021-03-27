package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class CodePage {


    private final WebDriver driver;

    public CodePage(WebDriver driver){
        this.driver = driver;
    }



    private final By usernamePresent = By.cssSelector("#profile_header > a > span.username");

    private final By searchOnHomepage = By.id("search_element");

    private final By searchButton = By.cssSelector("#navbarSupportedContent > div.mobile-hide.w-100.flex-none.row > div.d-flex.align-items-center.safariwidth58.col-md-7.col-sm-7.col-xs-12 > div.ipBlock > span");

    private final By allSearchElements = By.xpath("//*[@id='contentMain']/div[3]/div[*]/a/div[*]/p");



    public String isUsernamePresent(){
        return driver.findElement(usernamePresent).getText();
    }

    public void clickOnSearch() {
        driver.findElement(searchOnHomepage).click();

    }

    public void searchForItem(String searchString) {
        driver.findElement(searchOnHomepage).sendKeys(searchString);
    }

    public void clickOnSearchButton() {
        driver.findElement(searchOnHomepage).sendKeys(Keys.RETURN);
    }

    public void searchForItemSearched(String searchedValue) {

        searchedValue = searchedValue.trim().replaceAll(" ", "");
        System.out.println("Search value "+searchedValue);

        List<WebElement> seachedElements = driver.findElements(allSearchElements);
        for(WebElement e: seachedElements){
            System.out.println(e.getText().trim().replaceAll(" ", ""));


            if(e.getText().trim().replaceAll(" ", "").contains(searchedValue)){
                System.out.println("This is div" + e);
                e.click();

            }
            else System.out.println("no element found");

        }




    }


}
