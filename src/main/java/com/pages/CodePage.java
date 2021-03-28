package com.pages;

import com.qa.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CodePage {

  private WebDriver driver;
  ElementUtil eu = new ElementUtil();
  public static String priceOfTheProduct;
  public static String cartPagePr;
  private final By usernamePresent = By.cssSelector("#profile_header > a > span.username");
  private final By searchOnHomepage = By.id("search_element");
  private final By searchButton =
      By.cssSelector(
          "#navbarSupportedContent > div.mobile-hide.w-100.flex-none.row > div.d-flex.align-items-center.safariwidth58.col-md-7.col-sm-7.col-xs-12 > div.ipBlock > span");
  private final By allSearchElements = By.xpath("//*[@id='contentMain']/div[3]/div[*]/a/div[*]/p");
  private final By priceOfItem1 =
      By.cssSelector(
          "#root > div > div > div.contentMain > div > div.row > div:nth-child(2) > div > div.container.row > div > span.amount.m-0");
  private final By isAvailable =
      By.xpath("//*[@id='root']/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div/span[4]/span[2]");
  private final By pinCodeElement = By.id("deliverable");
  private final By increaseQty =
      By.cssSelector(
          "#root > div > div > div.contentMain > div > div.row > div:nth-child(2) > div > div.cart-block.mb-5.d-flex.align-items-center > div > input");
  private final By addToCartButton =
      By.cssSelector(
          "#root > div > div > div.contentMain > div > div.row > div:nth-child(2) > div > div.cart-block.mb-5.d-flex.align-items-center > button.addcartBtn");
  private By goToCartButton =
      By.cssSelector(
          "#root > div > div > div.contentMain > div > div.row > div:nth-child(2) > div > div.cart-block.mb-5.d-flex.align-items-center > button.addcartBtn");
  private By cartPrice =
      By.cssSelector(
          "#root > div > div > div.contentMain > div.cartviewMain.row > div.w-75.col-md-9.safariwidth75 > div > table > div > div > tr > td:nth-child(2) > div > div:nth-child(1)");
  private By cartPageQty = By.xpath("//*[@id='20']");
  public static String cartPageQty1;
  public static String cartPrice1;
  public static Double totalPrices;

  private By cartTotalPrice = By.cssSelector("#root > div > div > div.contentMain > div.cartviewMain.row > div.w-75.col-md-9.safariwidth75 > div > table > div > div > tr > td:nth-child(4)");

  public CodePage(WebDriver driver) {
    this.driver = driver;
  }

  public String isUsernamePresent() {
    return eu.getElementText(usernamePresent);
  }

  public void clickOnSearch() {
    eu.click(searchOnHomepage);
  }

  public void searchForItem(String searchString) {
    eu.sendKeys(searchOnHomepage, searchString);
  }

  public void clickOnSearchButton() throws InterruptedException {
    driver.findElement(searchOnHomepage).sendKeys(Keys.RETURN);
  }

  public void searchForItemSearched(String searchedValue) throws InterruptedException {
    WebElement element = null;
    eu.waitForElementToBeVisible(allSearchElements, 5);
    List<WebElement> searchedElements = driver.findElements(allSearchElements);
    for (WebElement e : searchedElements) {
      String str = e.getText().trim();
      if (str.contains(searchedValue.trim())) {
        System.out.println("Search Item Found!!!!");
        e.click();
        eu.sleep(5000);
        eu.getCurrentURL().contains("gloves");
        return;
      } else
        System.out.println("Item Found is not : " + searchedValue + " -- So Move to next item");
    }
  }

  public String checkThePrice() {

    if (driver.findElement(priceOfItem1).isEnabled()) {
      priceOfTheProduct = driver.findElement(priceOfItem1).getText();
      priceOfTheProduct = priceOfTheProduct.replaceAll("₹", "").trim();
      return priceOfTheProduct;
    } else return "Didn't find the price";
  }

  public void isAvalability() {

    String str = eu.getElementText(isAvailable);
    int strToInt = Integer.parseInt(str);
    if (strToInt > 2) {
      System.out.println("The Quantity is larger than 2, so Proceed");
    } else {
      System.out.println("Quantity is not more than 2, so logout");
      driver.quit();
    }
  }

  public void setPincode(String pinCode) {
    eu.waitForElementToBeVisible(pinCodeElement, 20);
    eu.sendKeys(pinCodeElement, pinCode);
    eu.sleep(2000);
  }

  public void setQtyTwo(int increaseTo) {
    eu.waitForElementToBeVisible(increaseQty, 20);
    String str = String.valueOf(increaseTo);
    eu.sendKeys(increaseQty, str);
  }

  public void addToCart() {
    eu.sleep(2000);
    eu.click(addToCartButton);
  }

  public void goToCart() {
    eu.sleep(2000);
    eu.click(goToCartButton);
  }

  public String checkQtyPrice() {
    eu.sleep(5000);
    eu.waitForElementToDisplay(cartPrice);
    eu.getCurrentURL().contains("cart");
    cartPageQty1 = driver.findElement(cartPageQty).getAttribute("value");
    cartPrice1 = eu.getElementText(cartPrice);
    cartPrice1 = cartPrice1.replaceAll("₹", "").trim();
    return cartPageQty1 + cartPrice1;
  }

  public void clickOnProceed() {
  }

  public double totalPrice() {
    String str = eu.getElementText(cartTotalPrice);
    str.replaceAll("₹", "").trim();
    totalPrices = Double.parseDouble(str);
    return totalPrices;
  }
}
