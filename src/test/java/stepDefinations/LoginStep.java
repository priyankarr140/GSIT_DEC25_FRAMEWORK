package stepDefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class LoginStep extends Base{
	LoginPage loginPage;
private static final Logger logger =
LogManager.getLogger(LoginStep.class);
	@Given("user is home page")
	public void user_is_home_page() {
		try {
			logger.debug("Reached Method");
			driver.get(this.getUrl());
			logger.debug("URL Launched");
		    driver.manage().window().maximize();
		    logger.debug("Window Maximized");
		    Thread.sleep(3000);
			
		}
		catch(Exception ex)
		{
			logger.error("Exception occurred:"+ex.getMessage());
		}
			    
	   
	}
	@When("clicks login")
	public void clicks_login() {
		try {
			  loginPage=new LoginPage(driver);
			    loginPage.getSignUpAndInBtn().click();
			    Thread.sleep(3000);
			    loginPage.getSignInBtn().click();
			    Thread.sleep(3000);
			
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
			    Thread.sleep(3000);
			    loginPage.getPassword().sendKeys(password);
			    Thread.sleep(3000);
			
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
			    logger.debug("User is successfully logged in");
			    Thread.sleep(3000);
			
		}
		catch(Exception ex)
		{
			logger.error("Exception occurred:"+ex.getMessage());
		}
	   
	}



}
