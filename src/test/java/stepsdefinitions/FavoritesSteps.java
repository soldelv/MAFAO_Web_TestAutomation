package stepsdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.FavoritesPage;

import static utils.CommonMethods.print;

public class FavoritesSteps {
    private AppiumDriver driver = HooksSteps.getDriver();
    private final FavoritesPage favoritesPage = new FavoritesPage(driver);

    @When("^chooses (.*), (.*), (.*) from marketplace and taps as favorite$")
    public void choosesProduct_Product_Product_FromMarketplaceAndTapsAsFavorite(String p1, String p2, String p3) {
        favoritesPage.tapFavoriteFromMarketplace(p1);
        favoritesPage.tapFavoriteFromMarketplace(p2);
        favoritesPage.tapFavoriteFromMarketplace(p3);
    }
    @Then("^(.*), (.*), (.*) are displayed on Favorites list")
    public void theProductIsDisplayedOnFavoritesList(String p1, String p2, String p3) {
        Assertions.assertTrue(favoritesPage.checkProductIsOnFavorites(p1));
        Assertions.assertTrue(favoritesPage.checkProductIsOnFavorites(p2));
        Assertions.assertTrue(favoritesPage.checkProductIsOnFavorites(p3));
    }

    @When("^scrolls down searching for (.*)$")
    public void theUserSearchesForProduct_(String product1) {
        print("Scroll until search product "+product1);
        favoritesPage.scrollDown();
        favoritesPage.scrollDown();
        favoritesPage.scrollDown();
        favoritesPage.scrollDown();
    }

    @And("taps on the heart icon to add the product as a favorite")
    public void tapsOnTheHeartIconToAddTheProductAsAFavorite() {
        favoritesPage.tapFavoriteFromProduct();
    }

    @Then("^(.*) is displayed on Favorites list$")
    public void theProductIsDisplayedOnFavoritesList(String product) {
        Assertions.assertTrue(favoritesPage.checkProductIsOnFavorites(product));
    }

    @Given("the user has products on favorites list")
    public void theUserHasProductsOnFavoritesList() throws InterruptedException {
        Thread.sleep(3000);
        Assertions.assertTrue(favoritesPage.checkFavoritesIsNotEmpty());
    }

    @When("taps on the heart icon to remove the product as a favorite")
    public void tapsOnTheHeartIconToRemoveTheProductAsAFavorite() {
        favoritesPage.removeAllProductsFromFavorites();
    }

    @Then("the products are not longer displayed on favorites list")
    public void theProductIsNotLongerDisplayedOnFavoritesList() throws InterruptedException {
        Thread.sleep(1000);
        Assertions.assertFalse(favoritesPage.checkFavoritesIsNotEmpty());
    }
}
