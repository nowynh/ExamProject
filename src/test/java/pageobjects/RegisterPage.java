package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "reg_username")
    private WebElement reg_username;
    @FindBy(id = "reg_email")
    private WebElement reg_email;
    @FindBy(id = "reg_password")
    private WebElement reg_pass;
    @FindBy(css = "button[name='register']")
    private WebElement registerButton;
    @FindBy(css = "ul.woocommerce-error")
    private WebElement messageAlert;
    @FindBy(css = "h1[class='entry-title']")
    private WebElement pageTitle;


    public void registerUser(String username, String emailAddress, String password) {
        reg_username.sendKeys(username);
        reg_email.sendKeys(emailAddress);
        reg_pass.sendKeys(password);
        registerButton.click();
    }

    public boolean myAccountPageIsCorrect() {
        String expectedText = pageTitle.getText();
        return expectedText.equals("My account");
    }

    public boolean emailAddressIsNotProvidedAlert() {
        String expectedText = messageAlert.getText();
        return expectedText.equals("Error: Please provide a valid email address.");
    }

    public boolean existingEmailAddressAlert() {
        String expectedText = messageAlert.getText();
        return expectedText.equals("Error: An account is already registered with your email address. Please log in.");
    }
}
