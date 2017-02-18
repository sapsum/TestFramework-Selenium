import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Webdriver utility that provides webdriver methods
 * as well as additional helper methods.
 */
public class WebDriverUtil {
	
	private static final int TIMEOUT = 10;

	private WebDriver driver = null;

	public WebDriverUtil(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * To click an element
	 */
	public void click(By by) {
		driver.findElement(by).click();
	}

	/*
	 * To clear text entered in an element
	 */
	public void clear(By by) {
		driver.findElement(by).clear();
	}

	/*
	 * To enter text in an element
	 */
	public void type(By by, String text) {
		driver.findElement(by).sendKeys(text);
	}

	/*
	 * To check if an element is visible
	 */
	public boolean isElementVisible(By by) {
		return driver.findElement(by).isDisplayed();
	}

	/*
	 * To wait for an element until it is displayed
	 */
	public void waitForElementPresent(By by) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	/*
	 * To wait for an element until it is visible
	 */
	public void waitForElementVisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	/*
	 * To wait until an element is invisible
	 */
	public void waitForElementInvisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
}
