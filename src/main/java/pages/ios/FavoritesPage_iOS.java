package pages.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.List;

import static apis.MafaoAPIs.getAlertsQuantity;
import static utils.CommonMethods.print;

public class FavoritesPage_iOS extends BasePage_iOS {
    public FavoritesPage_iOS(AppiumDriver driver) {
        super(driver);
    }

    By favoriteBtn = MobileBy.AccessibilityId("favorite-button");
    By backBtn = MobileBy.AccessibilityId("\uF208");
    By createAlertBtn = MobileBy.AccessibilityId("Create an alert");

    By deleteAlertBtn = MobileBy.AccessibilityId("Delete");
    By confirmDeletion = MobileBy.AccessibilityId("Confirm");
    By deletionConfirmedMessage = MobileBy.AccessibilityId("Alert has been deleted successfully");

    By listProducts = MobileBy.xpath("//android.view.ViewGroup[contains(@content-desc, 'favorite-button')]");

    public void tapFavoriteFromMarketplace1(String productNumber){
        List<MobileElement> elements = getElements(listProducts);
        tap(elements.get(0));
        tap(elements.get(1));
        tap(elements.get(2));
    }

    public boolean checkFavoritesIsNotEmpty(){
        boolean displayed = false;
        try {
            By product = MobileBy.xpath("//android.view.ViewGroup[contains(@content-desc,'product-')]");
            displayed = isDisplayed(getElement(product));
        }catch(NoSuchElementException e){
            print("Favorite list is empty");
        }
        return displayed;
    }

    public void tapOnProduct(String productName){
        By product = MobileBy.AccessibilityId("product-"+productName);
        tap(getElement(product));
    }

    public void tapFavoriteFromProduct(){
        tap(getElement(favoriteBtn));
        tap(backBtn);
    }

    public void tapCreateAnAlert(){
        tap(getElement(createAlertBtn));
        tap(backBtn);
    }

    public void tapOnAlerts(){
        By alertBtn = MobileBy.AccessibilityId("Alerts ("+getAlertsQuantity()+")");
        tap(alertBtn);
    }

    public boolean checkAlertIsDisplayed(String keyword){
        By alert = MobileBy.xpath("//XCUIElementTypeOther[contains(@name,'"+keyword+"')]");
        return isDisplayed(alert);
    }

    public void tapOnDeleteAlert(){
        tap(deleteAlertBtn);
    }

    public void confirmDeletionAlert(){
        tap(confirmDeletion);
    }

    public boolean checkAlertIsDeleted(){
        return isDisplayed(deletionConfirmedMessage);
    }


    public boolean checkProductIsDisplayed(String productName){
        By product = MobileBy.xpath("//XCUIElementTypeOther[contains(@name,'product-"+productName+"')]");
        return isDisplayed(product);
    }

    public void tapFavoriteFromMarketplace(String productName){
        By product = MobileBy.AccessibilityId("product-"+productName);
        MobileElement favorite = findElementFromElement(getElement(product),favoriteBtn);
        tap(favorite);
    }

    public void tapToRemove(){
        By listFavorites = MobileBy.xpath("//android.view.ViewGroup[contains(@content-desc,'favorite-button')]");
        tap(getElement(listFavorites));
        print("Removed first element of favorites list");
    }

    public void removeAllProductsFromFavorites(){
        try{while (checkFavoritesIsNotEmpty()){
            tapToRemove();
        }}catch(NoSuchElementException | StaleElementReferenceException e){
            print("No more elements on the list");
        }
    }

}
