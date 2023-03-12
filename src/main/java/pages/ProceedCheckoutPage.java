package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class ProceedCheckoutPage {

	private SHAFT.GUI.WebDriver driver;

	public ProceedCheckoutPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private final By checkoutBtn = By.id("checkout");
	private final By firstNameTxt = By.id("first-name");
	private final By lastNameTxt = By.id("last-name");
	private final By zipCodeTxt = By.id("postal-code");
	private final By continueBtn = By.id("continue");
	private final By finishOrder = By.id("finish");
	private final By assertionMessage = By.xpath("//h2");
	private final By backHomeBtn = By.id("back-to-products");

	public void navigateToCheckout() {
		driver.element().click(checkoutBtn);
	}

	public void fillUserInformation(String firstname, String lastName, String zipCode) {
		driver.element().type(firstNameTxt, firstname);
		driver.element().type(lastNameTxt, lastName);
		driver.element().type(zipCodeTxt, zipCode);
		driver.element().click(continueBtn);
	}

	public void setFinishOrder() {
		driver.element().click(finishOrder);
	}

	public String getAssertionMessage() {
		return driver.element().getText(assertionMessage);
	}
	
	public By getAssertionMessageLocator() {
		return assertionMessage;
	}
	
	
	public void setBackHomeBtn() {
		driver.element().click(backHomeBtn);
	}

}
