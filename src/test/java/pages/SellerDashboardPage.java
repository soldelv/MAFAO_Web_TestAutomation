package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SellerDashboardPage extends BasePage{
    public SellerDashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".dropdown-item.o_menu_brand")
    private WebElement dashboardTitle;

    @FindBy(xpath = "//div[contains(@class, 'o_user_menu')][1]")
    private WebElement userMenu;

    @FindBy(xpath = "//a[contains(@data-menu, 'logout')]")
    private WebElement datamenu_LogOut;


    public String checkIsInSellerDashboard(){
        String message = "Seller Dashboard not found";
        if(isDisplayed(dashboardTitle)){message = "Seller Dashboard displayed";}
        return message;
    }

    public void clickOnUserMenu(){
        clickOnElement(userMenu);
    }

    public void logOut(){
        clickOnUserMenu();
        clickOnElement(datamenu_LogOut);
    }
}
