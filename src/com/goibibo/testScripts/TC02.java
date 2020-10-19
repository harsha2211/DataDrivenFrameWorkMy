package com.goibibo.testScripts;


import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.goibibo.objectRepo.ObjectRepository;
import com.goibibo.pageObjects.FlightPage;
import com.goibibo.pageObjects.SearchResultsPage;
import com.goibibo.utilities.BrowserObject;
import com.goibibo.utilities.Excel;

public class TC02 {
	WebDriver browser;
	ArrayList<String>data;
  @Test
  public void userIsAbleToInteractWithElements() {
	  FlightPage.enterSourceCity(browser, data.get(0));
	  FlightPage.destinationCity(browser, data.get(1));
	  FlightPage.selectDate(browser, data.get(2));
	  FlightPage.clickSearch(browser);
	  assertTrue(SearchResultsPage.checkResultsExist(browser));
	  
  }
  
  @BeforeMethod
  public void setup() throws Exception {
	  browser=BrowserObject.get(ObjectRepository.browserName);
	  browser.get(ObjectRepository.url);
	  data=Excel.getRowData("TC02", 1);
}
  @AfterMethod
  public void close() {
	  browser.close();
}
}