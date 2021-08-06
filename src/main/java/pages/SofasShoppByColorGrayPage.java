package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SofasShoppByColorGrayPage extends BasePage {

    @FindBy(xpath = "//div[@class='s-item__info clearfix']//a[@href='https://www.ebay.com/itm/254990747823?hash=item3b5ea208af:g:lcoAAOSwEbxgfXh6']")
    private WebElement leatherArmchairGray;

    public SofasShoppByColorGrayPage(WebDriver driver) {
        super(driver);
    }

    public void clickTheLeatherArmchairGray() {
        leatherArmchairGray.click();
    }
}
