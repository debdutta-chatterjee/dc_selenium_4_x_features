package com.selenium4.newfeature;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoadStrategy_Test 
{
	
	@Test
	public void shouldBeAbleToExhibitNewPageLoads()
	{
		ChromeOptions chOp= new ChromeOptions();
		chOp.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		long start = System.currentTimeMillis();
		ChromeDriver driver = new ChromeDriver(chOp);
		driver.get("https://www.amazon.com/");
		
		driver.findElement(By.xpath("//a[@aria-label='Amazon']")).click();
		driver.quit();
		long end = System.currentTimeMillis();
		
		System.out.println("Eager::" +(end-start));
		
		
		chOp.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		start = System.currentTimeMillis();
		driver = new ChromeDriver(chOp);
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//a[@aria-label='Amazon']")).click();
		driver.quit();
		end = System.currentTimeMillis();
		
		System.out.println("Normal::" +(end-start));
		
		chOp.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		start = System.currentTimeMillis();
		driver = new ChromeDriver(chOp);
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//a[@aria-label='Amazon']")).click();
		driver.quit();
		end = System.currentTimeMillis();
		
		System.out.println("None::" +(end-start));
	}
}
