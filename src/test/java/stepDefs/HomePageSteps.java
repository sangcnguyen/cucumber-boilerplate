package stepDefs;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePageSteps {
    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("user is on Home Page")
    public void userIsOnHomePage() {
        homePage.navigateToHomePage();
    }

    @When("^he search for \"([^\"]*)\"$")
    public void heSearchFor(String product) {
        homePage.performSearch(product);
    }
}
