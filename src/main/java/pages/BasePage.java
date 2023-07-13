package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static utils.CommonMethods.print;


public class BasePage {
    protected AppiumDriver driver;
    public AndroidTouchAction actions;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    /* common elements */
    By searchBar = MobileBy.AccessibilityId("search-bar");
    public void tapOnSearchbar()  {
        tap(searchBar);
    }
    public void searchByKeywordOnSearchbar(String keyword)  {
        type(keyword,searchBar);
        waitFor(30);
    }
    public MobileElement checkElement(By locator){
        try{
            return (MobileElement) driver.findElement(locator);
        }catch(NoSuchElementException ignored){
            return null;
        }
    }
    public MobileElement getElement(By locator){
        while(checkElement(locator)==null){
            waitFor(5);
        }
        return (MobileElement) driver.findElement(locator);
    }

    public List getElements(By locator){
        return driver.findElements(locator);
    }

    public MobileElement findElementFromElement(MobileElement element, By locator){
        return element.findElement(locator);
    }

    public boolean isDisplayed(MobileElement element){
        return element.isDisplayed();
    }

    public boolean isDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

    public void type(String inputText, By locator){
        print(" TYPING ------- "+inputText);
        getElement(locator).sendKeys(inputText);
        print("Typed on element "+locator);
    }

    public void clear(MobileElement element) {
        element.clear();
    }

    public void tap(MobileElement element) {
        element.click();
        print("Tapped on "+element);
    }

    public void tap(By locator) {
        getElement(locator).click();
        print("Tapped on "+locator);
    }

    public String getAttribute(MobileElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public void scrollDown() {
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.8);
        int scrollEnd = (int) (dimension.getHeight() * 0.1);

        actions = new AndroidTouchAction(driver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release()
                .perform();
    }

    public void typeFromKeyboard(String locator, String numberToType){
        char[] splitNumber = numberToType.toCharArray();
        print("Split number" + Arrays.toString(splitNumber));

        for (char i : splitNumber) {
            print("TAP NUMBER --- "+String.valueOf(i));
            By key = MobileBy.AccessibilityId(String.valueOf(locator+i));
            tap(key);
        }
    }

    public void waitFor(long seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

}