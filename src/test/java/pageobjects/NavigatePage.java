package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigatePage extends BasePage {

    public NavigatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href*='/my-account/']")
    private WebElement myAccountButton;
    @FindBy(css = "a[href*='/checkout/']")
    private WebElement checkoutPageButton;
    @FindBy(css = "a[href*='/cart/'")
    private WebElement cartPageButton;
    @FindBy(css = "a[href*='/about-us/']")
    private WebElement aboutUsPageButton;
    @FindBy(css = "h1[class='entry-title']")
    private WebElement pageTitle;

    public void goToMyAccountSubpage() {
        myAccountButton.click();
    }

    public void goToCheckoutSubpage() {
        checkoutPageButton.click();
    }

    public void goToCartSubpage() {
        cartPageButton.click();
    }

    public void goToAboutUsSubpage() {
        aboutUsPageButton.click();
    }

    public boolean myAccountSubpage() {
        String expectedText = pageTitle.getText();
        return expectedText.equals("My account");
    }

    public boolean checkoutAndCartSubpage() {
        String expectedText = pageTitle.getText();
        return expectedText.equals("Cart");
    }

    public boolean aboutUsSubpage() {
        String expectedText = pageTitle.getText();
        return expectedText.equals("About us");
    }

}
