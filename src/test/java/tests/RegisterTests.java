package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;

public class RegisterTests extends BaseTests {

    @Test
    public void registerNewUserWithCorrectMandatoryDataProvided() {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        loginPage.goTo().goToRegisterPage("@interia.pl");
        registerPage.registerUser("username01", "", "asdqweawq7q9a");
        Assertions.assertTrue(registerPage.myAccountPageIsCorrect(), "title is not expected");
    }

    @Test
    public void registerWhenEmailAddressIsNotProvided() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser("random01", "", "asdqweawq7q9a");
        Assertions.assertTrue(registerPage.emailAddressIsNotProvidedAlert(), "Error message");
    }

    @Test
    public void registerWithExistingEmailAddress() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser("random02", "lukn15@interia.pl", "asdqweawq7q9a");
        Assertions.assertTrue(registerPage.existingEmailAddressAlert(), "Error message");
    }

}
