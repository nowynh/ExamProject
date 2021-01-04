package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[id='woocommerce-product-search-field-0']")
    private  WebElement inputField;

    @FindBy(css = "p[class='woocommerce-info']")
    private WebElement resultSearchMessage;

    @FindBy(css = "a h2[class='woocommerce-loop-product__title']")
    private List<WebElement> foundProducts;
    private String headerOfProduct;

    private String searchingProduct = "";

    public void searchProducts(String searchingProduct) {
        inputField.sendKeys(searchingProduct);
        inputField.sendKeys(Keys.ENTER);
    }

    public boolean foundedProduct() {
        for (WebElement elements : foundProducts) {
            headerOfProduct = elements.getText();
        }
        boolean searchResultCorrect = headerOfProduct.contains("");
        return searchResultCorrect;
    }

    public boolean productNotFounded() {
        String expectedText = resultSearchMessage.getText();
        boolean alertTextCorrect = expectedText.equals
                ("No products were found matching your selection.");
                return alertTextCorrect;
    }


}
