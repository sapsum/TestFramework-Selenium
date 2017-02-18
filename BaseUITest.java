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

/*
 * This is the base test class and it inherits from JUnit TestCase
 * as I need to control how I run all the tests in a suite.
 */
public class BaseUITest extends TestCase {

	protected WebDriver driver = null; 

	@Before
	public void setup() { }

	@After
	public void teardown() { 
		// Close webdriver and browser after the test run.
		TeardownWebDriver(); 
	}

	
	/*
	 * Overriding runTest() method in parent class TestCase, to run same tests on 
	 * multiple browsers specified in browsersToRun list.
	 */
	@Override
	public void runTest() throws Throwable {	
		List<Browser> browsersToRun = getTargetBrowsers();		
		
		//Run the same test for all the browers in the list.
		for(Browser b: browsersToRun) { 

			//Initialise the browser 
			InitWebDriver(b); 
			
			//Call runtest method in parent class TestCase
			super.runTest(); 
		}
	}

	/*
	 * Initializes the webdriver based on the browser type.
	 */
	public void InitWebDriver(Browser type) {
		switch(type) {
		case FIREFOX:
			DesiredCapabilities capabilities = DesiredCapabilities.firefox(); 
			capabilities.setCapability("marionette", true); 
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

	/*
	 * Close driver if not already closed.
	 */
	public void TeardownWebDriver() { 
		if(driver != null) {
			driver.close();
			driver = null;
		}
	}

	/*
	 * Gets the target browser annotation defined at the class level
	 * and return a list of browsers.
	 */
	public List<Browser> getTargetBrowsers() {
		List<Browser> tBrowsers = new ArrayList<Browser>();

		TargetBrowsers target = getClass().getAnnotation(TargetBrowsers.class); 
		Browser[] browsers = target.value(); 
		
		for(Browser b: browsers) {
			tBrowsers.add(b);
		}
		return tBrowsers;
	}
}
