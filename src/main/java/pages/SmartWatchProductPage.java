package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartWatchProductPage extends BasePage {

    @FindBy(xpath = "//div[@id='w1-15-_errMsg']")
    private WebElement messageNeedToAddAmountOfOneProduct;

    @FindBy(xpath = "//input[@class='qtyInput']")
    private WebElement quantityField;

    @FindBy(xpath = "//div[@class='heartIcon']")
    private WebElement heartIcon;

    @FindBy(xpath = "//a[@href='javascript:;']//span[@class='vi-atw-txt']")
    private WebElement addToWatchListButton;

    public SmartWatchProductPage(WebDriver driver) {
        super(driver);
    }

    public String getMessageNeedToAddAmountOfOneProduct() {
        return messageNeedToAddAmountOfOneProduct.getText();
    }

    public void enterTextToQuantityField(final String searchText) {
        quantityField.clear();
        quantityField.sendKeys(searchText);
    }

    public void clickOnHeartIcon() {
        heartIcon.click();
    }

    public void clickOnAddToWatchListButton() {
        addToWatchListButton.click();
    }

}
