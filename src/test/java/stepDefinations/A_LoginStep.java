package stepDefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.*;
import base.Base;
import org.testng.Assert;
import pageObjects.*;
public class A_LoginStep extends Base{
	LoginPage loginPage;
	PriceFilterPage priceFilterPage;
private static final Logger logger =
LogManager.getLogger(A_LoginStep.class);
	@Given("user is home page")
	public void user_is_home_page() {
		try {
			logger.debug("Reached Method");
			getDriver().get(this.getUrl());
			//this.get(this.getUrl());
			logger.debug("URL Launched");
			getDriver().manage().window().maximize();
		    logger.debug("Window Maximized");
		   // Thread.sleep(3000);
			
		}
		catch(Exception ex)
		{
			logger.error("Exception occurred:"+ex.getMessage());
		}
			    
	   
	}
	@When("clicks login")
	public void clicks_login() {
		try {
			  loginPage=new LoginPage(getDriver());
			    loginPage.getSignUpAndInBtn().click();
			  //  Thread.sleep(3000);
			    loginPage.getSignInBtn().click();
			    //Thread.sleep(3000);
			
		}
		catch(Exception ex)
		{
			logger.error("Exception occurred:"+ex.getMessage());
		}
	   
	}
	@When("user enters email {string} and password {string}")
	public void user_enters_email_and_password(String email, String password) {
		try {
			 loginPage.getEmail().sendKeys(email);
			    //Thread.sleep(3000);
			    loginPage.getPassword().sendKeys(password);
			    //Thread.sleep(3000);
			
		}
		catch(Exception ex)
		{
			logger.error("Exception occurred:"+ex.getMessage());
		}
	   
	}
	@Then("user is sucessfully logged in")
	public void user_is_sucessfully_logged_in() {
		try {
			  loginPage.getSubmitBtn().click();
			  Thread.sleep(2000);
			  Assert.assertTrue(loginPage.getLoginText().getText().contains("Hi"),"Login failure");
			  logger.debug("User is successfully logged in");
			   // Thread.sleep(3000);
			
		}
		catch(Exception ex)
		{
			logger.error("Exception occurred:"+ex.getMessage());
		}
	   
	}
	@Then("user is on search screen and in stock is checked")
	public void user_is_on_search_screen_and_in_stock_is_checked() {
		try {
			 	Thread.sleep(3000);
			 	getDriver().get(this.getFrameworkUrl());
			    Thread.sleep(3000);
			    priceFilterPage=new PriceFilterPage(getDriver());
			    priceFilterPage.getInStockCheckbox().click();
		}
		catch(Exception ex)
		{
			logger.debug("Exception occurred:"+ex.getMessage());
		}
	    
	}



}
