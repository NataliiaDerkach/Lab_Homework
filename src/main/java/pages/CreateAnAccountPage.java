package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAnAccountPage extends BasePage {

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement clickFirstnameField;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement clickOnLastnameField;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement clickEmailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement clickOnPasswordField;

    @FindBy(xpath = "//input[@id='showpassword']")
    private WebElement checkboxShowPassword;

    @FindBy(xpath = "//button[@id='EMAIL_REG_FORM_SUBMIT']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//span[@id='password_err']")
    private WebElement passwordErrorMessage;

    @FindBy(xpath = "//div[@class='ppaContainer']")
    private WebElement clickThatGetErrorMessagePassword;

    @FindBy(xpath = "//a[@id='create-account-link']")
    private WebElement createAnAccountLink;


    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnShowPasswordCheckbox() {
        checkboxShowPassword.click();
    }

    public void clickContainerThatGetErrorMessagePassword() {
        clickThatGetErrorMessagePassword.click();
    }

    public String getContainsTextPasswordError() {
        return passwordErrorMessage.getText();
    }

    public void enterTextToFirstnameField(final String searchText) {
        clickFirstnameField.clear();
        clickFirstnameField.sendKeys(searchText);
    }

    public void enterTextToLastnameField(final String searchText) {
        clickOnLastnameField.clear();
        clickOnLastnameField.sendKeys(searchText);
    }

    public void enterTextToEmailField(final String searchText) {
        clickEmailField.clear();
        clickEmailField.sendKeys(searchText);
    }

    public void enterTextToPasswordField(final String searchText) {
        clickOnPasswordField.clear();
        clickOnPasswordField.sendKeys(searchText);
    }

}
