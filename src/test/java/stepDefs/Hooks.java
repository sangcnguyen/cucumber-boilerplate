package stepDefs;

import cucumber.TestContext;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class Hooks {
    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                //Take screenshot logic goes here
                System.out.println(scenario.getName());
                byte[] screenshot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
                scenario.write("Scenario failed");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
    }

    @After(order = 0)
    public void afterSteps() {
        testContext.getWebDriverManager().quitDriver();
    }
}
