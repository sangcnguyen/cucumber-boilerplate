package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageObjectManager {
    private WebDriver webDriver;
    private HomePage homePage;
    private ProductListingPage productListingPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ConfirmationPage confirmationPage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(webDriver) : homePage;
    }

    public ProductListingPage getProductListingPage() {
        return (productListingPage == null) ? productListingPage = new ProductListingPage(webDriver) : productListingPage;
    }

    public CartPage getCartPage() {
        return (cartPage == null) ? cartPage = new CartPage(webDriver) : cartPage;
    }

    public CheckoutPage getCheckoutPage() {
        return (checkoutPage == null) ? checkoutPage = new CheckoutPage(webDriver) : checkoutPage;
    }

    public ConfirmationPage getConfirmationPage() {
        return (confirmationPage == null) ? confirmationPage = new ConfirmationPage(webDriver) : confirmationPage;
    }
}
