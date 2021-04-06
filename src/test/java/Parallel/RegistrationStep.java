package Parallel;

import com.pages.LoginPage;
import com.pages.RegistrationPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RegistrationStep {

    RegistrationPage registrationPage = new RegistrationPage(DriverFactory.getDriver());
    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());


    @When("User clicks on SignUp button")
    public void user_clicks_on_sign_up_button() {
        loginPage.signUpButtonClick();
    }

    @When("Select Individual tab on SignUp page")
    public void select_individual_tab_on_sign_up_page() {
        registrationPage.clickOnIndividualLink();
    }

    @When("Enter the Random First Name")
    public void enter_the_random_first_name() {
        registrationPage.setFirstName();

    }

    @When("Enter the Random Last Name")
    public void enter_the_random_last_name() {
        registrationPage.setLastName();

    }

    @When("Enter the Random PhoneNumber")
    public void enter_the_random_phone_number() {
        registrationPage.setphoneNumber();
    }

    @When("Enter the Random AadharCard")
    public void enter_the_random_aadhar_card() {
        registrationPage.setAadharNumber();
    }

    @When("Enter the Random PanNumber")
    public void enter_the_random_pan_number() {
        registrationPage.setPanNumber();
    }

    @When("Enter the Random password")
    public void enter_the_random_password() {
        registrationPage.setPassword();
    }

    @When("Enter the Random confirmPassword")
    public void enter_the_random_confirm_password() throws InterruptedException {
        registrationPage.setConfirmPassword();
        Thread.sleep(20000);
    }

    @Then("user clicks on submit button in registration page")
    public void user_clicks_on_submit_button_in_registration_page() {

    }


    @Then("user is on login dropdown")
    public void userIsOnLoginDropdown() {
        registrationPage.clickOnLoginDropDown();
    }


    @And("Enter the randon Email Address")
    public void enterTheRandonEmailAddress() {
        registrationPage.setEmailAddress();
    }
}
