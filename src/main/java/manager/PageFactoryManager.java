package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;
    private static final String URL = "https://www.ebay.com/";

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get(URL);
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public CreateAnAccountPage getCreateAnAccountPage() {
        return new CreateAnAccountPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public CartPaymentsPage getCartPaymentsPage() {
        return new CartPaymentsPage(driver);
    }

    public ShopByCategoryPage getShopByCategoryPage() {
        return new ShopByCategoryPage(driver);
    }
}
