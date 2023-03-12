package tests;
import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;
import com.shaft.driver.SHAFT.TestData.JSON;

import pages.AddToCartPage;
import pages.AddTowProductsToCartPage;
import pages.LoginPage;
import pages.UpdateCartPage;

public class UpdateCartTest extends TestBase {
	LoginPage log;
	AddToCartPage add;
	AddTowProductsToCartPage tow;
	UpdateCartPage update;
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
		driver.assertThat().element(add.getappearanceAssertionLocator()).text().contains("Sauce Labs Backpack")
				.perform();
	}

	@Test(priority = 2)
	public void add_productToCart() {
		add = new AddToCartPage(driver);
		add.addProductToCart();
		driver.assertThat().element(add.getassertionMessageLocator()).text().contains("$29.99").perform();
	}

	@Test(priority = 3)
	public void continueShopping() {
		tow = new AddTowProductsToCartPage(driver);
		tow.setContinueShopping();
	}

	@Test(priority = 4)
	public void navigateToSecondProduct() {
		tow = new AddTowProductsToCartPage(driver);
		tow.navigateToSecondProduct();
		driver.assertThat().element(tow.getSecondProductAppearaanceLoctor()).text().contains("Sauce Labs Fleece Jacket")
				.perform();
	}

	@Test(priority = 5)
	public void addSecondProductToCart() {
		tow = new AddTowProductsToCartPage(driver);
		tow.addSecondProductToCart();
		driver.assertThat().element(tow.getSeconProductAssertionLocator()).text().contains("$49.99").perform();
	}
	
	@Test(priority = 6)
	public void updateCart() {
		update = new UpdateCartPage(driver);
		update.removeProduct();
		driver.assertThat().element(update.getAssertionMessageLocator()).text().contains("1");
	}

}
