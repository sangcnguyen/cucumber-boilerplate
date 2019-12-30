package selenium;

import manager.FileReaderManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Wait {

    public static void untilJqueryIsDone(WebDriver webDriver) {
        untilJqueryIsDone(webDriver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
    }

    public static void untilJqueryIsDone(WebDriver driver, Long timeoutInSeconds) {
        until(driver, d ->
        {
            boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
            if (!isJqueryCallDone) System.out.println("JQuery call is in Progress");
            return isJqueryCallDone;
        }, timeoutInSeconds);
    }

    public static void untilPageLoadComplete(WebDriver webDriver) {
        untilPageLoadComplete(webDriver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
    }

    public static void untilPageLoadComplete(WebDriver webDriver, Long timeoutInSeconds) {
        until(webDriver, d -> {
            boolean isPageLoaded = ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
            if (!isPageLoaded) System.out.println("Document is loading");
            return isPageLoaded;
        }, timeoutInSeconds);
    }

    public static void until(WebDriver webDriver, Function<WebDriver, Boolean> waitCondition) {
        until(webDriver, waitCondition, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
    }

    private static void until(WebDriver webDriver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeoutInSeconds);
        webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
        try {
            webDriverWait.until(waitCondition);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
