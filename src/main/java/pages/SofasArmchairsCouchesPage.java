package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SofasArmchairsCouchesPage extends BasePage {

    @FindBy(xpath = "//a[@href='https://www.ebay.com/b/Gray-Sofas-Loveseats-and-Chaises/38208/bn_1520058']")
    private WebElement sofasShopByColorGray;

    public SofasArmchairsCouchesPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSofasShopByColorGrayButton() {
        sofasShopByColorGray.click();
    }
}
