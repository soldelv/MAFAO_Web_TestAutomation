package pages.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import static apis.MafaoAPIs.getProductPrice;
import static utils.CommonMethods.holdOn;
import static utils.CommonMethods.print;

public class ProductPage_iOS extends BasePage_iOS {
    public ProductPage_iOS(AppiumDriver driver) {
        super(driver);
    }

    By favoriteBtn = MobileBy.AccessibilityId("favorite-button");
    By plusBtn = MobileBy.AccessibilityId("plus-button");
    By minusBtn = MobileBy.AccessibilityId("minus-button");

    public void tapOnFavoriteBtn()  {
        tap(getElement(favoriteBtn));
    }
    public void tapOnPlusBtn(){
        tap(plusBtn);
        print("Tapped on plus icon");
        holdOn(500);
    }

    public void tapOnMinusBtn(){
        tap(minusBtn);
        print("Tapped on minus icon");
        holdOn(500);
    }
    public void tapOnAddToCart(String productName){
        By addToCartBtn = MobileBy.AccessibilityId("Add to cart Amount: "+getProductPrice(productName)+" Fcfa");
        tap(addToCartBtn);
        print("Tapped on Add to cart");
        holdOn(500);
    }


}
