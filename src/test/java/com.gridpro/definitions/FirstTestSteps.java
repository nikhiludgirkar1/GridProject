package com.gridpro.definitions;

import com.gridpro.api.ApiSetup;
import com.gridpro.hooks.Hooks;
import com.demoproject.pageobjects.CartPage;
import com.demoproject.pageobjects.CheckoutInfoPage;
import com.demoproject.pageobjects.LandingPage;
import com.gridpro.pageobjects.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.Assert.assertTrue;

public class FirstTestSteps {
    private WebDriver driver;
    private final LoginPage loginPage;
    private final LandingPage landingPage;
    private final CartPage cartPage;
    private final CheckoutInfoPage checkoutInfoPage;
    private HashMap<String, String> endpointData;
    Hooks localHooks;
    Response response;

    public FirstTestSteps(Hooks hooks) {
        localHooks = hooks;
        localHooks.setup();
        driver = localHooks.getDriver();
        endpointData = ApiSetup.getData();
        loginPage = new LoginPage(driver);
        landingPage = new LandingPage(driver);
        cartPage = new CartPage(driver);
        checkoutInfoPage = new CheckoutInfoPage(driver);
    }

    @When("user navigates to portal")
    public void userNavigates() {
        loginPage.accessUrl();
    }

    @When("user enters username {string}")
    public void userEntersUserName(String userName) {
        loginPage.setUserName(userName);
    }

    @When("user enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.setPassword(password);
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("login is successful")
    public void loginIsSuccessful() {
        assertTrue(landingPage.isLoginSuccessful(), "Login not successful");
    }

    @Then("images page is loaded")
    public void imagesPageIsLoaded() {
        assertTrue(loginPage.isImagesPageLoaded());
    }

    @When("user adds {string} to cart")
    public void userAddsToCart(String productName) {
        landingPage.clickAddToCart(productName);
    }

    @Then("product {string} should be added to cart")
    public void productShouldBeAddedToCart(String productName) {
        assertTrue(cartPage.isProductAvailable(productName), "Product "+productName+" not available");
    }

    @When("user clicks on cart link")
    public void userClicksOnCartLink() {
        landingPage.clickCartLink();
    }

    @When("user clicks on checkout button")
    public void userClicksOnCheckoutButton() {
        cartPage.clickCheckout();
    }

    @When("user enters {string} in first name text box in checkout information page")
    public void userEntersInFirstNameTextboxInCheckoutInformationPage(String firstName) {
        checkoutInfoPage.setFirstName(firstName);
    }

    @When("user enters {string} in last name text box in checkout information page")
    public void userEntersInLastNameTextboxInCheckoutInformationPage(String lastName) {
        checkoutInfoPage.setLastName(lastName);
    }

    @When("user enters {string} in postal code in checkout information page")
    public void userEntersInPostalCodeTextboxInCheckoutInformationPage(String postalCode) {
        checkoutInfoPage.setPostalCode(postalCode);
    }

    @When("user clicks on continue button in checkout information page")
    public void userClicksOnContinueButton() {
        checkoutInfoPage.clickContinueButton();
    }

    @When("user clicks on finish button")
    public void userClicksOnFinishButton() {
        checkoutInfoPage.clickFinishButton();
    }

    @Then("user verifies Thank you message")
    public void userVerifiesThankYouMessage() {
        assertTrue(checkoutInfoPage.isThankYouMessageDisplayed(), "Thank you message is not displayed");
    }
    @When("user opens page in new tab")
    public void userOpensPageInNewTab() {
        cartPage.openInNewTab();
    }

}