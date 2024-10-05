package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage
{
    WebDriver driver;

    @FindBy(xpath = "(//a[contains(text(),'Computers')])[1]")
    public WebElement computerTab;

    @FindBy(xpath = "(//a[@title='Show products in category Desktops'])[1]")
    public WebElement desktops_tab;

    @FindBy(xpath = "//a[text()='Build your own cheap computer']")
    public WebElement build_your_own_cheap_computer;

    @FindBy(xpath = "//input[@id='add-to-cart-button-72']")
    public WebElement add_to_cart_button;

    @FindBy(xpath = "//span[text()='Shopping cart']")
    public WebElement shopping_cart_menu;

    @FindBy(xpath = "//select[@id='CountryId']")
    public WebElement country_dropdown;

    @FindBy(xpath = "//input[@id='termsofservice']")
    public WebElement accept_terms_andConditions;

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
    public WebElement billing_country_dropDown;

    @FindBy(css = "#BillingNewAddress_City")
    public WebElement billing_city;

    @FindBy(css = "#BillingNewAddress_Address1")
    public WebElement billing_address1;

    @FindBy(css = "#BillingNewAddress_ZipPostalCode")
    public WebElement billing_postalCode;

    @FindBy(css = "#BillingNewAddress_PhoneNumber")
    public WebElement billing_phoneNumber;

    @FindBy(xpath = "(//input[@value='Continue'])[1]")
    public WebElement continue_button;

    @FindBy(xpath = "(//input[@value='Continue'])[2]")
    public WebElement continue_button2;

    @FindBy(xpath = "(//input[@value='Continue'])[3]")
    public WebElement continue_button3;

    @FindBy(xpath = "(//input[@value='Continue'])[4]")
    public WebElement continue_button4;

    @FindBy(xpath = "(//input[@value='Continue'])[5]")
    public WebElement continue_button5;

    @FindBy(xpath = "//input[@value='Confirm']")
    public WebElement confirm_order;

    @FindBy(xpath = "//li[contains(text(),'Order number')]")
    public WebElement display_order;

    @FindBy(xpath = "//li[contains(text(),'Order number')]")
    public WebElement successText;

    public AddToCartPage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
}
