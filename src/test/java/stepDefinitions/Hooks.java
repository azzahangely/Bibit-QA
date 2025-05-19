package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.MobileDriverManager;

import java.net.MalformedURLException;

public class Hooks {

    public static AndroidDriver driver;

    @Before
    public void setUp(Scenario scenario) throws Exception {
        if (scenario.getSourceTagNames().contains("@android")) {
            MobileSteps.driver = utils.MobileDriverManager.getDriver();
        }
    }
}
