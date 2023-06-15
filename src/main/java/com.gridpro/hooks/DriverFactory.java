package com.gridpro.hooks;

import com.gridpro.api.GridProConstant;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private DesiredCapabilities desiredCapabilities;

    public DriverFactory() {
        desiredCapabilities = new DesiredCapabilities();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void initializeBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver(setChromeOptions());
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GridProConstant.PROPERTIES_CONFIG.maxPageLoadTimeoutInSec()));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GridProConstant.PROPERTIES_CONFIG.maxPageLoadTimeoutInSec()));
            desiredCapabilities.setPlatform(Platform.ANY);
            desiredCapabilities.setBrowserName("chrome");
        }

//        if (browserType.equalsIgnoreCase("edge")) {
//            driver = new EdgeDriver(setEdgeOptions());
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GridProConstant.PROPERTIES_CONFIG.maxPageLoadTimeoutInSec()));
//            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GridProConstant.PROPERTIES_CONFIG.maxPageLoadTimeoutInSec()));
//        }
    }

    public WebDriver setAndGetDriver() {
//        if (GridProConstant.PROPERTIES_CONFIG.browserType().equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            initializeBrowser("chrome");
            return getDriver();
        }

//    public ChromeOptions setChromeOptions() {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        if (GridProConstant.PROPERTIES_CONFIG.headless())
//            chromeOptions.addArguments("--headless");
//        chromeOptions.addArguments("start-maximized");
//        chromeOptions.setAcceptInsecureCerts(true);
//        chromeOptions.merge(desiredCapabilities);
//        return chromeOptions;
//    }
//
//    public EdgeOptions setEdgeOptions() {
//        EdgeOptions edgeOptions = new EdgeOptions();
//        if (GridProConstant.PROPERTIES_CONFIG.headless())
//            edgeOptions.addArguments("--headless");
//        edgeOptions.addArguments("start-maximized");
//        edgeOptions.setAcceptInsecureCerts(true);
//        return edgeOptions;
//    }
    }
//}
