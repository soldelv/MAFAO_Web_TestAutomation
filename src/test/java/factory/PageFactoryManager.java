package factory;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    private static HomePage homePage;
    private static LoginPage loginPage;
    private static SellerDashboardPage sellerDashboard;

    public static HomePage getHomePage(WebDriver driver){
        /**
         * Using Ternary Operator: Checking for loginPage as null.
         *
         * If it is null, then, create new object and return
         *
         * If it is not null, then, return loginPage
         */
        return homePage == null ? new HomePage(driver) : homePage;
    }

    public static LoginPage getLoginPage(WebDriver driver){
        return loginPage == null ? new LoginPage(driver) : loginPage;
    }

    public static SellerDashboardPage getSellerDashboard(WebDriver driver){
        return sellerDashboard == null ? new SellerDashboardPage(driver) : sellerDashboard;
    }

}