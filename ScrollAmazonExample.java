package com.goibibo.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.goibibo.utilities.BrowserObject;

public class ScrollAmazonExample {
  @Test
  public void f() throws Exception {
	  WebDriver browser=BrowserObject.get("chrome");
	  browser.get("https://www.amazon.in/");
	  JavascriptExecutor js=(JavascriptExecutor) browser;
	  //js.executeScript("window.scrollBy(0,500)");
	 // Thread.sleep(2000);
	  //js.executeScript("window.scrollBy(0,500)");
	  //Thread.sleep(2000);
	  //js.executeScript("window.scrollBy(0,500)");
	  //Thread.sleep(2000);
	  //js.executeScript("window.scrollBy(0,-1000)");
	  Thread.sleep(2000);
	 // WebElement instaLink=browser.findElement(By.linkText("Instagram"));
	 // js.executeScript("arguments[0].scrollIntoView();",instaLink);
	 // WebElement random=browser.findElement(By.xpath("//*[contains(text(), 'Safety & security')]"));
	  //js.executeScript("arguments[0].scrollIntoView();",random);
	  
	  
	  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
  }
  
}
