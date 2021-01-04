package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;
import pageobjects.UpdateAddressPage;

public class UpdateAddressTests extends BaseTests {


    @Test
    public void updateFullAdress() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.goTo().loginUser("lukn15@interia.pl", "5432!Qazxcv");
        UpdateAddressPage updateAddressPage = new UpdateAddressPage(driver);
        updateAddressPage.updateAddress("Zmieniona", "31-560", "Zmienna");
        Assertions.assertTrue(updateAddressPage.updateAddressIsCorrect(), "The message after saving your changes is not correct");
    }

    @Test
    public void updateZipCode() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.goTo().loginUser("lukn15@interia.pl", "5432!Qazxcv");
        UpdateAddressPage updateAddressPage = new UpdateAddressPage(driver);
        updateAddressPage.updateZipCode("31-599");
        Assertions.assertTrue(updateAddressPage.updateAddressIsCorrect(), "The message after saving your changes is not correct");
    }


}
