package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeGardenPage extends BasePage {

    @FindBy(xpath = "//a[@href='https://www.ebay.com/b/Furniture/3197/bn_1642075']")
    private WebElement furnitureButton;

    @FindBy(xpath = "//div[contains(@id,'xCarousel-x-carousel-items')]//a[@href='https://www.ebay.com/b/Sofas-Armchairs-Couches/38208/bn_1642996']")
    private WebElement sofasArmchairsAndCouchesButton;

    public HomeGardenPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFurnitureButton() {
        furnitureButton.click();
    }

    public void clickOnSofasArmchairsAndCouchesButton() {
        sofasArmchairsAndCouchesButton.click();
    }
}
