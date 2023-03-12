package tests;
import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;
import com.shaft.driver.SHAFT.TestData.JSON;

import pages.AddToCartPage;
import pages.LoginPage;

public class AddToCartTest extends TestBase {
	LoginPage log;
	AddToCartPage add;
	SHAFT.TestData.JSON logData;

	@Test
	public void TestLoginFunction() {
		logData = new JSON("loginData.json");
		log = new LoginPage(driver);
		log.Login(logData.getTestData("name"), logData.getTestData("password"));
		driver.assertThat().element(log.getAssertionMessageLocator()).text().contains("Swag Labs").perform();
	}

	@Test(priority = 1)
	public void navigateToProductPage() {
		add = new AddToCartPage(driver);
		add.navigateToProduct();
		driver.assertThat().element(add.getappearanceAssertionLocator()).text().contains("Sauce Labs Backpack").perform();
	}

	@Test(priority = 2)
	public void add_productToCart() {
		add = new AddToCartPage(driver);
		add.addProductToCart();
		driver.assertThat().element(add.getassertionMessageLocator()).text().contains("$29.99").perform();
	}

}
