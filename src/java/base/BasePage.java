package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private static final String BASE_URL = "http://www.shop.demoqa.com";
    protected String path;
    public WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    private String getUrl() {
        if (this.path.contains("http") || this.path.contains("https")) {
            return this.path;
        } else {
            return BASE_URL.concat(this.path);
        }
    }

    public void goToPage() {
        System.out.println("Navigate to " + getClass());
        this.webDriver.get(getUrl());
    }
}