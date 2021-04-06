package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/AppFeatures"},
    glue = {"stepdefinition", "AppHooks"},
    plugin = {
      "pretty",
      "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    } // Colon is necessary
    )
public class MyRunner {

}