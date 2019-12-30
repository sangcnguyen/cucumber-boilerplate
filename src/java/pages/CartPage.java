package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Wait;

public class CartPage {
    WebDriver webDriver;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(linkText = "View cart")
    private WebElement btnCart;

    @FindBy(xpath = "//div[@class='wc-proceed-to-checkout']/a")
    private WebElement btnProceedToCheckout;


    public void clickOnCart() {
        btnCart.click();
        Wait.untilPageLoadComplete(webDriver);
    }

    public void clickOnContinueToCheckout() {
        btnProceedToCheckout.click();
        Wait.untilPageLoadComplete(webDriver);
    }
}
