package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by Sang Nguyen on 1/7/2017
 */

// @RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        format = {"json:report/cucumber.json", "html:report/cucumber-pretty","pretty:report/cucumber.txt"},
        glue = "steps",
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}
