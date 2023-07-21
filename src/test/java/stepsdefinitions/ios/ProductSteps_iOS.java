package stepsdefinitions.ios;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import pages.ios.ProductPage_iOS;
import stepsdefinitions.HooksSteps;

public class ProductSteps_iOS {
    private AppiumDriver driver = HooksSteps.getDriver();
    private final ProductPage_iOS productPage = new ProductPage_iOS(driver);
    private static String product_price;

    @And("taps on plus icon")
    public void tapsOnPlusIcon() {
        productPage.tapOnPlusBtn();
    }

    @And("taps on minus icon")
    public void tapsOnMinusIcon() {
        productPage.tapOnMinusBtn();
    }

    @And("^add (.*) to cart$")
    public void tapsToAddToCartIcon(String productName) {
        productPage.tapOnAddToCart(productName);
    }
}
