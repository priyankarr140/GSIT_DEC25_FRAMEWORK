package stepDefinations;
import org.apache.logging.log4j.LogManager;
import org.testng.asserts.*;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.*;
import base.Base;
import org.testng.Assert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;
import java.util.*;
import pageObjects.*;
public class ValidateFilterByPriceStep extends Base{
	PriceFilterPage priceFilterPage;
	 WebElement filterByPrice;
	 String inputRange;
	 List<WebElement>flowerList=new ArrayList<>();
	private static final Logger logger =
		LogManager.getLogger(ValidateFilterByPriceStep.class);
	@Given("user is on search screen")
	public void user_is_on_search_screen() {
		try {
			 	Thread.sleep(3000);
			    driver.get("https://www.engineerdiaries.com/framework");
			    Thread.sleep(3000);			
		}
		catch(Exception ex)
		{
			logger.debug("Exception occurred:"+ex.getMessage());
		}
	    
	}
	@When("dropdown Filter by price is clicked")
	public void dropdown_filter_by_price_is_clicked() {
		try {
			 	 priceFilterPage=new PriceFilterPage(driver);
			    priceFilterPage.getInStockCheckbox().click();
			    Thread.sleep(3000);
			     filterByPrice=priceFilterPage.getPriceFilter();			
		}
		catch(Exception ex)
		{
			logger.debug("Exception occurred:"+ex.getMessage());
		}
	   
	}
	@When("Range {string} is selected")
	public void range_is_selected(String range) {
		try {
			    inputRange=range;
			    Select selectFilter=new Select(filterByPrice);
			    selectFilter.selectByContainsVisibleText(inputRange);
			    Thread.sleep(3000);
			    flowerList=priceFilterPage.getItemCard();
			    System.out.println("size:"+flowerList.size());
			    		
			
		}
		catch(Exception ex)
		{
			logger.debug("Exception occurred:"+ex.getMessage());
		}
	    
	}
	@Then("price is validated")
	public void price_is_validated() {
		try 
		{
			for(int i=1;i<=flowerList.size();i++)
		    {	   
		     String text=driver
		     .findElement
		     (By.xpath("(//p[contains(@data-testid,'flower-price')])["+i+"]"))
		    	 .getText();
		     text=text.replaceAll("[^0-9]","");
		    // Assert.assertT
		     System.out.println(text);
		     //ADD ASSERTION
		    
		     if(inputRange.equals("Below ₹60") && !text.isEmpty())
		     {
			        int value = Integer.parseInt(text);
			        // Assertion
			        Assert.assertTrue(value < 60, "Value is not less than 60");
		     }
		     else if(inputRange.equals("₹60 - ₹70") && !text.isEmpty())
		     {
		    	 int value = Integer.parseInt(text);
			        // Assertion
			        Assert.assertTrue(value >= 60, "Value is not less than 60");
			        Assert.assertTrue(value <= 70, "Value is not greater than 70");

		     
		     }
		     else if(inputRange.equals("Above ₹70") && !text.isEmpty())
		     {
		    	 		int value = Integer.parseInt(text);
			        // Assertion
			        Assert.assertTrue(value >= 70, "Value is not greater than 70");
		     
		     }
		        // Extract number		     
		    }
		    logger.debug("PRICE FILTER FOR "+inputRange+" is working");
		    Thread.sleep(3000);

		}
		catch(Exception ex)
		{
			logger.debug("Exception occurred:"+ex.getMessage());
		}
	   
	}


}
