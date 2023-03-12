package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class UpdateCartPage {
	
		private SHAFT.GUI.WebDriver driver;

		public UpdateCartPage(SHAFT.GUI.WebDriver driver) {
			this.driver = driver;
		}

		private final By removeProductBtn = By.id("remove-sauce-labs-backpack");
		private final By removeAssertionMessage = By.xpath("//span[@class='shopping_cart_badge']");

		public void removeProduct() {
			driver.element().click(removeProductBtn);
		}

		public String getAssertionMessage() {
			return driver.element().getText(removeAssertionMessage);
		}

		public By getAssertionMessageLocator() {
			return removeAssertionMessage;
		}

	


}
