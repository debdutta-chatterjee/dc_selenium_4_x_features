package com.selenium4.newfeature;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.util.concurrent.Uninterruptibles;

public class Screenshots_Test extends BaseTest
{
	
	@Test
	public void shouldBeAbleToTakeElementScreenshot() throws IOException
	{
		driver.get("https://www.google.com");
		
		WebElement we = wait.until((d) -> d.findElement(By.name("q")));
		we.sendKeys("Hi Text");
		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
		File ss = we.getScreenshotAs(OutputType.FILE);
		
		String targetPath = System.getProperty("user.dir") + File.separator + "Screenshot" 
				+ File.separator + "element_screenshot" + 
					System.currentTimeMillis() +".png" ;
		
		File target = new File(targetPath);
		
		FileUtils.copyFile(ss, target);		
	}
	
	@Test
	public void shouldBeAbleToTakeFullPageScreenshot() throws IOException
	{
		driver.get("https://www.flipkart.com/");
		
		File ss_full;
		
		if(driver instanceof FirefoxDriver)		
			ss_full = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
		else
			ss_full = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String targetPath = System.getProperty("user.dir") + File.separator + "Screenshot" 
				+ File.separator + "page_screenshot" + 
					System.currentTimeMillis() +".png" ;
		
		File target = new File(targetPath);
		
		FileUtils.copyFile(ss_full, target);		
	}
	
}
