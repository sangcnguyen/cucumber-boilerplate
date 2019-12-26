package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

import java.util.List;

public class LoginStepdefs {
    WebDriver driver;
    private LoginPage loginPage = new LoginPage(driver);


    @Given("^I navigate to the login page$")
    public void i_navigate_to_the_login_page() {
        System.out.println("Navigate Login Page");
        loginPage.goToPage();
    }

    @And("^I enter the following for Login$")
    public void i_enter_the_following_for_login(DataTable table) {
        // Store all the users
        List<User> users = table.asList(User.class);

        for (User user : users) {
            loginPage.logIn(user.getUsername(), user.getPassword());
        }
    }

    @And("^I click login button$")
    public void i_click_login_button() {
        loginPage.clickLogin();
    }

    @Then("^I should see the userform page$")
    public void i_should_see_the_userform_page() {
        Assert.assertEquals("Welcome!", driver.findElement(By.xpath("//*[@id=\"region-main\"]/div/div/div[1]/div/h5/b")).getText());
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void i_enter_username_and_password(String userName, String password) {
        System.out.println("UserName is : " + userName);
        System.out.println("Password is : " + password);
    }

    @Then("^I should see the userform page wrongly$")
    public void i_should_see_the_userform_page_wrongly() {
        Assert.assertEquals("Invalid login, please try again", loginPage.getErrorMessage());
    }
}