package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

public class LoginStepDefinition
{
    WebDriver driver;
    LoginPage loginPage;

    @Given("^I navigate to the site$")
    public void navigate() {
        String url = "https://demowebshop.tricentis.com/login";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @Then("I enter {string} and {string} and click login button")
    public void iEnterAndAndClickLoginButton(String email, String password)
    {
        //Capture the login credentials and click the login button
        loginPage.username_field.sendKeys(email);
        loginPage.password_field.sendKeys(password);
        loginPage.loginButton.click();
    }

    @Then("I validate using logout button")
    public void iValidateUsingLogoutButton()
    {
        //Validating that I've successfully logged in using the logout button(you can only see the login button when you have logged in)
        String actual_output = loginPage.logoutButton.getText();
        String expected ="Log out";
        Assert.assertEquals(expected,actual_output);
        driver.quit();//close browser...

    }
    @After
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());//testing..
        }

}}
