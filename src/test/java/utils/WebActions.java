package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebActions {

    public static void clickByCss(WebDriver driver, String selector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
        el.click();
    }

    public static void clickByXpath(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        el.click();
    }

    public static void typeIntoInput(WebDriver driver, String selector, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
        input.clear();
        input.sendKeys(text);
    }

    public static boolean isElementVisible(WebDriver driver, String selector) {
        return !driver.findElements(By.cssSelector(selector)).isEmpty();
    }

    public static void scrollToBottom(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToTop(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
    }

    public static void scrollToElementByXpath(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void scrollToElementByCss(WebDriver driver, String selector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void waitForElementVisible(WebDriver driver, String selector, int timeoutSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
    }

    public static boolean isElementPresent(WebDriver driver, String selector, int timeoutSeconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean isTextPresentInElements(WebDriver driver, By locator, String expectedText, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

        return elements.stream()
                .map(WebElement::getText)
                .anyMatch(text -> text.toLowerCase().contains(expectedText.toLowerCase()));
    }

    public static void clickElementByText(WebDriver driver, String tag, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By locator = By.xpath("//" + tag + "[contains(normalize-space(text()), '" + text + "')]");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public static void scrollToElementByText(WebDriver driver, String tag, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By locator = By.xpath("//" + tag + "[contains(normalize-space(text()), '" + text + "')]");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void scrollToText(WebDriver driver, String visibleText) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='" + visibleText + "']")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }


    public static void clickByText(WebDriver driver, String visibleText) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + visibleText + "']")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        element.click();
    }

}
