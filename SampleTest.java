
import org.junit.Test;

@TargetBrowsers(value={Browser.CHROME, Browser.SAFARI}) //Custome annotaion to define Browser types
public class SampleTest extends BaseUITest { //SampleTest inherits from parent class BaseUITest

	//Sample test1
	@Test 
	public void testCase1() {
		//AmazonHomePageComponent pObject = new AmazonHomePageComponent(driver, "http://www.amazon.com");
		//pObject.get();
		//pObject.enterTextSerachBoxContinue("Baby bath toys");
	}
}