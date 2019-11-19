package steps;

import base.BaseUtil;
import cucumber.api.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

import java.util.List;

public class LoginSteps {
    private BaseUtil base;
    private WebDriver driver;
    private LoginPage loginPage = new LoginPage(driver);


    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        System.out.println("Navigate Login Page");
        base.driver.navigate().to("https://sandbox.moodledemo.net/login/index.php");
    }

    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) {
        // Store all the users
        List<User> users = table.asList(User.class);

        LoginPage page = new LoginPage(base.driver);

        for (User user : users) {
            page.logIn(user.getUsername(), user.getPassword());
        }
    }

    @And("^I click login button$")
    public void iClickLoginButton() {
        loginPage.clickLogin();
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() {
        Assert.assertEquals("Welcome!", base.driver.findElement(By.xpath("//*[@id=\"region-main\"]/div/div/div[1]/div/h5/b")).getText());
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String userName, String password) {
        System.out.println("UserName is : " + userName);
        System.out.println("Password is : " + password);
    }

    @Then("^I should see the userform page wrongly$")
    public void iShouldSeeTheUserformPageWrongly() {
        Assert.assertEquals("Invalid login, please try again", loginPage.getErrorMessage());
    }
}