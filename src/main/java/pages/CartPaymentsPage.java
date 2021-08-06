package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPaymentsPage extends BasePage{

    @FindBy(xpath = "//i[@id='gh-cart-n']")
    private WebElement textAmountOfProductInCart;

    @FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
    private WebElement removeProductFromCart;

    @FindBy(xpath = "//div[@class='font-title-3']")
    private WebElement textAboutEmptyCart;

    public CartPaymentsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextAmountOfProductInCart(){
        return textAmountOfProductInCart.getText();
    }

    public WebElement getElementTextAmountOfProductInCart(){
        return textAmountOfProductInCart;
    }

    public void clickOnButtonRemoveProductFromCart(){
        removeProductFromCart.click();
    }

    public String getTextAboutEmptyCart(){
        return textAboutEmptyCart.getText();
    }

    public WebElement getWebElementTextAboutEmptyCart(){
        return textAboutEmptyCart;
    }
}
