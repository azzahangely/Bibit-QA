package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class MobileDriverManager {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName("SM_A546E")
                    .setApp(System.getProperty("user.dir") + "/src/test/resources/apps/mda-2.2.0-25.apk")
                    .setAppWaitActivity("com.saucelabs.mydemoapp.android.view.activities.*") // ini penting
                    .setAutomationName("UiAutomator2");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
