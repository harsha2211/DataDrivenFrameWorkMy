package com.goibibo.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenShot {
	public static void asFile(WebDriver browser, String fileName) throws Exception {
		
	String fileLocation="E:\\java class radical technology\\DataDrivenFramework\\src\\com\\goibibo\\Screenshots\\";
	String ssPath=fileLocation + fileName +".jpg";
 	TakesScreenshot ss=(TakesScreenshot) browser;
	  File grabScreen=ss.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(grabScreen, new File(ssPath));
		  
		
	}

}
