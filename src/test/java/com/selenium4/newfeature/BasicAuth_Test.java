package com.selenium4.newfeature;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.testng.annotations.Test;

import java.net.URI;
import java.time.Duration;
import java.util.function.Predicate;

public class BasicAuth_Test extends BaseTest
{
    @Test
    public void shouldBEAbleToHandleBasicAuth()
    {
        Predicate<URI> uri = (u) -> u.getHost().contains("httpbin");
        ((HasAuthentication) driver).register(uri, UsernameAndPassword.of("foo","bar"));

        driver.get("http://httpbin.org/basic-auth/foo/bar");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
    }
}
