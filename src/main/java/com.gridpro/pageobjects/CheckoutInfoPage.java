package com.demoproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CheckoutInfoPage {
    private WebDriver driver;
    private static final String FINISH_BUTTON = "finish";

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(By.id("last-name")).sendKeys(lastName);
    }

    public void setPostalCode(String postalCode) {
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
    }

    public void clickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    public void clickFinishButton() {
        WebElement finish = driver.findElement(By.id("finish"));
        Actions actions = new Actions(driver);
        actions.click(finish).build().perform();
    }

    public boolean isThankYouMessageDisplayed() {
        return driver.findElement(By.xpath("//h2[contains(.,'Thank you')]")).isDisplayed();
    }
}
