package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.NavigatePage;

public class NavigatePageTests extends BaseTests {

    @Test
    public void shouldRedirectToMyAccountSubpage() {
        NavigatePage navigatePage = new NavigatePage(driver);
        navigatePage.goToMyAccountSubpage();
        Assertions.assertTrue(navigatePage.myAccountSubpage(), "Title 'My Account' subpage is not correct");
    }

    @Test
    public void shouldRedirectToCheckoutSubpage() {
        NavigatePage navigatePage = new NavigatePage(driver);
        navigatePage.goToCheckoutSubpage();
        Assertions.assertTrue(navigatePage.checkoutAndCartSubpage(), "Title 'Checkout' subpage is not correct");
    }

    @Test
    public void shouldRedirectToCartSubpage() {
        NavigatePage navigatePage = new NavigatePage(driver);
        navigatePage.goToCartSubpage();
        Assertions.assertTrue(navigatePage.checkoutAndCartSubpage(), "Title 'Cart' subpage is not correct");
    }

    @Test
    public void shouldRedirectToAboutUsSubpage() {
        NavigatePage navigatePage = new NavigatePage(driver);
        navigatePage.goToAboutUsSubpage();
        Assertions.assertTrue(navigatePage.aboutUsSubpage(), "Title 'About us' is not correct");
    }

}


