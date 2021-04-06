package Parallel;

import com.pages.CodePage;
import com.pages.LessQTYPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LessQTY {

  private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
  private final CodePage codePage = new CodePage(DriverFactory.getDriver());
  private final LessQTYPage lessQTYPage = new LessQTYPage(DriverFactory.getDriver());
  private int alertQty;
  private int page;

  @And("Change the QTY to one aboveQTY Present by clicking on + button")
  public void changeTheQTYToOneAboveQTYPresentByClickingOnButton() {
    lessQTYPage.changeTheQTY();
  }

  @And("Press + button QYT-one times")
  public void pressButtonTimes(int pressQTYTimes) {}

  @And("Press + button QYT times")
  public void pressButtonQYTTimes() {
    lessQTYPage.pressButtonTimes();
  }

  @And("Press + button one more time")
  public void pressButtonOneMoreTime() {
    lessQTYPage.pressButtonTimesminusone();
  }

  @Then("Alert will pop up check the Quantity should match avaliable Quantity")
  public void alert_will_pop_up_check_the_quantity_should_match_avaliable_quantity() {
   lessQTYPage.checkQTYInAlertIsSame();
    Assert.assertEquals(page,alertQty);
  }

  @Then("click on ok on alert")
  public void click_on_ok_on_alert() {
   lessQTYPage.clickOnOkAlert();
  }
}
