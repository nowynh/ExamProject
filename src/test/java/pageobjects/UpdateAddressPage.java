package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateAddressPage extends BasePage {
    public UpdateAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href*='/my-account/edit-address/']")
    private WebElement billingAddress;
    @FindBy(css = "a[href*='/my-account/edit-address/billing']")
    private WebElement editBillingAddress;
    @FindBy(css = "input[id='billing_address_1']")
    private WebElement streetInputField;
    @FindBy(css = "input[id='billing_postcode']")
    private WebElement zipCodeInputField;
    @FindBy(css = "input[id='billing_city']")
    private WebElement cityInputField;
    @FindBy(css = "button[name='save_address']")
    private WebElement saveChangedButton;
    @FindBy(css = "div[class='woocommerce-message']")
    private WebElement messageAlert;


    public void updateAddress(String address, String postcode, String town) {
        billingAddress.click();
        editBillingAddress.click();
        streetInputField.clear();
        streetInputField.sendKeys(address);
        zipCodeInputField.clear();
        zipCodeInputField.sendKeys(postcode);
        cityInputField.clear();
        cityInputField.sendKeys(town);
        saveChangedButton.click();
    }

    public void updateZipCode(String postcode) {
        billingAddress.click();
        editBillingAddress.click();
        zipCodeInputField.clear();
        zipCodeInputField.sendKeys(postcode);
        saveChangedButton.click();
    }

    public boolean updateAddressIsCorrect() {
        String expectedText = messageAlert.getText();
        boolean alertTextCorrect = expectedText.equals
                ("Address changed successfully.");
        return alertTextCorrect;
    }
}
