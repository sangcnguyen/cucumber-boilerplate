package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ConfirmationPage {
    WebDriver webDriver;

    public ConfirmationPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(css = ".order_item")
    private List<WebElement> prdList;

    public List<String> getProductNames() {
        List<String> productNames = new ArrayList<>();
        for(WebElement element : prdList) {
            productNames.add(element.getText());
        }
        return productNames;
    }
}


