package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static constants.Constants.DIRECTORY_IMAGES;
import static constants.Constants.EXPLICIT_WAIT;
import static utils.CommonMethods.holdOn;
import static utils.CommonMethods.print;

public class BasePage_Odoo {
    private WebDriver driver;
    private WebDriverWait wait;
    public BasePage_Odoo(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        PageFactory.initElements(driver, this);
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void type(String inputText, WebElement element){
        waitForElementToBeVisible(element);
        if (isDisplayed(element)){
            element.sendKeys(inputText);
            print("Typed: "+inputText);
        }
        else{
            print(element+" IS NOT DISPLAYED");
        }

    }

    public void enterKeyboard(WebElement element){
        // Perform "Enter" key press
        element.sendKeys(Keys.RETURN);
    }

    public void clearAndType(String inputText, WebElement element){
        element.clear();
        element.sendKeys(inputText);
    }

    public void clearAllAndType(String inputText, WebElement element){

        String os = System.getProperty("os.name");
        // sending Ctrl+a by Keys.Chord()
        String s = Keys.chord(Keys.COMMAND, "a");

        if (os.equals("WINDOWS")){
             s = Keys.chord(Keys.CONTROL, "a");
        }
        element.sendKeys(s);
        // sending DELETE key
        element.sendKeys(Keys.DELETE);
        element.clear();
        element.sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void clickOnElement(WebElement element){
        if (isDisplayed(element)){
            safeClick(element);
            print("Clicked on element "+element);
        }else{
            print("Element "+element+" is not displayed");
        }
    }

    public void click(WebElement element){
        waitForElementToBeVisible(element);
        element.click();
    }

    public void safeClick(WebElement locator){
        try {
            click(locator);
        }catch(ElementClickInterceptedException e){
            handle_error(locator);
        }
    }

    public void doubleClick(WebElement element){
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();

    }
    public void rightClick(WebElement element){
        Actions action = new Actions(driver);
        action.contextClick(element).perform();

    }
    public void handle_error(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public String handle_alert() {
        holdOn(3000);
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        System.out.println(message);
        alert.accept();
        return message;
    }

    public boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean isDisplayed(WebElement element){
        try{
            return element.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
    public void visit(String url){
        driver.get(url);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public Boolean compareWithCurrentUrl(String expected_url){
        return driver.getCurrentUrl().contains(expected_url);
    }

    public void waitForElementToBeVisible(WebElement element){
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch(TimeoutException e){
            holdOn(1000);
        }
    }

    public void waitUntilIsNotVisible(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void hoverElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        print("Hovered on element: "+element);
    }

    public void uploadFirstImage(WebElement uploadElement, String fileName) {
        String imagePath = DIRECTORY_IMAGES+fileName;
        waitForElementToBeVisible(uploadElement);
        WebElement input = driver.findElement(By.xpath("//input[contains(@class,'o_input_file')]"));
        input.sendKeys(imagePath);
        holdOn(800);
        print(fileName+" uploaded successfully");
    }

    public void uploadRestImages(WebElement uploadElement, String fileName){
        String imagePath = DIRECTORY_IMAGES+fileName;
        holdOn(1000);
        WebElement input = driver.findElement(By.xpath("//div[contains(@class,'o_website_sale_image_modal')]//form//input[contains(@class,'o_input_file')][1]"));
        input.sendKeys(imagePath);
        holdOn(800);
        print(fileName+" uploaded successfully");
    }

    public void scrollDown(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Scroll down by a specified pixel value
        int scrollPixel = 500; // You can adjust this value as per your requirement
        jsExecutor.executeScript("window.scrollBy(0, " + scrollPixel + ");");
        print("Scroll down performed");
    }

    public void scrollIntoView(WebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Scroll to the element
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

    }
}
