package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class LoginPage {
	private SHAFT.GUI.WebDriver driver;

	public LoginPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private final By userNameTxt = By.id("user-name");
	private final By passwordTxt = By.id("password");
	private final By loginBtn = By.id("login-button");
	private final By assertionMessage = By.xpath("//div[@class='app_logo']");

	public void Login(String name, String password) {
		driver.element().type(userNameTxt, name);
		driver.element().type(passwordTxt, password);
		driver.element().click(loginBtn);
	}

	public String getAssertionMessage() {
		return driver.element().getText(assertionMessage);
	}
	
	
	public By getAssertionMessageLocator() {
		return assertionMessage;
	}
}

