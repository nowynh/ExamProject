package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.SearchPage;

public class SearchTests extends BaseTests {

    @Test
    public void searchProductsThatHaveSilverBarInTheName() {
        SearchPage searchPage = new SearchPage(driver);
        String searchPhrase = "Silver Bar";
        searchPage.searchProducts(searchPhrase);
        Assertions.assertTrue(searchPage.ifFoundedProduct(searchPhrase), "The result of searching is not expected");
    }

    @Test
    public void searchProductsThatHaveGoldenCoinInTheName() {
        SearchPage searchPage = new SearchPage(driver);
        String searchPhrase = "Golden Coin";
        searchPage.searchProducts(searchPhrase);
        Assertions.assertTrue(searchPage.ifFoundedProduct(searchPhrase), "The result of searching is not expected");
    }

    @Test
    public void searchNotExistingProduct() {
        SearchPage searchPage = new SearchPage(driver);
        String searchPhrase = "tytan";
        searchPage.searchProducts(searchPhrase);
        Assertions.assertTrue(searchPage.isProductNotFounded(), "The result of searching is not expected");
    }
}
