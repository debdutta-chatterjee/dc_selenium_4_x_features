package com.selenium4.newfeature;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.security.Security;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

public class CDP_Test extends BaseTest
{
    //Geo location
    @Test
    public void shouldBeAbleToEmulateGeoLocation()
    {
        HashMap<String,Object> location = new HashMap<>();
        location.put("longitude",27.50);
        location.put("latitude",-82.11);
        location.put("Accuracy",70);
        DevTools dt = ((ChromeDriver) driver).getDevTools();
        dt.createSession();

        ((ChromeDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride",location);

        driver.get("https://mycurrentlocation.net/");
        //wait.until(d -> d.findElement(By.cssSelector("button[data-ya-track=\"geolocate\"]"))).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
    }

    //Network condition
    @Test
    public void shouldBeAbleToEmulateNetworkCondition()
    {

    }

    //Device emulation
    @Test
    public void shouldBeAbleToEmulateDeviceMetrics()
    {
        DevTools dt = ((ChromeDriver) driver).getDevTools();
        dt.createSession();

        HashMap<String,Object> deviceMap = new HashMap<>();
        deviceMap.put("height",500);
        deviceMap.put("width",200);
        deviceMap.put("deviceScaleFactor",100);
        deviceMap.put("mobile",true);

        ((ChromeDriver) driver).executeCdpCommand("Emulation.setDeviceMetricsOverride",deviceMap);
        driver.get("https://www.flipkart.com");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
    }

    //Capture network requests

    //SSL certificate
    @Test
    public void shouldBeAbleToByPassSSLCertificateError()
    {
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.send(Security.enable());
        devTools.send(Security.setIgnoreCertificateErrors(true));

        driver.get("https://expired.badssl.com");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
    }

    //Alert handling
    @Test
    public void shouldBeAbleToHandleAlertsAutomatically()
    {

    }

    //NetworkIntercept
    @Test
    public void shouldBeAbleToInterceptNetworkRequest()
    {

    }

}
