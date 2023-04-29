package com.selenium4.newfeature;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.selenium4.browser.factory.WebDriverFactory;
import com.util.ConfigLoader;

public class BaseTest 
{	
	WebDriver driver;
	WebDriverWait wait; 
	
	@BeforeTest
	public void setup()
	{
		driver= WebDriverFactory.initiateDriver(
				ConfigLoader.getInstance().getBrowserName());
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
