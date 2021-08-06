package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//a[@id='isCartBtn_btn']")
    private WebElement productAddToCart;

    @FindBy(xpath = "//h3[contains(text(),'Sony Xperia')]")
    private List<WebElement> sonyXperiaList;

    @FindBy(xpath = "//img[@src='https://i.ebayimg.com/thumbs/images/g/7-UAAOSw7t9d8avq/s-l300.webp']")
    private WebElement smartWatchProduct;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartProductButton() {
        productAddToCart.click();
    }

    public List<WebElement> getTextThatSonyXperiaList() {
        List<WebElement> elementSonyXperiaList = sonyXperiaList;
        return elementSonyXperiaList;
    }

    public void clickOnSmartWatchProduct() {
        smartWatchProduct.click();
    }
}
