package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaptchaPage extends BasePage {

    @FindBy(xpath = "//div[contains(@id,'areaTitle')]/h1")
    private WebElement captchaForm;

    public CaptchaPage(WebDriver driver) {
        super(driver);
    }

    public String captchaMessage() {
        return captchaForm.getText();
    }
}
