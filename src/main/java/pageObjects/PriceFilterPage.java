package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import java.util.*;

public class PriceFilterPage {
	WebDriver driver;
	By inStockCheckbox=By.xpath("//*[@type='checkbox']");
	By priceFilter=By.tagName("select");
	By itemCard=By.className("hover:shadow-lg");
	By clearFilter=By.xpath("//*[text()='Clear Filters']");
	By inputSearch=By.xpath("//input[@data-testid='search-input']");
	By addToCardBtn=By.xpath("//*[text()='Add to Cart']");
	By cartBtn=By.xpath("//*[@data-testid='toggle-cart']");
	By itemName=By.xpath("//p[@class='font-semibold']");
	By itemQuantity=By.className("text-gray-600");
	
	public PriceFilterPage(WebDriver driver)
	{
		this.driver=driver;
	}

	

	public WebElement getInStockCheckbox() {
		return this.driver.findElement(this.inStockCheckbox);
	}

	public WebElement getPriceFilter() {
		return this.driver.findElement(this.priceFilter);
	}

	public List<WebElement> getItemCard() {
		return this.driver.findElements(this.itemCard);
	}

	public WebElement getClearFilter() {
		return this.driver.findElement(this.clearFilter);
	}

	public WebElement getInputSearch() {
		return this.driver.findElement(this.inputSearch);
	}

	public WebElement getAddToCardBtn() {
		return this.driver.findElement(this.addToCardBtn);
	}

	public WebElement getCartBtn() {
		return this.driver.findElement(this.cartBtn);
	}

	public WebElement getItemName() {
		return this.driver.findElement(this.itemName);
	}

	public WebElement getItemQuantity() {
		return this.driver.findElement(this.itemQuantity);
	}
	
}
