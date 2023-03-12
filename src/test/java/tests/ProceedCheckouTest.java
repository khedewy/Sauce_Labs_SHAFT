package tests;
import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;
import com.shaft.driver.SHAFT.TestData.JSON;

import pages.AddToCartPage;
import pages.LoginPage;
import pages.ProceedCheckoutPage;

public class ProceedCheckouTest extends TestBase {

	LoginPage log;
	AddToCartPage add;
	ProceedCheckoutPage checkoutPage;
	SHAFT.TestData.JSON logData;
	SHAFT.TestData.JSON proceedData;

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
	public void navigateToProceedCheckout() {
		checkoutPage = new ProceedCheckoutPage(driver);
		checkoutPage.navigateToCheckout();
	}

	@Test(priority = 4)
	public void completeCheckout() {
		proceedData = new JSON("proceedCheckout.json");
		checkoutPage = new ProceedCheckoutPage(driver);
		checkoutPage.fillUserInformation(proceedData.getTestData("firstName"), proceedData.getTestData("lastName"),
				proceedData.getTestData("zipCode"));
	}

	@Test(priority = 5)
	public void finishOrder() {
		checkoutPage = new ProceedCheckoutPage(driver);
		checkoutPage.setFinishOrder();
		driver.assertThat().element(checkoutPage.getAssertionMessageLocator()).text()
				.contains("Thank you for your order!").perform();
		checkoutPage.setBackHomeBtn();
	}

}
