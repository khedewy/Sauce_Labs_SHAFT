package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class AddToCartPage {
	private SHAFT.GUI.WebDriver driver;
	public AddToCartPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}
	
	private final By firstProduct = By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']");
    private final By productAppearanceAssertion = By.xpath("//div[@class='inventory_details_name large_size']");
    private final By addToCartBtn = By.name("add-to-cart-sauce-labs-backpack");
    private final By showCartBtn = By.xpath("//a[@class='shopping_cart_link']");
    private final By AssertionMessage = By.xpath("//div[@class='inventory_item_price']");

    public void navigateToProduct(){
        driver.element().click(firstProduct);
    }

    public String getProductAppearanceAssertion(){
       return driver.element().getText(productAppearanceAssertion);
    }
    
    public By getappearanceAssertionLocator() {
    	return productAppearanceAssertion;
    }

    public void addProductToCart(){
        driver.element().click(addToCartBtn);
        driver.element().click(showCartBtn);
    }

    public String getAssertionMessage(){
        return driver.element().getText(AssertionMessage);
    }
    
    public By getassertionMessageLocator() {
    	return AssertionMessage;
    }

}
