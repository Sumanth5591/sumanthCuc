package stepdefinition;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountPageSteps {

	private LoginPage loginpage =  new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;



	@Given("user has already logged on into system")
	public void user_has_already_logged_on_into_system(DataTable credTable) {
		List<Map<String,String>> credlist = credTable.asMaps();
		String username = credlist.get(0).get("username");
		String password = credlist.get(0).get("password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginpage.doLogin(username,password);
	}

	@Given("user is in account page")
	public void user_is_in_account_page() {
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("-----This the value of the title-----"+title);
	}

	@Then("user gets account section")
	public void user_gets_account_section(DataTable sectionsTable) {
        //From Feature file
        List<String> expAccountSectionList = sectionsTable.asList();
        System.out.println(expAccountSectionList);

        //From getElementsMethods
		List<String> actAccountSectionList = accountsPage.getAccountsPageSectionList();
		System.out.println(actAccountSectionList);

		Assert.assertTrue(expAccountSectionList.containsAll(actAccountSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountsPage.getAccountSectionCount() == expectedSectionCount);
	}

}
