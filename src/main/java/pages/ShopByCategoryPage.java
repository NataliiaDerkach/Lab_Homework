package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopByCategoryPage extends BasePage {

    @FindBy(xpath = "//li[@class='carousel__snap-point']//p[text()='Apple']")
    private WebElement appleWatch;

    public ShopByCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAppleWatchCategory() {
        appleWatch.click();
    }
}
