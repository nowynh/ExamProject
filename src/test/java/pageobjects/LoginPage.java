package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement pass;
    @FindBy(id = "rememberme")
    private WebElement rememberMe;
    @FindBy(id = "reg_username")
    private WebElement reg_username;
    @FindBy(id = "reg_email")
    private WebElement reg_email;
    @FindBy(id = "reg_password")
    private WebElement reg_pass;
    @FindBy(css = "p a[href*='/lost-password/']")
    private WebElement lostPassword;
    @FindBy(css = "button[name='login']")
    private WebElement logIn;
    @FindBy(css = "ul.woocommerce-error")
    private WebElement alertMessage;
    @FindBy(css = "button[name='register']")
    private  WebElement registerButton;
    @FindBy(css = "ul.nav-menu a[href*='/my-account/']")
    private  WebElement myAccount;
    @FindBy(css = "div.woocommerce-MyAccount-content")
    private   WebElement accountMessageDisplay;
    @FindBy(css = "p a[href*='/my-account/customer-logout']")
    private  WebElement logOutButton;


    private final String lostPasswordDisplayed = "Lost your password?";
    private final String loggedUserName = "kot";

    public LoginPage goTo() {
        myAccount.click();
        return new LoginPage(driver);
    }

    public RegisterPage goToRegisterPage(String email) {
        Random random = new Random();
        String newEmail = "randomEmail" + random.nextInt(100000) + email;
        reg_email.sendKeys(newEmail);
        System.out.println(newEmail);
        return new RegisterPage(driver);
    }

    public void loginUser(String userName, String password) {
        username.sendKeys(userName);
        pass.sendKeys(password);
        logIn.sendKeys(Keys.ENTER);
    }

    public void logOutUser() {
        logOutButton.click();
    }

    public boolean userLoggedCorrect() {
        String expectedText = accountMessageDisplay.getText();
        boolean loggingCorrect = expectedText.contains(loggedUserName);
        return loggingCorrect;
    }


    public boolean incorrectPasswordAlert() {
        String expectedText = alertMessage.getText();
        boolean alertTextCorrect = expectedText.equals
                ("Error: The password you entered for the email address lukn15@interia.pl is incorrect. Lost your password?");
        return alertTextCorrect;
    }

    public boolean emptyPasswordFieldAlert() {
        String expectedText = alertMessage.getText();
        boolean alertTextCorrect = expectedText.equals
                ("Error: The password field is empty.");
        return alertTextCorrect;
    }

    public boolean usernameFieldRequiredAlert() {
        String expectedText = alertMessage.getText();
        boolean alertTextCorrect = expectedText.equals
                ("Error: Username is required.");
        return alertTextCorrect;
    }

    public boolean userLogOutCorrect() {
        String expectedText = lostPassword.getText();
        boolean logoutCorrect = expectedText.contains(lostPasswordDisplayed);
        return logoutCorrect;
    }


}
