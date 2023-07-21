package pages.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static utils.CommonMethods.print;


public class BasePage_iOS {
    //protected AppiumDriver driver;
    protected IOSDriver driver;
    public AndroidTouchAction actions;

    /*public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }*/
    public BasePage_iOS(AppiumDriver driver) {
        this.driver = (IOSDriver) driver;
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

    /* ALERTS */
    public void testSimpleAlert() {
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Simple").click();
        driver.switchTo().alert().accept();
    }

    public void testOkayCancelAlert() {
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Okay / Cancel").click();
        driver.switchTo().alert().dismiss();
    }

    public void testSendTextAlert() {
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByAccessibilityId("Text Entry").click();
        driver.switchTo().alert().sendKeys("Hello TAU");
        driver.switchTo().alert().accept();
    }

    /* scroll in ios */
    public void testScroll() {
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction","down");
        scrollObject.put("value","Web View");
        driver.executeScript("mobile:scroll",scrollObject);
        driver.findElementByAccessibilityId("Web View").click();
    }

    /* send photos */
    public void testSendPhotos() throws IOException {
        File classPath, imageDir, img;
        String imgName = "TAU-logo.png";

        classPath = new File(System.getProperty("user.dir"));
        imageDir = new File(classPath, "/resources/images");
        img = new File(imageDir.getCanonicalFile(), imgName);
        driver.pushFile(imgName,img);
    }

    /* sliders */
    public void testSlider() {
        driver.findElementByAccessibilityId("Sliders").click();
        IOSElement slider = (IOSElement) driver.findElement(By.xpath("//XCUIElementTypeSlider"));
        slider.setValue("0%");
        slider.setValue("1%"); // 100%
        slider.setValue("0.5%"); // 48%
        //Assert.assertEquals(slider.getAttribute("value"),"48%");
    }


}