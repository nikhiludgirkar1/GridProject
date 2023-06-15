package com.gridpro.definitions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
    public WebDriver driver;
    public WebDriver getDriver(String browser) throws MalformedURLException {
        //Set Browser Type
        DesiredCapabilities caps = null;
        if (browser == "chrome") {
            caps.setBrowserName("chrome");
        } else if (browser == "firefox") {
            caps.setBrowserName("firefox");
        }
        caps.setPlatform(Platform.WINDOWS);
        return driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
    }
}
