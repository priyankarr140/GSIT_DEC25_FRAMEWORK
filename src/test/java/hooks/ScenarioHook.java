package hooks;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class ScenarioHook extends Base{
	@Before("@login")
	public void setup()
	{
	    driver=new ChromeDriver();
	}
	
	
	
	
	
	
	
	
	
	/*@After("@filterByPrice")
	public void tearDown(Scenario scenario)
	{
		  if (!scenario.isFailed()) {
	            byte[] screenshot =
	                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

	            Allure.addAttachment(
	                    "Screenshot",
	                    new ByteArrayInputStream(screenshot)
	            );
	        }
	    
		driver.quit();
	}*/


}
