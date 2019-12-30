package stepDefs;

import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.When;
import pages.ProductListingPage;

public class ProductPageSteps {
    TestContext testContext;
    ProductListingPage productListingPage;

    public ProductPageSteps(TestContext context) {
        testContext = context;
        productListingPage = testContext.getPageObjectManager().getProductListingPage();
    }

    @When("^choose to buy the first item$")
    public void chooseToBuyTheFirstItem() {
        String productName = productListingPage.getProductName(0);
        testContext.scenarioContext.setContext(Context.PRODUCT_NAME, productName);

        productListingPage.selectProduct(0);
        productListingPage.selectColor("white");
        productListingPage.selectSize("medium");
        productListingPage.clickOnAddToCart();
    }
}
