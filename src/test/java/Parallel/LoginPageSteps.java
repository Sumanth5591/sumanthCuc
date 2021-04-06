package Parallel;


import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

	//Initialize POM object here as private
	
	private LoginPage loginpage =  new LoginPage(DriverFactory.getDriver());
	String title;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
	    DriverFactory.getDriver().get("http://qa.youukraft.co.in/");
	}
	@When("user gets to secret code page")
	public void userGetsToSecretCodePage() throws InterruptedException {
		loginpage.enterSecretKey();
	}

	@Then("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		 title = loginpage.getLoginPageTitle();
		System.out.println(title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("login button link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginpage.loginButtonPresent());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginpage.enterUsername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String passwords) {
		loginpage.enterPassword(passwords);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginpage.clickOnLogin();
	}

	@Then("user gets the title of the homepage")
	public void user_gets_the_title_of_the_homepage() {
		title = loginpage.getLoginPageTitle();
	}


	@Given("user is on login page and click on Login button")
	public void userIsOnLoginPageAndClickOnLoginButton() {
		loginpage.loginButtonClick();

	}
}
