package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.CategoryPage;

public class CategoryPageTests extends BaseTests {

    @Test
    public void shouldBeFilteredToCategoryGolBars() {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.goToGoldBars();
        Assertions.assertTrue(categoryPage.shouldFilteredToCategoryGoldBars(), "Category is not correct");
    }

    @Test
    public void shouldBeFilteredToCategoryGoldenCoins() {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.goToGoldenCoins();
        Assertions.assertTrue(categoryPage.shouldFilteredToCategoryGoldenCoins(), "Category is not correct");
    }

    @Test
    public void shouldBeFilteredToCategorySilverBars() {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.goToSilverBars();
        Assertions.assertTrue(categoryPage.shouldFilteredToCategorySilverBars(), "Category is not correct");
    }

    @Test
    public void shouldBeFilteredToCategorySilverCoins() {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.goToSilverCoins();
        Assertions.assertTrue(categoryPage.shouldFilteredToCategorySilverCoins(), "Category is not correct");
    }

    @Test
    public void shouldBeFilteredToCategoryUncategorized() {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.goToUncategorized();
        Assertions.assertTrue(categoryPage.shouldFilteredToCategoryUncategorized(), "Category is not correct");
    }

}
