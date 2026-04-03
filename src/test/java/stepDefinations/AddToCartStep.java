package stepDefinations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.*;
import base.Base;
import org.testng.Assert;
import pageObjects.*;
public class AddToCartStep extends Base {
	PriceFilterPage priceFilterPage;
	String userFlower;
	String userQuantity;
	private static final Logger logger =
			LogManager.getLogger(AddToCartStep.class);
	@Given("user is on the search page and clear filter is applied")
	public void user_is_on_the_search_page_and_clear_filter_is_applied() {
	    try {
	    			Thread.sleep(3000);
	    			priceFilterPage=new PriceFilterPage(driver);
	    	        System.out.println("REACHED CART");
	    	 		Thread.sleep(3000);
			    priceFilterPage.getClearFilter().click();
			    Thread.sleep(3000);
			    System.out.println("CLEAR FILTER");
			    logger.debug("clear filter is applied");	   
	    	
	    }catch(Exception ex)
	    {
			logger.error("Exception occurred:"+ex.getMessage());

	    }
	}
	@When("user search flower {string} and quantity {string}")
	public void user_search_flower_and_quantity(String flower, String quantity) {
		try {
			userFlower=flower;
			userQuantity=quantity;
			   System.out.println("REACHED METHOD2"+flower);
			priceFilterPage.getInputSearch()
		    .sendKeys(flower);
		    Thread.sleep(3000);
		    for(int i=1;i<=Integer.parseInt(quantity);i++)
		    {
		    		priceFilterPage.getAddToCardBtn().click();
		    		Thread.sleep(3000);
		    }		    		
		    logger.debug("item added to cart");
		    Thread.sleep(3000);
		}
		catch(Exception ex)
		{
			logger.error("Exception occurred:"+ex.getMessage());

		}
	   
	}
	@Then("validate correct item is added")
	public void validate_correct_item_is_added() {
		try {
			 priceFilterPage.getCartBtn().click();
			    Thread.sleep(3000);
			    String flower=priceFilterPage.getItemName().getText();
			    System.out.println("FLOWER:"+flower);
			    Assert.assertTrue(flower.equals(userFlower));
			    logger.debug("CORRECT ITEM GOT ADDED TO CART ");

			   
			
		}catch(Exception ex)
		{
			logger.error("Exception occurred:"+ex.getMessage());

		}
	   
	}
	@Then("validate correct item quantity")
	public void validate_correct_item_quantity() {
		try {
			Thread.sleep(3000);
			 String quantity=priceFilterPage.getItemQuantity().getText();
			    quantity=quantity.replaceAll("x","");
			    System.out.println(quantity);
			    Assert.assertTrue(quantity.equals(userQuantity));
			    logger.debug("CORRECT QUANTITY GOT ADDED TO CART ");
			    //ASSERTION
			    logger.debug("TEST CASE IS PASSED");
		}
		catch(Exception ex)
		{
			logger.error("Exception occurred:"+ex.getMessage());
		}
	  
	}



}
