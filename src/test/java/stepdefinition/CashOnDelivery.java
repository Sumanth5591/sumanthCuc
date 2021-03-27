package stepdefinition;

import com.pages.CodePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.apache.poi.hpsf.CodePageString;
import org.hamcrest.core.StringContains;
import org.junit.Assert;

import java.io.Console;
import java.util.List;
import java.util.Map;

public class CashOnDelivery {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private CodePage codePage = new CodePage(DriverFactory.getDriver());

    @Given("user has already logged on into system")
    public void userHasAlreadyLoggedOnIntoSystem(DataTable credTable) throws InterruptedException {

        List<Map<String, String>> credList = credTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");
        DriverFactory.getDriver()
                .get("http://qa.youukraft.co.in/");
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
        Thread.sleep(5000);
    }

    @And("Search for gloves and click on gloves {string}")
    public void searchForGlovesAndClickOnGloves(String gloves) throws InterruptedException {
        codePage.searchForItemSearched(gloves);
        Thread.sleep(3000);

    }

    @And("Check the price of the product")
    public void checkThePriceOfTheProduct() {
    }

    @And("check the avalability of product")
    public void checkTheAvalabilityOfProduct() {
    }

    @And("change the Pincode to {string}")
    public void changeThePincodeTo(String arg0) {
    }

    @And("Change the QTY to {int} by clicking on + button")
    public void changeTheQTYToByClickingOnButton(int arg0) {
    }

    @And("click on add to cart")
    public void clickOnAddToCart() {
    }

    @And("click on go to cart")
    public void clickOnGoToCart() {
    }

    @Then("Check the price and quantity in check out page")
    public void checkThePriceAndQuantityInCheckOutPage() {
    }

    @And("click on proceed to checkout")
    public void clickOnProceedToCheckout() {
    }

    @And("click on continue")
    public void clickOnContinue() {
    }

    @And("select payment mode as Cash on delivery")
    public void selectPaymentModeAsCashOnDelivery() {
    }

    @And("place and order")
    public void placeAndOrder() {
    }

    @Then("confirm the text {string}")
    public void confirmTheText(String arg0) {
    }

    @Then("Logout of portal")
    public void logoutOfPortal() {
    }



}
