package base;

import org.openqa.selenium.*;
import java.util.*;
import java.io.*;
public class Base {
	public static WebDriver driver;
	
	public String getUrl() throws Exception
	{
		Properties prop=new Properties();
		prop.load(new FileInputStream
		("D:\\eclipse-workspace2\\framework_ed_2\\"
				+ "src\\main\\java\\data.properties"));
		return prop.getProperty("url");
	}

}
