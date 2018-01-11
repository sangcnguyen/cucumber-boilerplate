package steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Sang Nguyen on 1/7/2017
 */
public class Hook extends BaseUtil {
    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void setUp() {
        /*System.out.println("Opening the browser : Firefox");
        System.setProperty("webdriver.firefox.marionette", "./src/test/java/drivers/geckodriver.exe");
        base.Driver = new FirefoxDriver();*/

        //Chrome driver
        System.setProperty("webdriver.chrome.driver", "./src/test/java/drivers/chromedriver.exe");
        base.driver = new ChromeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        //if(scenario.getStatus().equalsIgnoreCase("failed")){
        if (scenario.isFailed()) {
            try {
                //Take screenshot logic goes here
                System.out.println(scenario.getName());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
                //scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "images/png");
                scenario.write("Scenario failed");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        } else {
            scenario.write("Scenario passed");
            System.out.println("Closing the browser!");
            base.driver.quit();
        }
    }
}
