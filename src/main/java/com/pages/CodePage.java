package com.pages;

import com.qa.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class CodePage {

  public static String priceOfTheProduct;
  public static String cartPagePr;
  public static String cartPageQty1;
  public static String cartPrice1;
  public static Double totalPrices;
  public static String successMessagefromPage;
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
      By.xpath(
          "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[7]/div[1]/input[1]");
  private final By addToCartButton =
      By.cssSelector(
          "#root > div > div > div.contentMain > div > div.row > div:nth-child(2) > div > div.cart-block.mb-5.d-flex.align-items-center > button.addcartBtn");
  ElementUtil eu = new ElementUtil();
  private final WebDriver driver;
  private final By goToCartButton =
      By.cssSelector(
          "#root > div > div > div.contentMain > div > div.row > div:nth-child(2) > div > div.cart-block.mb-5.d-flex.align-items-center > button.addcartBtn");
  private final By cartPrice =
      By.cssSelector(
          "#root > div > div > div.contentMain > div.cartviewMain.row > div.w-75.col-md-9.safariwidth75 > div > table > div > div > tr > td:nth-child(2) > div > div:nth-child(1)");
  private final By cartPageQty =
      By.xpath(
          "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/table[1]/div[1]/div[1]/tr[1]/td[3]/div[1]/div[1]/input[1]");
  private final By cartTotalPrice =
      By.cssSelector(
          "#root > div > div > div.contentMain > div.cartviewMain.row > div.w-75.col-md-9.safariwidth75 > div > table > div > div > tr > td:nth-child(4)");
  private final By deleteButtonCart =
      By.xpath(
          "//body/div[@id='root']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/table[1]/div[1]/div[*]/tr[1]/td[6]/span[1]");

  private final By ConfirmRemoveProduct = By.xpath("//button[contains(text(),'Ok')]");
  private final By proceedToCheckoutButton =
      By.xpath("//button[contains(text(),'Proceed To Checkout')]");
  private final By clickOnContinue = By.xpath("//button[contains(text(),'Continue')]");
  private final By cashOnDeliveryButton = By.xpath("//p[contains(text(),'Cash On Delivery')]");
  private final By getCashOnDeliveryButton =
      By.cssSelector(
          "div.home div.contentMain:nth-child(2) div.cartviewMain.row div.w-75.col-md-9.safariwidth75:nth-child(1) div.shippingInfo.container div.paymentBlockMain.mb-4.row:nth-child(5) div.paymentBlockMethods > div.paymentBlock.active:nth-child(2)");
  private final By placeAndOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
  private final By alertPresent = By.xpath("//h4[contains(text(),'Alert')]");
  private By scrollToShowMore = By.xpath("//button[contains(text(),'Show More')]");
  private By successMessageElement =
      By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div/p[1]");

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
    eu.sleep(2000);
    driver.findElement(searchOnHomepage).sendKeys(Keys.RETURN);
  }

  public void searchForItemSearched(String searchedValue) throws InterruptedException {
    WebElement element = null;
    eu.waitForElementToBeVisible(allSearchElements, 5);
    List<WebElement> searchedElements = driver.findElements(allSearchElements);
    if (!(driver.findElements(scrollToShowMore).size() > 0)) {
      System.out.println("No Show More");
    } else {
      eu.scrollToThenClick(scrollToShowMore);
      eu.sleep(2000);
    }
    for (WebElement e : searchedElements) {
      String str = e.getText().trim();
      if (str.contains(searchedValue.trim())) {
        System.out.println("Search Item Found!!!!");
        e.click();
        eu.sleep(2000);
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

  public void setQtyTwo(int increaseTo) throws InterruptedException {
    boolean isPresesnt = driver.findElements(increaseQty).size() > 0;

    System.out.println("Previous cart item is present -- True or false : " + isPresesnt);
    if (isPresesnt) {
      eu.waitForElementToBeVisible(increaseQty, 20);
      String str = String.valueOf(increaseTo);
      eu.sendKeys(increaseQty, str);
    } else {
      String currentURL = eu.getCurrentURL();
      driver.navigate().to("http://qa.youukraft.co.in/cart.html");
      eu.syncWait(2000);
      boolean delPres = driver.findElements(deleteButtonCart).size() > 0;
      if (delPres) {
        driver.findElement(deleteButtonCart).click();
        eu.syncWait(2000);
        eu.click(ConfirmRemoveProduct);
        driver.navigate().to(currentURL);
        eu.syncWait(2000);
        String str = String.valueOf(increaseTo);
        eu.sendKeys(increaseQty, str);
      } else {
        driver.navigate().to(currentURL);
        String str = String.valueOf(increaseTo);
        eu.sendKeys(increaseQty, str);
      }
    }
  }

  public void addToCart() throws InterruptedException {
    eu.sleep(2000);
    eu.click(addToCartButton);
  }

  public void goToCart() {
    eu.sleep(2000);
    eu.click(goToCartButton);
  }

  public String checkQtyPrice() {
    eu.sleep(2000);
    eu.waitForElementToDisplay(cartPrice);
    eu.getCurrentURL().contains("cart");
    cartPageQty1 = driver.findElement(cartPageQty).getAttribute("value");
    cartPrice1 = eu.getElementText(cartPrice);
    cartPrice1 = cartPrice1.replaceAll("₹", "").trim();
    return cartPageQty1 + cartPrice1;
  }

  public double totalPrice() {
    String str = eu.getElementText(cartTotalPrice);
    str = str.replaceAll("[₹,]", "").trim();
    totalPrices = Double.parseDouble(str);
    System.out.println("Inside : " + totalPrices);
    return totalPrices;
  }

  public void clickOnProceed() throws InterruptedException {
    eu.syncWait(2000);
    eu.waitForElementToDisplay(proceedToCheckoutButton);
    eu.click(proceedToCheckoutButton);
    eu.syncWait(2000);
    if (driver.findElements(alertPresent).size() > 0) {
      System.out.println("Transcations Alert, So cannot proceed");
    }
  }

  public void clickOnContinue() {
    eu.sleep(2000);
    eu.click(clickOnContinue);
  }

  public void selectPaymentMode() {
    eu.sleep(3000);
    eu.findElementAndClick_SKIP(getCashOnDeliveryButton);
    eu.findElementAndClick_SKIP(cashOnDeliveryButton);
  }

  public void placeAndOrder() {
    eu.sleep(2000);
    eu.click(placeAndOrderButton);
  }

  public String verifySuccessMessage() {
    successMessagefromPage = eu.getElementText(successMessageElement);
    return successMessagefromPage;
  }
}
