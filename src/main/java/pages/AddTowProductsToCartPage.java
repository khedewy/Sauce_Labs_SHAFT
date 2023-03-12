package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class AddTowProductsToCartPage {
	private SHAFT.GUI.WebDriver driver;

	public AddTowProductsToCartPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private final By continueShoppingBtn = By.id("continue-shopping");
	private final By secondProduct = By
			.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Fleece Jacket']");
	private final By secondProductAppearanceAssertion = By.xpath("//div[@class='inventory_details_name large_size']");
	private final By addSecondProductToCartBtn = By.id("add-to-cart-sauce-labs-fleece-jacket");
	private final By showCartBtn = By.xpath("//a[@class='shopping_cart_link']");
	private final By secondProductAssertionMessage = By
			.xpath("//div[@class='inventory_item_price' and text()='49.99']");

	public void setContinueShopping() {
		driver.element().click(continueShoppingBtn);
	}

	public void navigateToSecondProduct() {
		driver.element().click(secondProduct);
	}

	public String getSecondProductAppearanceAssertionMessage() {
		return driver.element().getText(secondProductAppearanceAssertion);
	}
	
	public By getSecondProductAppearaanceLoctor() {
		return secondProductAppearanceAssertion;
	}

	public void addSecondProductToCart() {
		driver.element().click(addSecondProductToCartBtn);
		driver.element().click(showCartBtn);
	}

	public String getSecondProductAssertionMessage() {
		return driver.element().getText(secondProductAssertionMessage);
	}
	
	public By getSeconProductAssertionLocator() {
		return secondProductAssertionMessage;
	}

}
