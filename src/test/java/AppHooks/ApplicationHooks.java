package AppHooks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	//Launch the Browser
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configreader;
	Properties prop;
	
	
	@Before(order = 0)
	public void getProperty() {
		configreader = new ConfigReader();   //This is called Singleton pattern,read the properties file from the .properties file
		prop = configreader.init_prop();
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");  //Coming from Config.properties file
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);				//Integrating DriverFactory with config.properties...Store the driverFactory in driver Or else null pointer will throw
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();        // Have to provide the driver in the launch browser or null pointer will throw.
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//take screenshot
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String screenShotName = scenario.getName().replaceAll(" ","_");
			
			final byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "src/image/png", screenShotName+"_"+timeStamp); //stick it in the report
		}

	}

}
