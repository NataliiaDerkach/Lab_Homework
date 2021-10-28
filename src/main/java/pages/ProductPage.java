package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Buy It Now']")
    private WebElement buyItNowButton;

    @FindBy(xpath = "//a[@id='isCartBtn_btn']")
    private WebElement productAddToCart;

    @FindBy(xpath = "//h3[contains(text(),'Sony Xperia')]")
    private List<WebElement> sonyXperiaList;

    @FindBy(xpath = "(//ul[contains(@class,'b-list__items_nofooter')]/li)[2]")
    private WebElement smartWatchApple;

    @FindBy(xpath = "//input[@class='qtyInput']")
    private WebElement quantityField;

    @FindBy(xpath = "//div[@id='w1-15-_errMsg']")
    private WebElement messageNeedToAddAmountOfOneProduct;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void enterInQuantityField(final String qty){
        waitForPageLoadComplete(20);
        quantityField.clear();
        quantityField.sendKeys(qty);
    }

    public void clickOnAddToCartProductButton() {
        productAddToCart.click();
    }

    public List<WebElement> getTextThatSonyXperiaList() {
        return sonyXperiaList;
    }

    public void clickOnSmartWatchApple() {
        smartWatchApple.click();
    }

    public void clickBuyItNowButton() {
        buyItNowButton.click();
    }

    public String getMessageNeedToAddAmountOfOneProduct() {
        return messageNeedToAddAmountOfOneProduct.getText();
    }
}
