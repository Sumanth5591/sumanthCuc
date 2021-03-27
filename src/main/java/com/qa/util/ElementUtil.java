package com.qa.util;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.ListIterator;

public class ElementUtil {

    static WebDriver driver ;

    public static List<String> replaceLower(List<String> strings)
    {
        ListIterator<String> iterator = strings.listIterator();
        while (iterator.hasNext())
        {
            iterator.set(iterator.next().toLowerCase());
        }
        return strings;
    }

//Read Random GST
    public String randomGSTNumbers(){
        Faker faker = new Faker();
        return faker.regexify("[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}");
    }

    public static WebElement eWait(By element, Integer timeout){
        WebDriverWait wait=new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
        return (WebElement) element;
    }


}
