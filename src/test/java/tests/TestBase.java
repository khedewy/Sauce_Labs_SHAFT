package tests;
import org.testng.annotations.BeforeClass;

import com.shaft.driver.SHAFT;

public class TestBase {
	public static SHAFT.GUI.WebDriver driver;
	
	@BeforeClass
	public void setDriver() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		driver = new SHAFT.GUI.WebDriver();
		driver.browser().navigateToURL("https://www.saucedemo.com/");
	}

}
