package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;

public class LogoutTests extends BaseTests {

    @Test
    void logoutLoggedUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo().loginUser("lukn15@interia.pl", "5432!Qazxcv");
        Assertions.assertTrue(loginPage.userLoggedCorrect(), "Your account page does not contain correct name");
        loginPage.logOutUser();
        Assertions.assertTrue(loginPage.userLogOutCorrect(), "Href 'Lost your password' is not located");
    }
}
