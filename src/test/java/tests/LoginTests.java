package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;

public class LoginTests extends BaseTests {


    @Test
    public void loginWithCorrectEmailAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().loginUser("lukn15@interia.pl", "5432!Qazxcv");
        Assertions.assertTrue(loginPage.userLoggedCorrect(), "Your account page does not contain correct name");
    }

    @Test
    public void loginWithIncorrectPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().loginUser("lukn15@interia.pl", "as7d6as8d");
        Assertions.assertTrue(loginPage.incorrectPasswordAlert(),
                "Error message is not correct");
    }

    @Test
    public void loginWithEmptyPasswordField() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().loginUser("lukn15@interia.pl", " ");
        Assertions.assertTrue(loginPage.emptyPasswordFieldAlert(), "Error message is not correct");
    }

    @Test
    public void loginWithEmptyLoginField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().loginUser(" ", "5432!Qazxcv");
        Assertions.assertTrue(loginPage.usernameFieldRequiredAlert(), "Error message is not correct");
    }

    @Test
    public void loginWithEmptyLoginAndPasswordField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().loginUser(" ", " ");
        Assertions.assertTrue(loginPage.usernameFieldRequiredAlert(), "Error message is not correct");
    }


}
