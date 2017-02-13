import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {
	
	private static final int TIMEOUT = 10;

	private WebDriver driver = null;

	public WebDriverUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void click(By by) {
		driver.findElement(by).click();
	}

	public void clear(By by) {
		driver.findElement(by).clear();
	}

	public void type(By by, String text) {
		driver.findElement(by).sendKeys(text);
	}

	public boolean isElementPresent(By by) {
		return driver.findElement(by).isDisplayed();
	}

	public boolean isElementVisible(By by) {
		return driver.findElement(by).isDisplayed();
	}

	public void waitForElementPresent(By by) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void waitForElementVisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void waitForElementInvisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
}
