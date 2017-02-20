import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class AmazonHomePageComponent extends LoadableComponent<AmazonHomePageComponent>{
	
	WebDriver localdriver = null;
	WebDriverUtil wdUtil = null;
	String baseurl = null;
	
	private By searchBox = By.id("twotabsearchtextbox");
	private By searchButton = By.cssSelector("input[value=Go]");
	
	
	public AmazonHomePageComponent(WebDriver driver, String url)
	{
		localdriver = driver;
		wdUtil = new WebDriverUtil(driver); 
		this.baseurl = url;
	}
	
	public void enterTextSerachBoxContinue(String searchText)
	{	
		wdUtil.type(searchBox, searchText);
		wdUtil.click(searchButton);
	}

	@Override
	protected void isLoaded() throws Error {
		
		load();
		
		wdUtil.waitForElementPresent(searchBox);
		wdUtil.waitForElementPresent(searchButton);
	}

	@Override
	protected void load() {
		localdriver.get(baseurl);
	}
	
}


