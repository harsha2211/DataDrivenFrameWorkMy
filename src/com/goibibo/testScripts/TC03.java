package com.goibibo.testScripts;

import org.testng.annotations.Test;

import com.goibibo.objectRepo.ObjectRepository;
import com.goibibo.pageObjects.FlightPage;
import com.goibibo.pageObjects.SearchResultsPage;
import com.goibibo.utilities.BrowserObject;
import com.goibibo.utilities.Excel;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertFalse;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TC03 {
	WebDriver browser;
	ArrayList<String>data;
  @Test
  public void searchReturnsNoResult() {
	  FlightPage.enterSourceCity(browser, data.get(0));
	  FlightPage.destinationCity(browser, data.get(1));
	  FlightPage.selectDate(browser, data.get(2));
	  FlightPage.clickSearch(browser);
	  assertFalse(SearchResultsPage.checkResultsExist(browser));
	  
  }
  @BeforeMethod
  public void setup() throws Exception {
	  browser=BrowserObject.get(ObjectRepository.browserName);
	  browser.get(ObjectRepository.url);
	  data=Excel.getRowData("TC03", 1);
}
  @AfterMethod
  public void close() {
	  browser.close();
}
}