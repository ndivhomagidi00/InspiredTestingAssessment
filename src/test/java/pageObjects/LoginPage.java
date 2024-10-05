package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    WebDriver driver;

    @FindBy(css = "#Email")
    public WebElement username_field;

    @FindBy(css = "#Password")
    public WebElement password_field;

    @FindBy(xpath = "//input[@class='button-1 login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[text()='Log out']")
    public WebElement logoutButton;

    public LoginPage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
}
