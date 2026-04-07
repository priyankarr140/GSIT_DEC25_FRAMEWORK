package hooks;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.*;


import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import java.net.*;
import org.openqa.selenium.remote.*;
public class ScenarioHook extends Base{

	RemoteWebDriver remoteDriver;
	@Before
	public void setup()
	{
		
			try {
				String browser=this.getBrowser();
				
				//System.out.println("java -jar src/main/resources/selenium-server-4.41.0.jar standalone");
				if (browser.equals("chrome")) {
			      // driver = new ChromeDriver();  
					//System.out.println("***REACHED IF");
					 ChromeOptions options = new ChromeOptions();
					 options.setCapability("platformName", "Windows");

					 remoteDriver = new RemoteWebDriver(
		                    new URL("http://localhost:4444"),options
		                    
		            );
					
			    }
				else if( browser.equals("edge"))
				{
					//grid setup
					 EdgeOptions options = new EdgeOptions();
					 options.setCapability("platformName", "Windows");

					 remoteDriver = new RemoteWebDriver(
		                    new URL("http://localhost:4444"),options
		                    
		            );
					 
				}
				setDriver(remoteDriver);
				System.out.println("GRID STARTED");
				getDriver().manage().timeouts().
		        implicitlyWait(Duration.ofSeconds(10));

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	
	@After
	public void tearDown(Scenario scenario)
	{
		  if (!scenario.isFailed()) {
	            byte[] screenshot =
	                    ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);

	            Allure.addAttachment(
	                    "Screenshot",
	                    new ByteArrayInputStream(screenshot)
	            );
	        }
	    
		getDriver().quit();
	}


}
