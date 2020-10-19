package com.goibibo.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
	public static String getvalue(WebDriver browser) {
		String text= browser.findElement(By.xpath("//span[@class='fb ico16']")).getText();
		 return text;
		
	}
	
	public static boolean checkResultsExist(WebDriver browser) {
		boolean flightExist=false;
		List<WebElement> allResults=browser.findElements(By.xpath("//div[@class='clr']"));
		  if(allResults.size() >0) {
				 flightExist=true;
		  }
		  return flightExist;
	}
	public static boolean checkRoundTripResultsExist(WebDriver browser) {
		boolean flightExist=false;
		List<WebElement> allResults=browser.findElements(By.xpath("//div[@class='fltHpyRWrap dF justifyBetween']/div[@class='fltHpyOnwrdWrp']/div/div"));
		  if(allResults.size() >0) {
				 flightExist=true;
		  }
		  return flightExist;
	}
	
	
	public static void SelectFlightByName(WebDriver browser, String airlineName) {
		  List<WebElement> allResults=browser.findElements(By.xpath("//div[@class='clr']"));
		  for (WebElement result : allResults) {
			 String flightName=result.findElement(By.xpath(".//div[@class='dF width100 alignItemsCenter']")).getText();
			 System.out.println(flightName);
			 if(flightName.equals(airlineName)) {
				 result.findElement(By.xpath(".//input[@data-cy='bookBtn']")).click();
				 break;
			 }
		}
	}
	
	public static void SelectFlightByNameandTime(WebDriver browser, String airlineName,String departureTime) {
		  List<WebElement> allResults=browser.findElements(By.xpath("//div[@class='clr']"));
		  for (WebElement result : allResults) {
			 String flightName=result.findElement(By.xpath(".//div[@class='dF width100 alignItemsCenter']")).getText();
			 System.out.println(flightName);
			 if(flightName.equals(airlineName)) {
		      String time=result.findElement(By.xpath(".//span[@data-cy='depTime']")).getText();
		      if(time.equals(departureTime)) {
		    	  result.findElement(By.xpath(".//input[@data-cy='bookBtn']")).click();
		    	  break;
		    	  
		      }
	
			 }
		}
	}
	public static void SelectRoundTripDepartureFlightByName(WebDriver browser, String airlineName) throws Exception {
		Thread.sleep(5000);
		List<WebElement> allResults=browser.findElements(By.xpath("//div[@class='fltHpyRWrap dF justifyBetween']/div[@class='fltHpyOnwrdWrp']/div/div"));
		//System.out.println(allResults.size());
		String flightName="";
		for (WebElement result : allResults) {
			
		 flightName=result.findElement(By.xpath(".//span[@class='db greyLt ico11 padT3']")).getText();
			//System.out.println(flightName);
			if (flightName.equals(airlineName)) {
				result.findElement(By.xpath(".//*[@class='custRad']/label")).click();
				break;
			}
		}
	}
	
	
		
		
	
	public static void SelectRoundTripReturnFlightByNameDepartureTime(WebDriver browser, String airlineName, String time) throws Exception {
		Thread.sleep(6000);
		List<WebElement> allResults=browser.findElements(By.xpath("//div[@class='fltHpyRWrap dF justifyBetween']/div[@class='fltHpyRtrnWrp']/div/div"));
		//System.out.println(allResults.size());
		String flightName="";
		for (WebElement result : allResults) {
		 flightName=result.findElement(By.xpath(".//*[@class='col-md-3 col-sm-2 col-xs-2 padL10']/span[2]")).getText();
			//System.out.println(flightName);
			if (flightName.equals(airlineName)) {
				String returnTime=result.findElement(By.xpath(".//*[@class='fb ico16 quicks']")).getText();
				System.out.println(returnTime);
				if (returnTime.equals(time)) {
					result.findElement(By.xpath(".//*[@class='custRad']/label")).click();
				break;
				}
				
			
			}
		}	
		
		
	}
		 

}
