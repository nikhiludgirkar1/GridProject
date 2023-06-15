//package com.gridpro.definitions;
//
//import java.net.MalformedURLException;
//
//import org.junit.After;
////import org.junit.jupiter.api.Test;
//import org.testng.annotations.Test;
//
//public class ParallelTest2 extends com.demoproject.definitions.DriverManager {
//    @Test
//    public void testChrome1() throws MalformedURLException {
//        driver = new com.demoproject.definitions.DriverManager().getDriver("chrome");
//        driver.navigate().to("http://www.google.com/");
//        driver.manage().window().maximize();
//    }
//    //Firefox Test
//    @Test
//    public void testFirefox1() throws MalformedURLException {
//        driver = new com.demoproject.definitions.DriverManager().getDriver("firefox");
//        driver.navigate().to("http://www.amazon.com/");
//        driver.manage().window().maximize();
//    }
//    @After
//    public void quitDriver() {
//        driver.quit();
//    }
//}
