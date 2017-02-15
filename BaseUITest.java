import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import junit.framework.TestCase;

public class BaseUITest extends TestCase { //TestCase class defines fixture to run multiple tests.

	protected WebDriver driver = null; //Making Webdriver visible only child class of BaseUITest [i.e SampleTest]

	public BaseUITest(String name) {
		super(name);
	}

	@Before
	public void setup() {

	}

	@After
	public void teardown() { 
		TeardownWebDriver(); //To close driver
	}

	@Override
	//Overriding runTest() method in parent class TestCase, to run same tests on multiple browsers specified in browsersToRun list.
	public void runTest() throws Throwable {	
		List<Browser> browsersToRun = getTargetBrowsers();		
		for(Browser b: browsersToRun) { //For each browser b in browsersToRun list

			TeardownWebDriver(); //Close the driver, if open

			InitWebDriver(b); //Initialise the browser 
			super.runTest(); //Call runtest method in parent class TestCase
		}
	}

	public void InitWebDriver(Browser type) {	//For switching to different browsers
		switch(type) {
		case FIREFOX:
			DesiredCapabilities capabilities = DesiredCapabilities.firefox(); 
			capabilities.setCapability("marionette", true); 
			//System.setProperty("webdriver.gecko.driver", "/Users/sapna.sumanth/Downloads/geckodriver");
			driver = new FirefoxDriver(capabilities);
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "/Users/sapna.sumanth/Downloads/chromedriver");
			driver = new ChromeDriver();
			break;
		case SAFARI:
			driver = new SafariDriver();
			break;
		}
	}

	public void TeardownWebDriver() { //To close driver, if not already closed
		if(driver != null) {
			driver.close();
			driver = null;
		}
	}

	public List<Browser> getTargetBrowsers() {
		List<Browser> targetBrowsers = new ArrayList<Browser>(); //Creating an array list of type Browser
		TargetBrowsers target = getClass().getAnnotation(TargetBrowsers.class); //gets @TargetBrowsers(value={Browser.CHROME, Browser.SAFARI}) 
		//as an array value (in this case there is only one value, value[0]) from class SampleTest and is assigned to target of type TargetBrowsers
		Browser[] browsers = target.value(); //target.value() will split the 'values' chrome, safari and assign to browsers array.
		for(Browser b: browsers) {
			targetBrowsers.add(b); //adding each browser to list targetBrowsers
		}
		return targetBrowsers;
	}
}
