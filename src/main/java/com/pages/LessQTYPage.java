package com.pages;

import com.qa.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LessQTYPage {

  WebDriver driver;
  CodePage codePage = new CodePage(driver);
  ElementUtil eu = new ElementUtil();
  int[] ans;
  public static int onPageValue,intAvaliableQTY;

  private By getPlusButton = By.xpath("//span[contains(text(),'+')]");
  private By alertMessage = By.xpath("//p[@id='text_h4']");
  private By alertOkButton = By.xpath("//button[@id='popup-btn']");

  public LessQTYPage(WebDriver driver) {
    this.driver = driver;
  }

  public void changeTheQTY() {
    codePage.isAvalability();
    String avaliableQTY = CodePage.avaliableQTY;
    intAvaliableQTY = Integer.parseInt(avaliableQTY);

    System.out.println("Avaliable QTY is ---- " + avaliableQTY);
  }

  public void pressButtonTimes() {
    for (int i = 0; i < intAvaliableQTY - 1; i++) {
      eu.click(getPlusButton);
      eu.sleep(100);
    }
    eu.sleep(2000);
  }

  public void pressButtonTimesminusone() {
    eu.click(getPlusButton);
  }

  public void checkQTYInAlertIsSame() {
    String str = eu.getElementText(alertMessage);
    onPageValue = Integer.parseInt(str.replaceAll("[^0-9]", ""));
    System.out.println(onPageValue);
    System.out.println(intAvaliableQTY);
  }

  public void clickOnOkAlert() {
    eu.click(alertOkButton);
  }
}
