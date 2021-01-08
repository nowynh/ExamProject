package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[id='woocommerce-product-search-field-0']")
    private WebElement inputField;
    @FindBy(css = "p[class='woocommerce-info']")
    private WebElement resultSearchMessage;
    @FindBy(css = "a h2[class='woocommerce-loop-product__title']")
    private List<WebElement> foundProducts;
    private List<String> headerOfProduct = new ArrayList<>();
    private String searchingProduct = "";

    public void searchProducts(String searchingProduct) {
        inputField.sendKeys(searchingProduct);
        inputField.sendKeys(Keys.ENTER);
    }

    public boolean ifFoundedProduct(String searchingProduct) {
        for (WebElement element : foundProducts) {
            headerOfProduct.add(element.getText());
        }

        for (String foundedPhrases : headerOfProduct) {
            if (foundedPhrases.contains(searchingProduct)) {
                return true;
            }
        }
        return false;
    }

    public boolean isProductNotFounded() {
        String expectedText = resultSearchMessage.getText();
        return expectedText.equals("No products were found matching your selection.");
    }
}
