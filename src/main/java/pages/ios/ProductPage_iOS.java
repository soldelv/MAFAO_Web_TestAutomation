package pages.ios;

import apis.Product;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.util.Objects;

import static apis.MafaoAPIs.getProductInfoByName;
import static apis.MafaoAPIs.getSimilarProductsById;
import static org.testng.AssertJUnit.fail;
import static utils.CommonMethods.*;

public class ProductPage_iOS extends BasePage_iOS {
    public ProductPage_iOS(AppiumDriver driver) {
        super(driver);
    }

    By favoriteBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='favorite-button'])[3]");
    By plusBtn = MobileBy.AccessibilityId("plus-button");
    By minusBtn = MobileBy.AccessibilityId("minus-button");
    By sellerInfo = MobileBy.xpath("//XCUIElementTypeOther[@name='vendor-info']");
    By reportThisProductBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='Report this product'])[2]");
    By reportMessage = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Thank you, We will check and  review your report and advise you of our decision.']");
    By okReportBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='button-ok'])[2]");
    By callBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='call-button'])[2]");
    By shareBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='share-button'])[3]");
    By similarProductsSection = MobileBy.AccessibilityId("Similar products");

    /** SELLER INFO */
    //Hardcoded to Gold
    By auchanLogo = MobileBy.xpath("//XCUIElementTypeOther[@name='Gold']/XCUIElementTypeOther[1]/XCUIElementTypeImage");
    //Hardcoded
    By titleAuchan = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Auchan Mermoz, Senegal']");
    By bonusDistributed = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Bonus distributed']");
    By reviews = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Product reviews']");
    By dispatch = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Dispatch']");
    By sales = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Sales']");
    By sellerSince = MobileBy.xpath("//XCUIElementTypeStaticText[contains(@name,'Seller since')]");


    public void tapOnFavoriteBtn()  {
        tap(favoriteBtn);
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
        By addToCartBtn = MobileBy.AccessibilityId("Add to cart Amount: "+getProductInfoByName(productName).getFormattedListPrice()+" Fcfa");
        tap(addToCartBtn);
        print("Tapped on Add to cart");
        holdOn(500);
    }
    public void tapOnSellerInfo(){
        tap(sellerInfo);
    }
    public void tapOnReportThisProductBtn(){
        tap(reportThisProductBtn);
    }

    public void fillReportProductForm(){
        By reason = MobileBy.xpath("(//XCUIElementTypeOther[@name='others'])[3]");
        By descriptionField = MobileBy.xpath("//XCUIElementTypeOther[@name='sexually_inappropriate violence offensive others Horizontal scroll bar, 1 page Vertical scroll bar, 1 page Your comment validate-button validate-button']/XCUIElementTypeOther[2]/XCUIElementTypeTextView");
        By validateBtn = MobileBy.xpath("(//XCUIElementTypeOther[@name='validate-button'])[2]");
        String description = "Test description";
        tap(reason);
        type(description,descriptionField);
        tap(validateBtn);
        tap(validateBtn);
    }

    public boolean checkReportMessageIsDisplayed(){
        return isDisplayed(reportMessage);
    }
    public void tapOnOkReportBtn(){
        tap(okReportBtn);
    }

    public boolean checkSellerInfo(){
        return isDisplayed(titleAuchan) && isDisplayed(sellerSince) && isDisplayed(auchanLogo)
                && isDisplayed(bonusDistributed) && isDisplayed(reviews) && isDisplayed(dispatch)
                && isDisplayed(sales);
    }
    public void tapOnCallBtn(){
        tap(callBtn);
    }

    public void checkProductDetailView(String productName){
        Product productInfo = getProductInfoByName(productName);
        By productTitle = MobileBy.xpath("//XCUIElementTypeStaticText[@name='"+productName+"']");
        By productDescription = MobileBy.xpath("//XCUIElementTypeStaticText[@name='"+productInfo.getDescription_sale()+"']");
        By inStock = MobileBy.xpath("//XCUIElementTypeStaticText[@name='In stock']");
        By ratingsAndReviews = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Rating and review 0/5']");
        By oldPrice = MobileBy.xpath("//XCUIElementTypeStaticText[@name='"+productInfo.getFormattedOldPrice()+" Fcfa']");
        By currentPrice = MobileBy.xpath("//XCUIElementTypeStaticText[@name='"+productInfo.getFormattedListPrice()+" Fcfa']");
        By expirationDate = MobileBy.xpath("//XCUIElementTypeStaticText[@name=' \n" +
                " Offer ends on  December 31 at 00:00']");

        if(isDisplayed(favoriteBtn)){ print("Favorite button is displayed");
        }else{
            fail("Favorite button is not displayed");
        }
        if(isDisplayed(shareBtn)){ print("Share button is displayed");
        }else{
            fail("Share button is not displayed");
        }
        if(isDisplayed(productTitle)){ print("Product title is displayed");
        }else{
            fail("Product title is not displayed");
        }
        if(isDisplayed(productDescription)){ print("Product description is displayed");
        }else{
            fail("Product description is not displayed");
        }
        if(isDisplayed(inStock)){ print("InStock displayed");
        }else{
            fail("Product description is not displayed");
        }
        if(isDisplayed(ratingsAndReviews)){ print("Ratings And Reviews are displayed");
        }else{
            fail("Ratings And Reviews are not displayed");
        }
        if(isDisplayed(oldPrice)){ print("Old Price is displayed");
        }else{
            fail("Old Price is not displayed");
        }
        if(isDisplayed(currentPrice)){ print("Current Price is displayed");
        }else{
            fail("Current Price is not displayed");
        }
        if(isDisplayed(getExpirationDate(productInfo.getExpiration_date()))){
            print("expirationDate is displayed");
        }else{
            fail("expirationDate is not displayed");
        }
        scrollDown();
        if(isDisplayed(similarProductsSection)){ print("Similar products are displayed");
        }else{
            fail("Similar products are not displayed");
        }
    }

    public By getExpirationDate(String date){
        By expirationDate = MobileBy.xpath("//XCUIElementTypeStaticText[@name=' \n" +
                " Offer ends on  "+convertDateTime(date)+"']");
        return expirationDate;
    }

    public boolean similarProductsSectionIsDisplayed(){
        return isDisplayed(similarProductsSection);
    }

    public void checkSimilarProductsAreDisplayed(String productName){
        int productId = getProductInfoByName(productName).getId();
        Product[] similarProductsList = getSimilarProductsById(String.valueOf(productId));

        for (Product product : similarProductsList) {
            By locator = MobileBy.xpath("(//XCUIElementTypeOther[@name='product-"+product.getDisplay_name()+"'])[2]");
            if(product.getId()!=productId){
                if(isDisplayed(locator)){
                    print("Product: "+product.getDisplay_name()+" is displayed");
                }else{
                    fail("Product: "+product.getDisplay_name()+" is not displayed");
                }
            }
        }
    }

}
