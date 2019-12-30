package manager;

import enums.DriverType;
import enums.EnviromentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver webDriver;
    private static DriverType driverType;
    private static EnviromentType enviromentType;

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        enviromentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    public WebDriver getDriver() {
        if (webDriver == null) webDriver = createDriver();
        return webDriver;
    }

    public WebDriver createDriver() {
        switch (enviromentType) {
            case LOCAL:
                webDriver = createLocalDriver();
                break;
            case REMOTE:
                webDriver = createRemoteDriver();
                break;
        }
        return webDriver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX:
                io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case CHROME:
                io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
        }

        if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) {
            webDriver.manage().window().maximize();
        }
        webDriver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return webDriver;
    }

    public void quitDriver() {
        webDriver.close();
        webDriver.quit();
    }
}