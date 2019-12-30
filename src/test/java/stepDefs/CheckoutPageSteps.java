package stepDefs;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import manager.FileReaderManager;
import model.Customer;
import pages.CheckoutPage;

public class CheckoutPageSteps {
    TestContext testContext;
    CheckoutPage checkoutPage;

    public CheckoutPageSteps(TestContext context) {
        testContext = context;
        checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
    }

    @When("^enter \\\"(.*)\\\" personal details on checkout page$")
    public void enterPersonalDetailsOnCheckoutPage(String customerName) {
        Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
        checkoutPage.fillPersonalDetails(customer);
    }

    @When("^place the order$")
    public void placeTheOrder() {
        checkoutPage.checkTermsAndCondition(true);
        checkoutPage.clickOnPlaceOrder();
    }
}