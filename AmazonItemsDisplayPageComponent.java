import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class AmazonItemsDisplayPageComponent {
	WebDriver localdriver = null;
	WebDriverUtil wdUtil = null;
	String baseurl = null;

	private By sortByRelevance = By.cssSelector("select[id=sort]");
	private By seeAll22Departments = By.cssSelector("#seeAllDepartmentClosed1 a");
	private By toysAgeRange = By.id("ref_165794011");
	private By Age2To4Years = By.cssSelector("#ref_165794011 li:nth-child(2)>a");
	private By tryPrime = By.cssSelector("#nav-tools a:nth-child(4)");
	private By lowToHigh = By.cssSelector(".a-spacing-top-mini>option:nth-child(2)");

	public AmazonItemsDisplayPageComponent(WebDriver driver, String url)
	{
		localdriver = driver;
		wdUtil = new WebDriverUtil(driver);
		baseurl = url;
		localdriver.get(baseurl);
	}

	public void sortBy()
	{
		localdriver.findElement(sortByRelevance).click();
		localdriver.findElement(lowToHigh).click();
	}

	public void clickSeeAllDepartments()
	{
		wdUtil.waitForElementVisible(seeAll22Departments);
		wdUtil.click(seeAll22Departments);
	}

	public void scrollDownToToysAgeRange()
	{
		wdUtil.scrollToElement(toysAgeRange);
	}

	public void Select2To4years()
	{
		localdriver.findElement(Age2To4Years).click();
	}

	public void selectTryPrime()
	{
		localdriver.findElement(tryPrime).click();
	}

	public void navigateBack()
	{
		localdriver.navigate().back();
	}
}
