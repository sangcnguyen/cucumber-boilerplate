package pages;


import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        path = "/login/index.php?lang=en_us";
    }

    @FindBy(name = "username")
    private WebElement txtUserName;

    @FindBy(name = "password")
    private WebElement txtPassword;

    @FindBy(id = "loginbtn")
    private WebElement btnLogin;

    @FindBy(id = "loginerrormessage")
    private WebElement errMessage;

    public void logIn(String userName, String password) {
        txtUserName.clear();
        txtUserName.sendKeys(userName);
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.submit();
    }

    public String getErrorMessage() {
        return errMessage.getText();
    }
}