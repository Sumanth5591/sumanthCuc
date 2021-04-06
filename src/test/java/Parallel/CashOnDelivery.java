package Parallel;

import com.pages.CodePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CashOnDelivery {

  private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
  private final CodePage codePage = new CodePage(DriverFactory.getDriver());
  private int increaseTo1;

  @Given("user has already logged on into system")
  public void userHasAlreadyLoggedOnIntoSystem(DataTable credTable) throws InterruptedException {

    List<Map<String, String>> credList = credTable.asMaps();
    String userName = credList.get(0).get("username");
    String password = credList.get(0).get("password");
    DriverFactory.getDriver().get("http://qa.youukraft.co.in/");
    loginPage.enterSecretKey();
    loginPage.doLogin(userName, password);
  }


  @Then("user is in home page {string}")
  public void user_is_in_home_page(String userName) {
    String usr = userName.replaceAll(" ", "");
    String str = codePage.isUsernamePresent();
    str = codePage.isUsernamePresent().replaceAll(" ", "");
    Assert.assertTrue(str.contains(usr));
  }


  @And("click on search")
  public void clickOnSearch() {
    codePage.clickOnSearch();
  }

  @Then("search for Item {string}")
  public void searchForItem(String searchString) {
    codePage.searchForItem(searchString);
  }

  @And("Click on search button")
  public void clickOnSearchButton() throws InterruptedException {
    codePage.clickOnSearchButton();
  }

  @And("Search for gloves and click on gloves {string}")
  public void searchForGlovesAndClickOnGloves(String gloves) throws InterruptedException {
    codePage.searchForItemSearched(gloves);
  }

  @And("Check the price of the product")
  public void checkThePriceOfTheProduct() {
    codePage.checkThePrice();
    System.out.println("Price of the Product is : " + CodePage.priceOfTheProduct);
  }

  @And("check the avalability of product")
  public void checkTheAvalabilityOfProduct() {
    codePage.isAvalability();
  }

  @And("change the Pincode to {string}")
  public void changeThePincodeTo(String pinCode) {
    codePage.setPincode(pinCode);
  }

  @And("Change the QTY to {int} by clicking on + button")
  public void changeTheQTYToByClickingOnButton(int increaseTo) throws InterruptedException {
    codePage.setQtyTwo(increaseTo);
    increaseTo1 = increaseTo;
  }

  @And("click on add to cart")
  public void clickOnAddToCart() throws InterruptedException {
    codePage.addToCart();
  }

  @And("click on go to cart")
  public void clickOnGoToCart() {
    codePage.goToCart();
  }

  @Then("Check the price and quantity in check out page")
  public void checkThePriceAndQuantityInCheckOutPage() {
    codePage.checkQtyPrice();
    Assert.assertEquals(Integer.toString(increaseTo1).trim(), CodePage.cartPageQty1.trim());
    Assert.assertEquals(CodePage.priceOfTheProduct.trim(), CodePage.cartPrice1.trim());
  }

  @And("Validate the total Price with QTY * price")
  public void validateTheTotalPriceWithQTYPrice() {
    codePage.totalPrice();
    //    String cartPrice1 = String.format("%.2f", codePage.cartPrice1);
    double i = Double.parseDouble(CodePage.cartPrice1) * Integer.parseInt(CodePage.cartPageQty1);
    System.out.println(i);
    System.out.println(CodePage.totalPrices);
    Assert.assertEquals(i, CodePage.totalPrices, 0.001);
  }

  @And("click on proceed to checkout")
  public void clickOnProceedToCheckout() throws InterruptedException {
    codePage.clickOnProceed();
  }

  @And("click on continue")
  public void clickOnContinue() {
    codePage.clickOnContinue();
  }

  @And("select payment mode as Cash on delivery")
  public void selectPaymentModeAsCashOnDelivery() {
    codePage.selectPaymentMode();
  }

  @And("place and order")
  public void placeAndOrder() {
    codePage.placeAndOrder();
  }

  @Then("confirm the text {string}")
  public void confirmTheText(String successMessage) {
    String str = codePage.verifySuccessMessage().trim();
    successMessage = successMessage.trim();
    Assert.assertTrue(str.contains(successMessage));
  }

  @Then("Logout of portal")
  public void logoutOfPortal() {
    loginPage.doLogout();
  }
}
