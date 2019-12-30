package stepDefs;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ConfirmationPage;

public class ConfirmationPageSteps {
    TestContext testContext;
    ConfirmationPage confirmationPage;

    public ConfirmationPageSteps(TestContext context) {
        testContext = context;
        confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
    }

    @Then("^verify the order details$")
    public void verifyTheOrderDetails() {
        Assert.assertEquals(confirmationPage.getProductNames(), testContext.scenarioContext.getContext(Context.PRODUCT_NAME));
    }
}
