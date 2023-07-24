package factory;

import org.openqa.selenium.WebDriver;
import pages.odoo.HomePage_Odoo;
import pages.odoo.LoginPage_Odoo;
import pages.odoo.NewProductPage;
import pages.odoo.SellerDashboardPage;

public class PageFactoryManager {
    private static HomePage_Odoo homePage;
    private static LoginPage_Odoo loginPage;
    private static SellerDashboardPage sellerDashboard;

    private static NewProductPage newProductPage;

    public static HomePage_Odoo getHomePage(WebDriver driver){
        /**
         * Using Ternary Operator: Checking for loginPage as null.
         *
         * If it is null, then, create new object and return
         *
         * If it is not null, then, return loginPage
         */
        return homePage == null ? new HomePage_Odoo(driver) : homePage;
    }

    public static LoginPage_Odoo getLoginPage(WebDriver driver){
        return loginPage == null ? new LoginPage_Odoo(driver) : loginPage;
    }

    public static SellerDashboardPage getSellerDashboard(WebDriver driver){
        return sellerDashboard == null ? new SellerDashboardPage(driver) : sellerDashboard;
    }

    public static NewProductPage getNewProductPage(WebDriver driver){
        return newProductPage == null ? new NewProductPage(driver) : newProductPage;
    }

}