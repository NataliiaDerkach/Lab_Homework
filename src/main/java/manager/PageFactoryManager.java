package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public CreateAnAccountPage getCreateAnAccountPage() {
        return new CreateAnAccountPage(driver);
    }

    public HomeGardenPage getHomeGardenPage(){
        return new HomeGardenPage(driver);
    }

    public SofasArmchairsCouchesPage getSofasArmchairsCouchesPage(){
        return new SofasArmchairsCouchesPage(driver);
    }

    public SofasShoppByColorGrayPage getSofasShoppByColorGrayPage(){
        return new SofasShoppByColorGrayPage(driver);
    }

    public ProductPage getProductPage(){
        return new ProductPage(driver);
    }

    public CartPaymentsPage getCartPaymentsPage(){
        return new CartPaymentsPage(driver);
    }

    public SmartWatchProductPage getSmartWatchProductPage(){
        return new SmartWatchProductPage(driver);
    }
}
