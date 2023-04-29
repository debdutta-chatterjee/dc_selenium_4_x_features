package com.selenium4.browser.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory 
{
	public static WebDriver getDriver()
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
}
