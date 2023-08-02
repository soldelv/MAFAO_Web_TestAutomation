package pages.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import static utils.CommonMethods.holdOn;
import static utils.CommonMethods.print;

public class HomePage_iOS extends BasePage_iOS {
    public HomePage_iOS(AppiumDriver driver) {
        super(driver);
    }
    By homeIcon = MobileBy.AccessibilityId("home");
    By favoritesIcon = MobileBy.AccessibilityId("favorites");
    By ordersIcon = MobileBy.AccessibilityId("orders");
    By bonusIcon = MobileBy.AccessibilityId("******");
    By retiradaIcon = MobileBy.AccessibilityId("retirada");
    By profileIcon = MobileBy.AccessibilityId("profile");
    By notifBtn = MobileBy.AccessibilityId("notif-button");

    /** CATEGORIES **/
    By informatiqueCat = MobileBy.AccessibilityId("Informatique");
    By hardwareCat = MobileBy.AccessibilityId("Hardware");
    By sportCat = MobileBy.AccessibilityId("Sport");
    By accessoiresCat = MobileBy.AccessibilityId("Jouets et Accessoires");
    By homeCat = MobileBy.AccessibilityId("Maison, cuisine & bureau");
    By hypermarcheCat = MobileBy.AccessibilityId("Hypermarché");
    By equipementCat = MobileBy.AccessibilityId("Équipement");
    By fetesCat = MobileBy.AccessibilityId("Fêtes");

    /** PRODUCTS */
    By listProductsFav = MobileBy.xpath("//android.view.ViewGroup[contains(@content-desc, 'favorite-button')]");
    public void tapOnBackIcon(){
        print("Before tap back icon");
        tapOnBackBtn();
        print("already tap on back icon");
    }
    public boolean checkOnMarketplace(){
        return isDisplayed(searchBar);
    }

    public void tapOnHome()  {
        tap(homeIcon);
    }

    public void tapOnFavorites()  {
        tap(favoritesIcon);
    }

    public void tapOnOrders(){
        tap(ordersIcon);
    }

    public void tapOnBonus(){
        tap(bonusIcon);
    }

    public void tapOnNotificationsBtn(){
        tap(notifBtn);
    }

    public void tapOnRetirada(){
        tap(retiradaIcon);
    }

    public void tapOnProfile(){
        tap(profileIcon);
    }
    public void chooseAndTapFavoriteFromMarketplace(){
        List<MobileElement> elements = getElements(listProductsFav);
        tap(elements.get(0));
        tap(elements.get(1));
        tap(elements.get(2));
    }

    public void tapsOnProduct(){
        print("Hardcoding product");
        By product = MobileBy.AccessibilityId("product-Inflatables for swimming pool");
        tap(product);
    }

    public void tapOnProduct(String productName){
        By product = MobileBy.AccessibilityId("product-"+productName);
        tap(product);
    }

    public boolean checkProductsAreListed(String keyword){
        try{
            By products = MobileBy.xpath("//XCUIElementTypeOther[contains(@name, '"+keyword+"')]");
            List elements = getElements(products);
            return (elements.size()>0);
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public void tapOnCategory(String categoryName){
        switch (categoryName) {
            case "Informatique" -> tap(informatiqueCat);
            case "Hardware" -> tap(hardwareCat);
            case "Sport" -> tap(sportCat);
            case "Toys and Accessories"-> tap(accessoiresCat);
            case "Home, Kitchen and Office"-> tap(homeCat);
            case "Hypermarket" -> tap(hypermarcheCat);
            case "Equipement" -> tap(equipementCat);
            case "Fêtes"-> tap(fetesCat);
            default -> {
                print("Invalid category name");
            }
        }
        holdOn(5);
    }

    public boolean checkCategoryProductsAreDisplayed(){
        By products = MobileBy.xpath("//XCUIElementTypeOther[contains(@name,'product-')]");
        return isDisplayed(products);
    }

}
