package com.goibibo.pageObjects;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightPage {
	
	public static void selectTripType(WebDriver browser,String tripType) {
		String locator=" ";
		if (tripType.equals("round")) {
			locator="roundTrip";
		}
		
		else if(tripType.equals("multiCity")) {
			locator="multiCity";
		}
		
		browser.findElement(By.id(locator)).click();	
		}
	
		 public static void enterSourceCity(WebDriver browser,String cityName) {
			 browser.findElement(By.id("gosuggest_inputSrc")).sendKeys(cityName);
			 browser.findElement(By.xpath("//ul[@id='react-autosuggest-1']/li")).click();
	    }
	
         public static void destinationCity(WebDriver browser,String destinationCityName) {
        	 
        	browser.findElement(By.id("gosuggest_inputDest")).sendKeys(destinationCityName);
        	browser.findElement(By.xpath("//ul[@id='react-autosuggest-1']/li")).click();
         }
         
         public static void selectDate(WebDriver browser,String dateOfDeparture) {
        	 String monthYear=getMonthYearInString(dateOfDeparture);
        	String currentMY= browser.findElement(By.xpath("//div[@class='DayPicker-Month']/div")).getText();
        	while(! currentMY.equals(monthYear)) {
        		browser.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
        		currentMY= browser.findElement(By.xpath("//div[@class='DayPicker-Month']/div")).getText();
        	}
        	if(currentMY.equals(monthYear)) {
        		browser.findElement(By.id("fare_"+dateOfDeparture)).click();
        	}
        	
        	
         }
         
          public static  String getMonthYearInString(String inputDate) {
       	  HashMap<String, String> mmToMonth=new HashMap<String, String>();
       	  mmToMonth.put("01", "January");
       	  mmToMonth.put("02", "Fabruary");
       	  mmToMonth.put("03", "March");
       	  mmToMonth.put("04", "April");
       	  mmToMonth.put("05", "May");
       	  mmToMonth.put("06", "June");
       	  mmToMonth.put("07", "July");
       	  mmToMonth.put("08", "August");
       	  mmToMonth.put("09", "September");
       	  mmToMonth.put("10", "October");
       	  mmToMonth.put("11", "November");
       	  mmToMonth.put("12", "December");
       	  String mm=inputDate.substring(4,6);
       	  String yr=inputDate.substring(0,4);
       	  String month=mmToMonth.get(mm);
       	  
       	     return month+" "+ yr;
       	  
         }
          
          public static void clickSearch(WebDriver browser) {
        	  browser.findElement(By.id("gi_search_btn")).click();
        	  
          }
          
          public static String getTextOfDefaultPage(WebDriver browser) {
         String text=browser.findElement(By.xpath("//h1[@class='txtCenter white ico30 txtCap']")).getText();
        	return text;
        	 
          }
        
         
         
         
         
         
         
         
         
}
