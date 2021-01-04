package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;
import pageobjects.SearchPage;

public class SearchTests extends BaseTests {

    @Test
    public void searchProductsThatHaveSilverBarInTheName() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchProducts("Silver Bar");
        Assertions.assertTrue(searchPage.foundedProduct(), "The result of searching is not expected");
    }

    @Test
    public void searchProductsThatHaveGoldenCoinInTheName() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchProducts("Golden Coin");
        Assertions.assertTrue(searchPage.foundedProduct(), "The result of searching is not expected");
    }

    @Test
    public void searchNotExistingProduct() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchProducts("tytan");
        Assertions.assertTrue(searchPage.productNotFounded(), "The result of searching is not expected");

    }
}
