package com.goibibo.testScripts;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.goibibo.objectRepo.ObjectRepository;
import com.goibibo.pageObjects.FlightPage;
import com.goibibo.pageObjects.SearchResultsPage;
import com.goibibo.utilities.BrowserObject;
import com.goibibo.utilities.CaptureScreenShot;
import com.goibibo.utilities.Excel;
import com.goibibo.utilities.ScrollPage;
import com.goibibo.utilities.Excel;

public class TC04 {
	WebDriver browser;
	ArrayList<String> data;
	SoftAssert sa;
	@BeforeMethod
	public void roundTrip() throws Exception {
		  browser=BrowserObject.get(ObjectRepository.browserName);
		  browser.get(ObjectRepository.url);
		   data=Excel.getRowData("TC04", 0);
		   sa=new SoftAssert();
	}
  @Test
  public void roundgoibibo() throws Exception {
	  FlightPage.selectTripType(browser,data.get(0));
	  FlightPage.enterSourceCity(browser,data.get(1));
	  FlightPage.destinationCity(browser,data.get(2));
	  FlightPage.selectDate(browser,data.get(3));
	  FlightPage.selectDate(browser,data.get(4));
	  FlightPage.clickSearch(browser);
	 // assertTrue(SearchResultsPage.checkRoundTripResultsExist(browser));
	  sa.assertTrue(SearchResultsPage.checkRoundTripResultsExist(browser));
	  SearchResultsPage.SelectRoundTripDepartureFlightByName(browser,data.get(5));
	  ScrollPage.scrollVericalByPixel(browser, "-1000");
	  SearchResultsPage.SelectRoundTripReturnFlightByNameDepartureTime(browser,data.get(6),data.get(7));
	  sa.assertAll();
  }
  @AfterMethod
   public void close(ITestResult testResult) throws Exception {
	  if(testResult.getStatus()==ITestResult.FAILURE) {
		  CaptureScreenShot.asFile(browser,testResult.getName());
	  }
	  
	  browser.close();
  }
}
