package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import selenium.Wait;

import java.util.List;

public class ProductListingPage {
    WebDriver webDriver;

    public ProductListingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "button.single_add_to_cart_button")
    private WebElement btnAddToCart;

    @FindBy(xpath = "//*[@class='noo-product-inner']/h3/a")
    private List<WebElement> prdList;

    @FindBy(id = "pa_color")
    private WebElement drpColor;

    @FindBy(id = "pa_size")
    private WebElement drpSize;

    public void clickOnAddToCart() {
        btnAddToCart.click();
        Wait.untilJqueryIsDone(webDriver);
    }

    public void selectProduct(int productNumber) {
        prdList.get(productNumber).click();
        Wait.untilPageLoadComplete(webDriver);
    }

    public void selectColor(String value) {
        Select color = new Select(drpColor);
        color.selectByValue(value);
    }

    public void selectSize(String value) {
        Select size = new Select(drpSize);
        size.selectByValue(value);
    }

    public String getProductName(int productNumber) {
        return prdList.get(productNumber).getText();
    }
}
