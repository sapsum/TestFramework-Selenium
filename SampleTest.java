
import org.junit.Test;

@TargetBrowsers({Browser.CHROME, Browser.SAFARI}) //Custome annotaion to define Browser types
public class SampleTest extends BaseUITest { //SampleTest inherits from parent class BaseUITest

	public SampleTest(String name) {
		super(name);
	}

	@Test //Sample test1
	public void testCase1() {
		driver.get("http://www.google.com");
	}
	
	
	@Test //Sample test1
	public void testCase2() {
		driver.get("http://www.amazon.com");
	}
}