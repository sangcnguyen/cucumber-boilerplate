package pages;

import manager.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.Wait;

public class HomePage {
    WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void performSearch(String search) {
        webDriver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl()
                + "/?s=" + search + "&post_type=product");
    }

    public void navigateToHomePage() {
        webDriver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
        Wait.untilPageLoadComplete(webDriver);
    }
}
