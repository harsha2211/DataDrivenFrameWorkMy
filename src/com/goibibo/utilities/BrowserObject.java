package com.goibibo.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserObject {
	
	 
	public static WebDriver get(String browserName) throws Exception {
		WebDriver browser;
		 if (browserName.equals("chrome")){
			 System.setProperty("webdriver.chrome.driver" ,"C:\\Users\\deepesh\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe" );
			 browser=new ChromeDriver(); 
		 }
		 
		 else if (browserName.equals("firefox")) {
			 System.setProperty("webdriver.gecko.driver" ,"C:\\Users\\deepesh\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe" );
			 browser=new FirefoxDriver();  
		 }
		 else {
			 
			 throw new Exception ("Invalid browser name");
		 }
		  browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  browser.manage().window().maximize();
		  return browser;
		
	}

}
