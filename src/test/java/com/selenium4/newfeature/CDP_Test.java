package com.selenium4.newfeature;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.openqa.selenium.devtools.v85.security.Security;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Optional;

public class CDP_Test extends BaseTest
{
    //Geolocation
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
        DevTools devTools = ((ChromeDriver)driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(false,100000,100000,100000, Optional.of(ConnectionType.CELLULAR2G)));

        driver.get("https://facebook.com");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
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
    @Test
    public void shouldBeAbleToCaptureNetworkRequests()
    {
        DevTools devtools = ((ChromeDriver) driver).getDevTools();
        devtools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

    }

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
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of(".jpg",".png",".jpeg")));

        driver.get("https://amazon.com");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(10));
    }

}
