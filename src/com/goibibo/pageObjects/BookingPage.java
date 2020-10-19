package com.goibibo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookingPage {
	
	public static String getText(WebDriver browser) {
		String text=browser.findElement(By.xpath("//span[@class='fl padLR10 padT5 ico18 quicks fb']")).getText();
		return text;
	}
	
	public static void details(WebDriver browser) {
		browser.findElement(By.id("secure-trip")).click();
		WebElement title =browser.findElement(By.id("Adulttitle1"));
		Select a=new Select(title);
		a.selectByIndex(2);
		
		browser.findElement(By.id("AdultfirstName1")).sendKeys("Harsha");
		browser.findElement(By.id("AdultlastName1")).sendKeys("Sahastrabudhe");
		browser.findElement(By.name("email")).sendKeys("harsha.sahastrabudhe@gmail.com");
		browser.findElement(By.name("mobile")).sendKeys("8839256295");
		browser.findElement(By.xpath("//button[@class='button orange col-md-3 fr large dF justifyCenter min37']")).click();
		
		
		
		
	}

}
