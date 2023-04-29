package com.selenium4.browser.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverFactory 
{
	public static WebDriver getDriver()
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}
}
