package stepdefinition;

import com.pages.CodePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
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

  @And("user is in home page {string}")
  public void userIsInHomePage(String userName) {
    String usr = userName.replaceAll("\\s", "");
    String str = codePage.isUsernamePresent();
    str = codePage.isUsernamePresent().replaceAll("\\s", "");
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
  public void changeTheQTYToByClickingOnButton(int increaseTo) {
    codePage.setQtyTwo(increaseTo);
    increaseTo1 = increaseTo;
  }

  @And("click on add to cart")
  public void clickOnAddToCart() {
    codePage.addToCart();
  }

  @And("click on go to cart")
  public void clickOnGoToCart() {
    codePage.goToCart();
  }

  @Then("Check the price and quantity in check out page")
  public void checkThePriceAndQuantityInCheckOutPage() {
    codePage.checkQtyPrice();
    Assert.assertEquals(Integer.toString(increaseTo1).trim(), codePage.cartPageQty1.trim());
    Assert.assertEquals(CodePage.priceOfTheProduct.trim(), codePage.cartPrice1.trim());
  }

  @And("click on proceed to checkout")
  public void clickOnProceedToCheckout() {
    codePage.clickOnProceed();
  }

  @And("click on continue")
  public void clickOnContinue() {}

  @And("select payment mode as Cash on delivery")
  public void selectPaymentModeAsCashOnDelivery() {}

  @And("place and order")
  public void placeAndOrder() {}

  @Then("confirm the text {string}")
  public void confirmTheText(String arg0) {}

  @Then("Logout of portal")
  public void logoutOfPortal() {}

  @And("Validate the total Price with QTY * price")
  public void validateTheTotalPriceWithQTYPrice() {
//    String cartPrice1 = String.format("%.2f", codePage.cartPrice1);
    double i = Double.parseDouble(codePage.cartPrice1) * Integer.parseInt(codePage.cartPageQty1);
    System.out.println(i);
    System.out.println(codePage.totalPrices);
    Assert.assertEquals(i,codePage.totalPrices,0.001);
  }
}
