package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SofasShoppByColorGrayPage extends BasePage {

    @FindBy(xpath = "(//ul[contains(@class,'b-list__items_nofooter')]//li)[1]")
    private WebElement firstProductFromList;

    public SofasShoppByColorGrayPage(WebDriver driver) {
        super(driver);
    }

    public void clickTheFirstProductFromList() {
        firstProductFromList.click();
    }
}
