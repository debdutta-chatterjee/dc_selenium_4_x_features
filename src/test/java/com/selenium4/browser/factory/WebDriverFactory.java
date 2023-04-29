package com.selenium4.browser.factory;

import java.util.function.Supplier;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory 
{
	private static final Supplier<WebDriver> chrome =  () -> ChromeDriverFactory.getDriver();
	private static final Supplier<WebDriver> firefox =  () ->  FirefoxDriverFactory.getDriver();
	
	private static final Map<String,Supplier<WebDriver>> driverMap = Map.of(
			"chrome",chrome,
			"firefox",firefox			
			);
	
	
	public static WebDriver initiateDriver(String browser)
	{
		return driverMap.get(browser).get();
	}
	
}
