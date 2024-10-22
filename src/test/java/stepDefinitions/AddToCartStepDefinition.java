package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AddToCartPage;
import pageObjects.LoginPage;

import java.time.Duration;

public class AddToCartStepDefinition
{
    WebDriver driver;
    AddToCartPage addToCartPage;
    LoginPage loginPage;

    @Given("^I on the site$")
    public void goTo()
    {
        String url = "https://demowebshop.tricentis.com/login";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        addToCartPage = new AddToCartPage(driver);
    }
    @Then("I enter {string} and {string} and click login button to login")
    public void iEnterAndAndClickLoginButtonToLogin(String email, String password)
    {
        loginPage.username_field.sendKeys(email);
        loginPage.password_field.sendKeys(password);
        loginPage.loginButton.click();
    }
    @Then("I validate that i am logged in")
    public void iValidateThatIAmLoggedIn()
    {
        String actual_output = loginPage.logoutButton.getText();
        String expected ="Log out";
        Assert.assertEquals(expected,actual_output);
    }
    @Then("I click on computers")
    public void iClickOnComputers()
    {
        addToCartPage.computerTab.click();
    }

    @Then("I select desktops")
    public void iSelectDesktops()
    {
        addToCartPage.desktops_tab.click();
    }

    @Then("I click build my own cheap computer")
    public void iClickBuildMyOwnCheapComputer()
    {
        //clicking this element using JS..
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",  addToCartPage.build_your_own_cheap_computer);

    }
    @And("I click add to cart button")
    public void iClickAddToCartButton()
    {
        addToCartPage.add_to_cart_button.click();
    }

    @Then("I proceed with my order")
    public void iProceedWithMyOrder()
    {
        addToCartPage.shopping_cart_menu.click();
        addToCartPage.country_dropdown.click();
        //select the country
        String country ="South Africa";
        Select dropDownOption = new Select(addToCartPage.country_dropdown);
        dropDownOption.selectByVisibleText(country);

        //Accept the terms and conditions
        addToCartPage.accept_terms_andConditions.click();
        addToCartPage.checkoutButton.click();

    }
    @When("I capture billing {string} {string} {string} {string}")
    public void iCaptureBilling(String city, String address, String zip, String phoneNumber) throws InterruptedException {
        //Capture the billing details
        String billing_country ="South Africa";
        Select dropDownOption = new Select(addToCartPage.billing_country_dropDown);

        //The below code seems to have been removed on the system..hence it's commented out
        //Thread.sleep(200);
        //dropDownOption.selectByVisibleText(billing_country);

        //city,address1,zip,phone number
       /* addToCartPage.billing_city.sendKeys(city);
        addToCartPage.billing_address1.sendKeys(address);
        addToCartPage.billing_postalCode.sendKeys(zip);
        addToCartPage.billing_phoneNumber.sendKeys(phoneNumber);*/
    }

    @And("I click continue button")
    public void iClickContinueButton() throws InterruptedException {

        //Please note that had the elements looked the same, I would have implemented a loop to take care of these clicks..
        addToCartPage.continue_button.click();
        Thread.sleep(2000);
        addToCartPage.continue_button2.click();
        Thread.sleep(2000);
        addToCartPage.continue_button3.click();
        Thread.sleep(2000);
        addToCartPage.continue_button4.click();
        Thread.sleep(2000);
        addToCartPage.continue_button5.click();

    }
    @Then("I confirm my order")
    public void iConfirmMyOrder()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Confirm']")));

        element.click(); // Now you can interact with the element

        //addToCartPage.confirm_order.click();
    }

    @And("I validate and print out the order number")
    public void iValidateAndPrintOutTheOrderNumber()
    {
        //Validations
        String expectedText ="Your order has been successfully processed!";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement actualOutcome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Order number')]")));
        System.out.println(addToCartPage.success_text.getText());
        //String actualOutcome = addToCartPage.success_text.getText();
        //Assert.assertEquals(expectedText,actualOutcome);

        //print out the order number
        System.out.println(" "+addToCartPage.display_order.getText()+" Thank you for shopping with us today, have a great day!");
        driver.quit();//

    }
   /* @After
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }*/
}
