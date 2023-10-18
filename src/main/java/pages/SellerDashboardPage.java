package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

import static utils.CommonMethods.print;

public class SellerDashboardPage extends BasePage_Odoo {
    public SellerDashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".dropdown-item.o_menu_brand")
    private WebElement dashboardTitle;

    @FindBy(xpath = "//div[contains(@class, 'o_user_menu')][1]")
    private WebElement userMenu;

    @FindBy(xpath = "//a[contains(@data-menu, 'logout')]")
    private WebElement datamenu_LogOut;

    /**
     * ADMIN
    */
    @FindBy(css=".oe_kanban_color_1.o_kanban_record")
    private WebElement marketplaceProduct;
    @FindBy(xpath = "//div[contains(@class,'oe_kanban_color_2')][1]")
    private WebElement marketplaceSellers;

    @FindBy(xpath = "//div[contains(@class,'oe_kanban_color_3')]")
    private WebElement marketplaceOrders;

    @FindBy(xpath = "//div[contains(@class,'oe_kanban_color_4')]")
    private WebElement sellerPayments;

    @FindBy(xpath = "//div[contains(@class,'oe_kanban_color_5')]")
    private WebElement productGroups;

    @FindBy(xpath = "//div[contains(@class,'oe_kanban_color_6')]")
    private WebElement reportedGroups_Products;

    @FindBy(xpath = "//div[contains(@class,'oe_kanban_color_2')][2]")
    private WebElement marketplaceProductVariants;

    @FindBy(className = "o_menu_brand")
    private WebElement goToSellerDashboard;

    @FindBy(xpath = "//a[contains(@class, 'bg-primary') and contains(@data-name, '628')]")
    private WebElement pendingProducts;

    @FindBy(xpath = "//button[contains(@name, 'approved')]")
    private WebElement approveProductBtn;

    @FindBy(xpath = "//button[contains(@name, 'approve_selected_variant_button')]")
    private WebElement approveSelectedBtn;

    @FindBy(className = "text-muted")
    private WebElement productTitle;

    @FindBy(xpath = "//li[contains(@title, 'Previous menu')][2]//a")
    private WebElement goOnePageBackBtn;

    @FindBy(className = "c_dots_menu")
    private WebElement menuLat;

    @FindBy(xpath = "//a[contains(@class,'nav-link active')]//img[contains(@class,'sidebar_img')]")
    private WebElement menuSellerDashboard;

    /**
     * Menu bar
     */
    @FindBy(xpath = "//button[contains(@title, 'Products')]")
    private WebElement productsMenuBtn;

    @FindBy(xpath = "//a[contains(@data-menu-xmlid, 'odoo_marketplace.wk_seller_dashboard_menu2_sub_menu5')]")
    private WebElement products_productsBtn;

    @FindBy(className = "o-kanban-button-new")
    private WebElement createNewProductBtn;

    public String checkDashboard(){
        String message = "Invalid Dashboard";
        waitForElementToBeVisible(dashboardTitle);
        switch(dashboardTitle.getText()){
                case "Admin Dashboard" -> message = "Admin Dashboard";
                case "Seller Dashboard"-> message = "Seller Dashboard";
            }
        print(message);
        return message;
    }

    public void clickOnUserMenu(){
        clickOnElement(userMenu);
    }

    public void logOut(){
        clickOnUserMenu();
        clickOnElement(datamenu_LogOut);
    }

    public void clickOnProductsBtn(){
        click(productsMenuBtn);
    }

    public void clickOnSubmenuProduct(){
        waitForElementToBeVisible(products_productsBtn);
        click(products_productsBtn);
    }

    public void clickOnCreateNewProduct(){
        click(createNewProductBtn);
    }

    public void goToPickUpLocation(){}

    public void clickOnCreateNewPickUpLocation(){}

    public void fillPickUpLocationForm(){}

    public boolean checkNewLocationIsCreated(){
        return true;
    }

    /**
     * ADMIN METHODS
     * */
    public void clickOnPendingProducts(){
        safeClick(pendingProducts);
    }

    public void clickOnFirstPendingProduct(){
        waitForElementToBeVisible(productTitle);
        findElement(By.xpath("//div[contains(@class, 'oe_kanban_color_0')][1]")).click();
    }

    public void clickOnApproveProduct(){
        click(approveProductBtn);
    }

    public void clickOnApproveAndPublish(){
        click(approveSelectedBtn);
    }

    public boolean checkProductIsNotLongerPending(){
        String productName = productTitle.getText();
        print("PRODUCT NAME-   "+productName);
        waitForElementToBeVisible(dashboardTitle);
        safeClick(dashboardTitle);
        clickOnPendingProducts();
        List<WebElement> listPending = findElements(By.id("product_name"));
        Boolean isPresent = false;

        for(WebElement e:listPending){
            print("PRODUCT -   "+e);
            if(Objects.equals(e.getText(), productName)){isPresent = true;}
        }
        return isPresent;
    }

}
