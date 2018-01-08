package steps;

import Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sang Nguyen on 1/7/2017
 */
public class LoginStep extends BaseUtil {
    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        System.out.println("Navigate Login Page");
        base.driver.navigate().to("https://demo.moodle.net/login/index.php");
    }

    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) {
        // Create an ArrayList
        List<User> users = new ArrayList<User>();

        // Store all the users
        users = table.asList(User.class);

        LoginPage page = new LoginPage(base.driver);

        for (User user : users) {
            page.logIn(user.username, user.password);
        }
    }

    @And("^I click login button$")
    public void iClickLoginButton() {
        LoginPage page = new LoginPage(base.driver);
        page.clickLogin();
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
        Assert.assertEquals("Invalid login, please try again", base.driver.findElement(By.xpath("//*[@id=\"region-main\"]/div/div[2]/div/div/div/div[2]/div")).getText());
    }

    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username = userName;
            password = passWord;
        }
    }
}