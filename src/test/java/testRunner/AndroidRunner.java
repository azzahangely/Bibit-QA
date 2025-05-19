package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/mobile",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/mobile-report.html"},
        monochrome = true
)
public class AndroidRunner {
}
