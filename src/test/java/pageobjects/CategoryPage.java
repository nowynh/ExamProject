package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage {


    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1.page-title")
    private WebElement homePageTitle;
    @FindBy(css = "a[href*='/gold-bars/']")
    private WebElement goldBars;
    @FindBy(css = "a[href*='/gold-coins/']")
    private WebElement goldenCoins;
    @FindBy(css = "a[href*='/silver-bars/']")
    private WebElement silverBars;
    @FindBy(css = "a[href*='/silver-coins/']")
    private WebElement silverCoins;

    @FindBy(css = "a[href*='/uncategorized/']")
    private WebElement uncategorized;


    public void goToGoldBars() {
        goldBars.click();
    }

    public void goToGoldenCoins() {
        goldenCoins.click();
    }

    public void goToSilverBars() {
        silverBars.click();
    }

    public void goToSilverCoins() {
        silverCoins.click();
    }

    public void goToUncategorized() {
        uncategorized.click();
    }

    public boolean shouldFilteredToCategoryGoldBars() {
        String expectedText = homePageTitle.getText();
        boolean alertTextCorrect = expectedText.equals
                ("Gold Bars");
        return alertTextCorrect;
    }

    public boolean shouldFilteredToCategoryGoldenCoins() {
        String expectedText = homePageTitle.getText();
        boolean alertTextCorrect = expectedText.equals
                ("Gold Coins");
        return alertTextCorrect;
    }

    public boolean shouldFilteredToCategorySilverBars() {
        String expectedText = homePageTitle.getText();
        boolean alertTextCorrect = expectedText.equals
                ("Silver Bars");
        return alertTextCorrect;
    }

    public boolean shouldFilteredToCategorySilverCoins() {
        String expectedText = homePageTitle.getText();
        boolean alertTextCorrect = expectedText.equals
                ("Silver Coins");
        return alertTextCorrect;
    }

    public boolean shouldFilteredToCategoryUncategorized() {
        String expectedText = homePageTitle.getText();
        boolean alertTextCorrect = expectedText.equals
                ("Uncategorized");
        return alertTextCorrect;
    }


}

