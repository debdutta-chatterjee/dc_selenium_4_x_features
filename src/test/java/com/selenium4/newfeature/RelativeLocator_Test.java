package com.selenium4.newfeature;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class RelativeLocator_Test extends BaseTest
{
    @Test
    public void shouldBeAbleToSelectEleUsingRelativeLocators()
    {
        driver.get("https://demoqa.com/text-box");

        FluentWait<WebDriver> wait_fluent = new FluentWait<>(driver)
                        .ignoring(NoSuchElementException.class)
                .withMessage("FWait failed!")
                .withTimeout(Duration.ofSeconds(6))
                .pollingEvery(Duration.ofMillis(300))
                ;

        WebElement we  = wait_fluent.until(

                (d) -> d.findElement(RelativeLocator.with((By.id("userName"))).above(By.id("userEmail")))
            );

        driver.findElement(
                RelativeLocator.with(By.id("currentAddress")).below(we))
                .sendKeys("Test");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }
}
