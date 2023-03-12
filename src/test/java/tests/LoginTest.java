package tests;
import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;
import com.shaft.driver.SHAFT.TestData.JSON;

import pages.LoginPage;

public class LoginTest extends TestBase {
	LoginPage log;
	SHAFT.TestData.JSON logData;

	@Test
	public void TestLoginFunction() {
		logData = new JSON("loginData.json");
		log = new LoginPage(driver);
		log.Login(logData.getTestData("name"),logData.getTestData("password"));
		driver.assertThat().element(log.getAssertionMessageLocator()).text().contains("Swag Labs").perform();
	}

}
