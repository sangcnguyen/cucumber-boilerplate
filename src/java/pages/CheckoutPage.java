package pages;

import model.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import selenium.Wait;

public class CheckoutPage {
    WebDriver webDriver;

    public CheckoutPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "billing_first_name")
    private WebElement txtbxFirstName;

    @FindBy(id = "billing_last_name")
    private WebElement txtbxLastName;

    @FindBy(id = "billing_company")
    private WebElement txtbxCompany;

    @FindBy(id = "billing_country")
    private WebElement drpCountry;

    @FindBy(id = "billing_address_1")
    private WebElement txtbxAddress;

    @FindBy(id = "billing_postcode")
    private WebElement txtbxPostCode;

    @FindBy(id = "billing_city")
    private WebElement txtbxCity;

    @FindBy(id = "billing_phone")
    private WebElement txtbxPhone;

    @FindBy(id = "billing_email")
    private WebElement txtbxEmail;

    @FindBy(id = "terms")
    private WebElement chkbxAcceptTerms;

    @FindBy(id = "place_order")
    private WebElement btnPlaceOrder;


    public void enterFirstName(String name) {
        txtbxFirstName.sendKeys(name);
    }

    public void enterLastName(String lastName) {
        txtbxLastName.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        txtbxEmail.sendKeys(email);
    }

    public void enterPhone(String phone) {
        txtbxPhone.sendKeys(phone);
    }

    public void enterCity(String city) {
        txtbxCity.sendKeys(city);
    }

    public void enterStreetAddress(String address) {
        txtbxAddress.sendKeys(address);
    }

    public void enterPostCode(String postCode) {
        txtbxPostCode.sendKeys(postCode);
    }

    public void selectCountry(String countryName) {
        Select select = new Select(drpCountry);
        select.selectByVisibleText(countryName);
    }

    public void checkTermsAndCondition(boolean value) {
        if (value) chkbxAcceptTerms.click();
    }

    public void clickOnPlaceOrder() {
        btnPlaceOrder.click();
        Wait.untilJqueryIsDone(webDriver);
        Wait.untilPageLoadComplete(webDriver);
    }

    public void fillPersonalDetails(Customer customer) {
        Wait.untilPageLoadComplete(webDriver);
        enterFirstName(customer.firstName);
        enterLastName(customer.lastName);
        enterPhone(customer.phoneNumber);
        enterEmail(customer.emailAddress);
        selectCountry(customer.address.country);
        enterCity(customer.address.city);
        enterStreetAddress(customer.address.streetAddress);
        enterPostCode(customer.address.postCode);
        Wait.untilJqueryIsDone(webDriver);
    }
}