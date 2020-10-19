package com.goibibo.testScripts;



import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.goibibo.objectRepo.ObjectRepository;
import com.goibibo.pageObjects.BookingPage;
import com.goibibo.pageObjects.FlightPage;
import com.goibibo.pageObjects.SearchResultsPage;
import com.goibibo.utilities.BrowserObject;
import com.goibibo.utilities.Excel;

public class TC {
	WebDriver browser;
  @Test
  public void f() throws Exception {
  browser=BrowserObject.get(ObjectRepository.browserName);
  browser.get(ObjectRepository.url);
  ArrayList<String> inputData=Excel.getRowData(ObjectRepository.flightSearchSheet, ObjectRepository.firstRow);
 // FlightPage.selectTripType(browser, inputData.get(0));
  FlightPage.enterSourceCity(browser, inputData.get(1));
  FlightPage.destinationCity(browser, inputData.get(2));
  FlightPage.selectDate(browser, inputData.get(3));
 // FlightPage.selectDate(browser, inputData.get(4));
  FlightPage.clickSearch(browser);
  assertEquals(SearchResultsPage.getvalue(browser), "Filters");
  SearchResultsPage.SelectFlightByNameandTime(browser, "Spicejet","07:20");
  assertEquals(BookingPage.getText(browser), "Ticket Details");
  BookingPage.details(browser);
 
  
  }
  
 
}
