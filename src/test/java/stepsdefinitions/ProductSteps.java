package stepsdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import pages.ProductPage;

public class ProductSteps {
    private AppiumDriver driver = HooksSteps.getDriver();
    private final ProductPage productPage = new ProductPage(driver);

    @And("taps on plus icon twice")
    public void tapsOnPlusIconTwice() {
        productPage.tapOnPlusBtn();
        productPage.tapOnPlusBtn();
    }

    @And("taps on minus icon once")
    public void tapsOnMinusIconOnce() {
        productPage.tapOnMinusBtn();
    }

    @And("taps to add to cart icon")
    public void tapsToAddToCartIcon() {
        productPage.tapOnAddToCart();
    }


}
