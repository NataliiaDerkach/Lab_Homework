package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
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

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    private static final long DEFAULT_TIMEOUT_TO_WAIT = 30;


    WebDriver driver;
    HomePage homePage;
    CreateAnAccountPage createAnAccountPage;
    ProductPage productPage;
    CartPaymentsPage cartPaymentsPage;
    PageFactoryManager pageFactoryManager;
    ShopByCategoryPage shopByCategoryPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        pageFactoryManager = new PageFactoryManager(driver);
        homePage = pageFactoryManager.getHomePage();
        createAnAccountPage = pageFactoryManager.getCreateAnAccountPage();
        cartPaymentsPage = pageFactoryManager.getCartPaymentsPage();
        productPage = pageFactoryManager.getProductPage();
        shopByCategoryPage = pageFactoryManager.getShopByCategoryPage();
    }


    @After
    public void tearDown() {
        driver.close();
    }

    @Given("user opens home page")
    public void userOpensHomePagePage() {
        pageFactoryManager.openHomePage();
    }

    @When("user goes to registration page")
    public void userGoesToRegistration() {
        homePage.clickOnRegisterButton();
        new WebDriverWait(driver, 40);
    }

    @Then("^user checks (.*) is open$")
    public void userChecksRegistrationPageIsOpen(final String keyword) {
        Assert.assertTrue(new WebDriverWait(driver, DEFAULT_TIMEOUT_TO_WAIT).until(ExpectedConditions.urlContains(keyword)));
    }

    @Then("^user gets (.*) about incorrect password$")
    public void userGetsErrorMessageAboutPassword(final String keyword1) {
        Assert.assertTrue(createAnAccountPage.getContainsTextPasswordError().contains(keyword1));
    }

    @Then("^user checks message: (.*)$")
    public void userCheckMessageAboutEmptyCart(final String message) {
        cartPaymentsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT_TO_WAIT, cartPaymentsPage.getWebElementTextAboutEmptyCart());
        Assert.assertTrue(cartPaymentsPage.getTextAboutEmptyCart().contains(message));
    }

    @And("user chooses apple from smart watches category")
    public void clickOnSmartWatchesCategory() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT_TO_WAIT);
        homePage.clickOnSmartWatchesCategory();
        shopByCategoryPage.clickOnAppleWatchCategory();
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

    @And("user chooses smartphone categories")
    public void userChoosesSmartphoneCategories() {
        homePage.clickOnSmartphonesCategories();
    }

    @When("^user adds (\\d+) to cart the first position of watches$")
    public void userAddsToCartTheFirstPositionOfWatches(final int x) {
        productPage.clickBuyItNowButton();
        productPage.clickOnSmartWatchApple();
        productPage.enterInQuantityField(String.valueOf(x));
        productPage.clickOnAddToCartProductButton();
    }

    @Then("^user checks quantity item in cart is (\\d+)$")
    public void userChecksQuantityItemInCartIs(final int x) {
        Assert.assertEquals(cartPaymentsPage.getAmountOfProductInCart(), String.valueOf(x));
        cartPaymentsPage.clickOnButtonRemoveProductFromCart();
    }

    @And("user adds product in cart")
    public void userAddsProductInCart() {
        homePage.getSomeProductOnHomePage();
        productPage.clickOnAddToCartProductButton();
    }

    @When("user goes to cart and removes item")
    public void userGoesToCartAndRemovesItem() {
        cartPaymentsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT_TO_WAIT, cartPaymentsPage.getElementTextAmountOfProductInCart());
        cartPaymentsPage.clickOnButtonRemoveProductFromCart();
    }

    @And("user chooses some product on home page")
    public void userChoosesSomeProductOnHomePage() {
        homePage.getSomeProductOnHomePage();
    }

    @When("^user enter (.*) item in field$")
    public void userEnterQuantityItemInField(final String qty) {
        productPage.enterInQuantityField(qty);
    }

    @When("User fills out the form:")
    public void userFillsOutTheForm(DataTable dataTable) {
        createAnAccountPage.enterTextToFirstnameField(String.valueOf(dataTable));
        createAnAccountPage.enterTextToLastnameField(String.valueOf(dataTable));
        createAnAccountPage.enterTextToEmailField(String.valueOf(dataTable));
        createAnAccountPage.clickOnShowPasswordCheckbox();
        createAnAccountPage.enterTextToPasswordField(String.valueOf(dataTable));
        createAnAccountPage.clickContainerThatGetErrorMessagePassword();
    }

    @Then("^user gets message: (.*)$")
    public void userGetsMessagePleaseEnterQuantityOfOrMore(String keyword) {
        Assert.assertEquals(keyword, productPage.getMessageNeedToAddAmountOfOneProduct());
    }

    @When("^user input keyword (.*) in search field$")
    public void userInputSearchSonyXperiaKeyword(final String keyword) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT_TO_WAIT);
        homePage.enterTextToSearchField(keyword);
    }

    @Then("^user checks text of product is contains (.*)$")
    public void userChecksTextOfProductIsContainsSonyXperia(final String keyword) {
        for (WebElement webElement : productPage.getTextThatSonyXperiaList()) {
            productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT_TO_WAIT);
            Assert.assertEquals(keyword, webElement.getText());
        }
    }

    @When("^user enter (.*) in search field$")
    public void userEnterInSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
        homePage.clickOnSearchButton();
    }

    @Then("^user gets error message: (.*)$")
    public void userGetsErrorMessageTheQueryMustHaveAtLeastAKeyword(final String message) {
        Assert.assertTrue(homePage.getErrorMessageAboutIncorrectInputSearch().contains(message));
    }


}

