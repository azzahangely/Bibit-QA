package stepDefinitions;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.MobileActions;
import utils.MobileDriverManager;
import java.net.MalformedURLException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class MobileSteps {

    public static AndroidDriver driver;
    private WebElement waitForElement(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    @Given("the user opens the app")
    public void openApp() throws MalformedURLException {
        driver = MobileDriverManager.getDriver();
    }
    @When("the user clicks element with accessibility id {string}")
    public void clickByAccessibilityId(String accessibilityId) {
        waitForElement(AppiumBy.accessibilityId(accessibilityId)).click();
    }

    @When("the user clicks element with id {string}")
    public void clickById(String id) {
        waitForElement(AppiumBy.id(id)).click();
    }

    @When("the user types {string} into element with id {string}")
    public void typeTextById(String text, String id) {
        waitForElement(AppiumBy.id(id)).sendKeys(text);
    }

    @When("the user types {string} into element with accessibility id {string}")
    public void typeTextByAccessibilityId(String text, String accessibilityId) {
        waitForElement(AppiumBy.accessibilityId(accessibilityId)).sendKeys(text);
    }

    @When("the user clicks element with android UIAutomator {string}")
    public void clickByAndroidUIAutomator(String uiSelector) {
        waitForElement(AppiumBy.androidUIAutomator(uiSelector)).click();
    }

    @Then("the user should see element with accessibility id {string}")
    public void verifyElementVisible(String accessibilityId) {
        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId(accessibilityId)).isDisplayed());
    }

    @When("the user scrolls down {int} times")
    public void userScrollsDown(int times) {
        MobileActions.scrollDown(driver, times);
    }



}
