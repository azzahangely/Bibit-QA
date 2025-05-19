package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;
import utils.WebActions;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class WebSteps {
    WebDriver driver;

    @Given("the user opens Chrome")
    public void userOpenChrome() {
        System.out.println("Opening Chrome...");

        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/Users/azzahangeli/automation-profile");
        options.addArguments("profile-directory=Default");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @And("the user navigates to {string}")
    public void userNavigatesToUrl(String url) {
        System.out.println("Navigating to: " + url);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        try {
            driver.get(url);
            System.out.println("Navigation successful.");
        } catch (TimeoutException e) {
            System.err.println("Page load timeout for URL: " + url);
            driver.quit();
            throw new RuntimeException("Navigation to " + url + " timed out.");
        }
    }

    @And("the user inputs PIN {string}")
    public void inputPin(String pin) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (char digit : pin.toCharArray()) {
            String selector = String.format("div[data-testid='num-%s']", digit);

            WebElement pinButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
            pinButton.click();
        }
    }

    @When("the user clicks element with CSS selector {string}")
    public void clickElementCss(String selector) {
        WebActions.clickByCss(driver, selector);
    }

    @When("the user clicks element with XPath {string}")
    public void clickElementXpath(String xpath) {
        WebActions.clickByXpath(driver, xpath);
    }

    @When("the user types {string} into input with selector {string}")
    public void typeIntoField(String text, String selector) {
        WebActions.typeIntoInput(driver, selector, text);
    }

    @Then("element with selector {string} should be visible")
    public void verifyElementVisible(String selector) {
        boolean isVisible = WebActions.isElementVisible(driver, selector);
        assertTrue("Expected element to be visible: " + selector, isVisible);
        driver.quit();
    }

    @When("the user scrolls to the bottom")
    public void scrollToBottom() {
        WebActions.scrollToBottom(driver);
    }

    @When("the user scrolls to element with XPath {string}")
    public void scrollToElementWithXpath(String xpath) {
        WebActions.scrollToElementByXpath(driver, xpath);
    }

    @When("the user scrolls to element with selector {string}")
    public void scrollToElementWithCss(String selector) {
        WebActions.scrollToElementByCss(driver, selector);
    }

    @When("the user scrolls to {string} element with text {string}")
    public void scrollToElementWithText(String tag, String text) {
        WebActions.scrollToElementByText(driver, tag, text);
    }

    @When("the user scrolls to text {string}")
    public void scrollToText(String text) {
        WebActions.scrollToText(driver, text);
    }

    @When("the user clicks element with text {string}")
    public void clickByText(String text) {
        WebActions.clickByText(DriverManager.getDriver(), text);
    }

    @Then("element with selector {string} should be visible within {int} seconds")
    public void waitElementVisible(String selector, int seconds) {
        WebActions.waitForElementVisible(driver, selector, seconds);
    }

    @Then("the page should contain at least one list with text {string}")
    public void validateSearchResultContains(String expectedText) {
        By productTitleLocator = By.xpath("//div[@type='body2']");
        boolean isPresent = WebActions.isTextPresentInElements(driver, productTitleLocator, expectedText, 15);
        assertTrue("Expected product containing '" + expectedText + "' was not found!", isPresent);
    }


}
