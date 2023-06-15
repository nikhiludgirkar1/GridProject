//package com.demoproject.definitions;
//
//import java.net.MalformedURLException;
////import java.sql.DriverManager;
//
//import org.junit.After;
//import org.junit.jupiter.api.Test;
//
//import com.demoproject.hooks.DriverFactory;
//
//public class ParallelTest1 extends DriverManager {
//    @Test
//    public void testChrome1() throws MalformedURLException {
//        driver = new DriverManager().getDriver("chrome");
//        driver.navigate().to("http://www.facebook.com/");
//        driver.manage().window().maximize();
//    }
//    //Firefox Test
//    @Test
//    public void testFirefox1() throws MalformedURLException {
//        driver = new DriverManager().getDriver("firefox");
//        driver.navigate().to("http://www.amazon.com/");
//        driver.manage().window().maximize();
//    }
//    @After
//    public void quitDriver() {
//        driver.quit();
//    }
//}
