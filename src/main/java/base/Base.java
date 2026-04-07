package base;

import org.openqa.selenium.*;
import java.util.*;
import java.io.*;
public class Base {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver1) {
        driver.set(driver1);
    }
	
	public String getUrl() throws Exception
	{
		Properties prop=new Properties();
		prop.load(new FileInputStream
		("D:\\eclipse-workspace2\\framework_ed_2\\"
				+ "src\\main\\java\\data.properties"));
		return prop.getProperty("url");
	}
	
	
	public String getFrameworkUrl() throws Exception
	{
		Properties prop=new Properties();
		prop.load(new FileInputStream
		("D:\\eclipse-workspace2\\framework_ed_2\\"
				+ "src\\main\\java\\data.properties"));
		return prop.getProperty("frameworkUrl");
	}
	
	
	
	public String getBrowser() throws Exception
	{
		Properties prop=new Properties();
		prop.load(new FileInputStream
		("D:\\eclipse-workspace2\\framework_ed_2\\"
				+ "src\\main\\java\\data.properties"));
		return prop.getProperty("browser");
	}

}
