package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    private static final long DEFAULT_TIMEOUT_TO_WAIT = 30;
    private static final String EXPECTED_URL_OF_REGISTRATION_PAGE = "https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F";
    private static final String EXPECTED_ERROR_MESSAGE_INCORRECT_LENGTH_PASSWORD = "At least 1 letter, a number or symbol, at least 6 characters.";
    private static final String EXPECTED_SECOND_ERROR_MESSAGE_INCORRECT_LENGTH_PASSWORD = "A number or symbol, at least 6 characters.";
    private static final String EXPECTED_AMOUNT_OF_PRODUCT_IN_CART = "1";
    private static final String EXPECTED_MESSAGE_EMPTY_CART = "You don't have any items in your cart.";
    private static final String EXPECTED_ERROR_MESSAGE_ABOUT_MAX_LENGTH = "Let's try that again. This time add more details so we can search for better matches.The userLocation city, state and zipcode were ignored because the zipcode is invalid or not supported for the country.";
    private static final String MAX_LENGTH_SEARCH_KEYWORD = "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww";
    private static final String INCORRECTLY_SEARCH_KEYWORD = "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww";
    private static final String EXPECTED_MESSAGE_INCORRECTLY_SEARCH_KEYWORD = "No exact matches found";
    private static final String EXPECTED_MESSAGE_ADD_PRODUCT_OF_ONE = "Please enter quantity of 1 or more";
    private static final String EXPECTED_MESSAGE_CREATE_AN_ACCOUNT = "create an account";

    WebDriver driver;
    HomePage homePage;
    CreateAnAccountPage createAnAccountPage;
    HomeGardenPage homeGardenPage;
    SofasArmchairsCouchesPage sofasArmchairsCouchesPage;
    SofasShoppByColorGrayPage sofasShoppByColorGrayPage;
    ProductPage productPage;
    CartPaymentsPage cartPaymentsPage;
    PageFactoryManager pageFactoryManager;
    SmartWatchProductPage smartWatchProductPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
        homePage = pageFactoryManager.getHomePage();
        sofasArmchairsCouchesPage = pageFactoryManager.getSofasArmchairsCouchesPage();
        homeGardenPage = pageFactoryManager.getHomeGardenPage();
        createAnAccountPage = pageFactoryManager.getCreateAnAccountPage();
        cartPaymentsPage = pageFactoryManager.getCartPaymentsPage();
        productPage = pageFactoryManager.getProductPage();
        sofasShoppByColorGrayPage = pageFactoryManager.getSofasShoppByColorGrayPage();
        smartWatchProductPage = pageFactoryManager.getSmartWatchProductPage();
    }


    @Given("user opens {string} page")
    public void userOpensHomePagePage(final String url) {
        homePage.openHomePage(url);
    }

    @And("user click on register button")
    public void userClickOnRegisterButton() {
        homePage.clickOnRegisterButton();
        new WebDriverWait(driver, 40);
    }

    @And("user checks registration page is open")
    public void userChecksRegistrationPageIsOpen() {
        Assert.assertTrue(new WebDriverWait(driver, DEFAULT_TIMEOUT_TO_WAIT).until(ExpectedConditions.urlContains(EXPECTED_URL_OF_REGISTRATION_PAGE)));
    }

    @When("user input firstname {string}field")
    public void userInputFirstnameFirstNameField(final String firstName) {
        createAnAccountPage.enterTextToFirstnameField(firstName);
    }

    @And("user input lastname {string}field")
    public void userInputLastnameLastNameField(final String lastName) {
        createAnAccountPage.enterTextToLastnameField(lastName);
    }

    @And("user input email {string} in email field")
    public void userInputEmailEmailInEmailField(final String email) {
        createAnAccountPage.enterTextToEmailField(email);
    }

    @And("user click on show password checkbox")
    public void userClickOnShowPasswordCheckbox() {
        createAnAccountPage.clickOnShowPasswordCheckbox();
    }

    @And("user input password {string} in password field")
    public void userInputPasswordPasswordInPasswordField(final String password) {
        createAnAccountPage.enterTextToPasswordField(password);
        createAnAccountPage.clickContainerThatGetErrorMessagePassword();
    }


    @After
    public void tearDown() {
        driver.close();
    }


    @Then("user get error message about incorrect password")
    public void userGetErrorMessageAboutIncorrectPassword() {
        Assert.assertTrue(EXPECTED_SECOND_ERROR_MESSAGE_INCORRECT_LENGTH_PASSWORD
                .equals(createAnAccountPage.getContainsTextPasswordError()) || EXPECTED_ERROR_MESSAGE_INCORRECT_LENGTH_PASSWORD
                .equals(createAnAccountPage.getContainsTextPasswordError()));

    }

    @And("user click on button homeAndGarden category")
    public void userClickOnButtonHomeAndGardenCategory() {
        homePage.clickOnHomeAndGardenCategoryButton();
        homeGardenPage.waitForPageLoadComplete(DEFAULT_TIMEOUT_TO_WAIT);
    }

    @And("choose furniture category")
    public void chooseFurnitureCategory() {
        homeGardenPage.clickOnFurnitureButton();
    }

    @And("user click on sofas and armchairs button")
    public void userClickOnSofasAndArmchairsButton() {
        homeGardenPage.clickOnSofasArmchairsAndCouchesButton();
        sofasArmchairsCouchesPage.waitForPageLoadComplete(DEFAULT_TIMEOUT_TO_WAIT);
    }

    @And("user click on sofas gray color category")
    public void userClickOnSofasGrayColorCategory() {
        sofasArmchairsCouchesPage.clickOnSofasShopByColorGrayButton();
        sofasShoppByColorGrayPage.waitForPageLoadComplete(DEFAULT_TIMEOUT_TO_WAIT);
    }

    @And("click on chosen product button")
    public void clickOnChosenProductButton() {
        sofasShoppByColorGrayPage.clickTheLeatherArmchairGray();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT_TO_WAIT);
    }

    @And("user click on add to cart button")
    public void userClickOnAddToCartButton() {
        productPage.clickOnAddToCartProductButton();
    }

    @And("user check that cart contains one product")
    public void userCheckThatCartContainsOneProduct() {
        cartPaymentsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPaymentsPage.getElementTextAmountOfProductInCart());
        Assert.assertTrue(EXPECTED_AMOUNT_OF_PRODUCT_IN_CART.equals(cartPaymentsPage.getTextAmountOfProductInCart()));
    }

    @And("user click remove button of product from cart")
    public void userClickRemoveButtonOfProductFromCart() {
        cartPaymentsPage.clickOnButtonRemoveProductFromCart();
    }

    @Then("user check message about empty cart")
    public void userCheckMessageAboutEmptyCart() {
        cartPaymentsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPaymentsPage.getWebElementTextAboutEmptyCart());
        Assert.assertEquals(EXPECTED_MESSAGE_EMPTY_CART, cartPaymentsPage.getTextAboutEmptyCart());
    }

    @And("user input search {string} keyword")
    public void userInputSearchKeywordKeyword(final String searchKeyword) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.enterTextToSearchField(searchKeyword);
    }


    @And("user check contains text {string} of product")
    public void userCheckContainsTextKeywordOfProduct(final String expectedResult) {
        for (WebElement webElement : productPage.getTextThatSonyXperiaList()) {
            productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
            Assert.assertEquals(expectedResult, webElement.getText());
        }

    }

    @When("user enter max length keyword in search field")
    public void userEnterMaxLengthKeywordInSearchField() {
        homePage.enterTextToSearchField(MAX_LENGTH_SEARCH_KEYWORD);
        homePage.clickOnSearchButton();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getElementErrorMessageAboutIncorrectInputSearch());
    }

    @And("user get error message about incorrect search keyword")
    public void userGetErrorMessageAboutIncorrectSearchKeyword() {
        Assert.assertEquals(EXPECTED_ERROR_MESSAGE_ABOUT_MAX_LENGTH, homePage.getErrorMessageAboutIncorrectInputSearch());
    }

    @And("user enter incorrect search keyword")
    public void userEnterIncorrectSearchKeyword() {
        homePage.enterTextToSearchField(INCORRECTLY_SEARCH_KEYWORD);
        homePage.clickOnSearchButton();
    }

    @Then("user get message that no exact matches found")
    public void userGetMessageThatNoExactMatchesFound() {
        Assert.assertEquals(EXPECTED_MESSAGE_INCORRECTLY_SEARCH_KEYWORD, homePage.getMessageAboutNoExactMatchesFound());
    }


    @And("user click shop by category")
    public void userClickShopByCategory() {
        homePage.clickOnShopByCategoryButton();
    }

    @And("user click on Cell phones & accessories from drop list")
    public void userClickOnCellPhonesAccessoriesFromDropList() {
        homePage.clickOnCategoryOfDropListCellPhonesAccessories();
    }

    @And("click on smart watches category")
    public void clickOnSmartWatchesCategory() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnSmartWatchesCategory();
    }

    @And("user choose smart watch product on this page")
    public void userChooseSmartWatchProductOnThisPage() {
        productPage.clickOnSmartWatchProduct();
    }

    @And("user enter in quantity field {string}")
    public void userEnterInQuantityFieldAmountOfProduct(final String amountOfProduct) {
        smartWatchProductPage.enterTextToQuantityField(amountOfProduct);
    }

    @And("user get message about need to quantity of one or more")
    public void userGetMessageAboutNeedToQuantityOfOneOrMore() {
        Assert.assertEquals(EXPECTED_MESSAGE_ADD_PRODUCT_OF_ONE, smartWatchProductPage.getMessageNeedToAddAmountOfOneProduct());
    }

    @When("user save this seller")
    public void userSaveThisSeller() {
        smartWatchProductPage.clickOnHeartIcon();
    }

    @And("user get opening the registration window with create an account message")
    public void userGetOpeningTheRegistrationWindowWithCreateAnAccountMessage() {
        Assert.assertEquals(EXPECTED_MESSAGE_CREATE_AN_ACCOUNT, createAnAccountPage.getCreateAnAccountLink());
    }

    @And("user click on logo button")
    public void userClickOnLogoButton() {
        createAnAccountPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        createAnAccountPage.clickOnLogoButton();
    }

    @And("user come back on product page")
    public void userComeBackOnProductPage() {
        homePage.clickOnShopByCategoryButton();
        homePage.clickOnCategoryOfDropListCellPhonesAccessories();
        homePage.clickOnSmartWatchesCategory();
        productPage.clickOnSmartWatchProduct();
    }

    @And("click on add to Watchlist button")
    public void clickOnAddToWatchlistButton() {
        smartWatchProductPage.clickOnAddToWatchListButton();
    }

    @Then("And user get opening the registration window with create an account message")
    public void andUserGetOpeningTheRegistrationWindowWithCreateAnAccountMessage() {
        createAnAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT_TO_WAIT);
        Assert.assertTrue(EXPECTED_MESSAGE_CREATE_AN_ACCOUNT.equals(createAnAccountPage.getCreateAnAccountLink()));
    }

    @And("user click on shipTo button")
    public void userClickOnShipToButton() {
        homePage.clickOnShipToButton();
    }

    @And("click on country list button")
    public void clickOnCountryListButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT_TO_WAIT, homePage.getElementChooseCountryList());
        homePage.clickOnChooseCountryList();
    }

    @And("user choose Ukraine country")
    public void userChooseUkraineCountry() {
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT_TO_WAIT);
        homePage.clickOnCountryUkraine();
    }

    @Then("user check that Ukraine flag is visibility")
    public void userCheckThatUkraineFlagIsVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT_TO_WAIT, homePage.getElementCountryUkraine());
        homePage.clickOnCloseCountryList();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT_TO_WAIT);
        Assert.assertTrue(homePage.isVisibleFlagShipToUkraine());
    }
}

