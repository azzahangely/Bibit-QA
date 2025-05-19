package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/web",
        glue = {"stepDefinitions"},
        tags = "@web",
        plugin = {"pretty", "html:target/web-report.html"},
        monochrome = true
)
public class WebRunner {}
