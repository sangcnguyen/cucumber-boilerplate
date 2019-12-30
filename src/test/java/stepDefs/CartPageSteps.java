package stepDefs;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import pages.CartPage;

public class CartPageSteps {
    TestContext testContext;
    CartPage cartPage;

    public CartPageSteps(TestContext context) {
        testContext = context;
        cartPage = testContext.getPageObjectManager().getCartPage();
    }

    @When("^moves to checkout from mini cart$")
    public void movesToCheckoutFromMiniCart() {
        cartPage.clickOnCart();
        cartPage.clickOnContinueToCheckout();
    }
}
