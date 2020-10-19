package com.goibibo.testScripts;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.goibibo.utilities.BrowserObject;
import com.goibibo.utilities.CaptureScreenShot;

public class ScreenShotExample {
  @Test
  public void f() throws Exception {
	  WebDriver browser=BrowserObject.get("chrome");
	  browser.get("https://www.amazon.in/");
	  Thread.sleep(3000);
	  JavascriptExecutor js=(JavascriptExecutor) browser;
	  
	  WebElement signIn=browser.findElement(By.linkText("Sign in"));
	  js.executeScript("arguments[0].scrollIntoView();",signIn);
	  signIn.click();
	 browser.findElement(By.name("email")).sendKeys("harsha@abcd");
	  browser.findElement(By.id("continue")).click();
	 //TakesScreenshot ss=(TakesScreenshot) browser;
  //File takeScreen=ss.getScreenshotAs(OutputType.FILE);
	 // FileUtils.copyFile(takeScreen, new File("E:\\java class radical technology\\DataDrivenFramework\\src\\com\\goibibo\\Screenshots\\amazon.jpg"));
	  CaptureScreenShot.asFile(browser, "amazon");
  }
}
