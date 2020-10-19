package com.goibibo.testScripts;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.goibibo.objectRepo.ObjectRepository;
import com.goibibo.pageObjects.FlightPage;
import com.goibibo.utilities.BrowserObject;
import com.goibibo.utilities.CaptureScreenShot;
import com.goibibo.utilities.Excel;

public class TC01 {
	WebDriver browser;
	ArrayList<String>data;
  @Test
  public void defaultPageIsFlightSearch() {
	assertEquals(FlightPage.getTextOfDefaultPage(browser), data.get(0));  
  }
  @BeforeMethod
  public void setup() throws Exception {
	  browser=BrowserObject.get(ObjectRepository.browserName);
	  browser.get(ObjectRepository.url);
	  data=Excel.getRowData("TC01", 1);
  }
  @AfterMethod
  public void close(ITestResult testresult) throws Exception {
	  if(testresult.getStatus()== ITestResult.FAILURE) {
		  CaptureScreenShot.asFile(browser,testresult.getName());
	  }
	  browser.close();
  }
}
