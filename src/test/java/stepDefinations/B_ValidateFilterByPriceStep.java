package stepDefinations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.*;
import base.Base;
import org.testng.Assert;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
import pageObjects.*;
public class B_ValidateFilterByPriceStep extends Base{
	PriceFilterPage priceFilterPage;
	 WebElement filterByPrice;
	 String inputRange;
	 List<WebElement>flowerList=new ArrayList<>();
	private static final Logger logger =
		LogManager.getLogger(B_ValidateFilterByPriceStep.class);
	
	
	@When("Range {string} is selected")
	public void range_is_selected(String range) {
		try {   
			priceFilterPage = new PriceFilterPage(getDriver()); 
			    filterByPrice=priceFilterPage.getPriceFilter();			
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
		     String text=getDriver()
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
		   // Thread.sleep(3000);
		    System.out.println("URL last"+getDriver().getCurrentUrl());

		}
		catch(Exception ex)
		{
			logger.debug("Exception occurred:"+ex.getMessage());
		}
	   
	}


}
