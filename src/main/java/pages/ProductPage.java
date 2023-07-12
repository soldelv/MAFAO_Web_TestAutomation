package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import static utils.CommonMethods.holdOn;
import static utils.CommonMethods.print;

public class ProductPage extends BasePage{
    public ProductPage(AppiumDriver driver) {
        super(driver);
    }

    By favoriteBtn = MobileBy.AccessibilityId("favorite-button");
    By plusBtn = MobileBy.AccessibilityId("plus-button");
    By minusBtn = MobileBy.AccessibilityId("minus-button");
    By addToCartBtn = MobileBy.xpath("//android.widget.TextView[contains(@text, 'Add to cart')]");
    By backIconBtn = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView");


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
    public void tapOnAddToCart(){
        tap(addToCartBtn);
        print("Tapped on Add to cart");
        holdOn(500);
    }

    public void tapOnBackIcon(){
        tap(backIconBtn);
    }


}
