package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import java.util.Arrays;
@CucumberOptions(features = { "src//test//resources//features" }, 
glue = { "stepDefinations","hooks"},
tags= "@login or @filterByPrice or @addCart",
plugin = {
        "pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
})
public class TestRunner extends AbstractTestNGCucumberTests {

	
	@DataProvider(parallel = true)
    public Object[][] scenarios() {
		 return super.scenarios();         
    }
}

