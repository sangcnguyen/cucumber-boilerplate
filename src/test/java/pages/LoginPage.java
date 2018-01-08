package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Sang Nguyen on 1/7/2017
 */
public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    public WebElement txtUserName;

    @FindBy(name = "password")
    public WebElement txtPassword;

    @FindBy(id = "loginbtn")
    public WebElement btnLogin;

    public void logIn(String userName, String password) {
        txtUserName.clear();
        txtUserName.sendKeys(userName);
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.submit();
    }
}
