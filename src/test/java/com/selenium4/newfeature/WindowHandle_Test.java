package com.selenium4.newfeature;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class WindowHandle_Test extends BaseTest
{
	@Test
	public void shouldBeAbleToOpenNewTabt() throws IOException
	{
		driver.get("https://www.flipkart.com/");
		String base = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB);
		ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(handles.get(1));
		driver.get("https://www.amazon.com/");
		driver.close();
				
		driver.switchTo().window(base);
		driver.switchTo().newWindow(WindowType.WINDOW);
		handles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(handles.get(1));
		driver.get("https://www.amazon.com/");
		driver.close();
		
		driver.switchTo().window(base);
		driver.get("https://www.google.com/");
	}
}
