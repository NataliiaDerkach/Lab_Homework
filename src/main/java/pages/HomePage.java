package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@href='https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F']")
    private WebElement registerButton;

    @FindBy(xpath = "//li[@data-currenttabindex='3']//a[@href='https://www.ebay.com/b/Home-Garden/11700/bn_1853126']")
    private WebElement homeAndGardenCategoryButton;

    @FindBy(xpath = "//input[@aria-label='Search for anything']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@id='gh-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='s-message__content']")
    private WebElement errorMessageAboutIncorrectInputSearch;

    @FindBy(xpath = "//h3[@class='srp-save-null-search__heading']")
    private WebElement messageAboutNoExactMatchesFound;

    @FindBy(xpath = "//button[@id='gh-shop-a']")
    private WebElement shopByCategoryButton;

    @FindBy(xpath = "//a[@href='https://www.ebay.com/b/Cell-Phones-Smart-Watches-Accessories/15032/bn_1865441']")
    private WebElement elementOfDropListCellPhonesAccessories;

    @FindBy(xpath = "//img[@src='https://i.ebayimg.com/thumbs/images/g/AHAAAOSwdpRfsl4-/s-l225.webp']")
    private WebElement smartWatchesCategory;

    @FindBy(xpath = "//li[@class='hl-popular-destinations-element']/a[contains(@href,'www.ebay.com/b/Cell-Phones-Smart-Watches-Accessories')]")
    private WebElement smartphonesCategories;

    @FindBy(xpath = "//button[@class='gh-eb-li-a gh-icon']")
    private WebElement shipToButton;

    @FindBy(xpath = "//div[@class='shipto__country-list']")
    private WebElement chooseCountryList;

    @FindBy(xpath = "//span[@data-country='UKR|UA']")
    private WebElement countryUkraine;

    @FindBy(xpath = "//button[@class='shipto__close-btn']")
    private WebElement closeCountryList;

    @FindBy(xpath = "//*[@id='gh-shipto-click']/div/button/i")
    private WebElement ukraine;

    @FindBy(xpath = "//div[contains(@class,'carousel__viewport')]//li")
    private WebElement someProduct;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.click();
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public String getErrorMessageAboutIncorrectInputSearch() {
        return errorMessageAboutIncorrectInputSearch.getText();
    }

    public void clickOnSmartWatchesCategory() {
        smartWatchesCategory.click();
    }

    public void clickOnShipToButton() {
        shipToButton.click();
    }

    public void clickOnChooseCountryList() {
        chooseCountryList.click();
    }

    public WebElement getElementChooseCountryList() {
        return chooseCountryList;
    }

    public void clickOnCountryUkraine() {
        countryUkraine.click();
    }

    public void clickOnCloseCountryList() {
        closeCountryList.click();
    }

    public boolean isVisibleFlagShipToUkraine() {
        return ukraine.isDisplayed();
    }

    public WebElement getElementCountryUkraine() {
        return countryUkraine;
    }

    public void clickOnSmartphonesCategories(){
        smartphonesCategories.click();
    }

    public void getSomeProductOnHomePage(){
        someProduct.click();
    }

}
