package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     Elements for MAFAO main page
     */
    @FindBy(xpath = "//body/div[@id='wrapwrap']/main[1]/div[1]/form[1]/div[1]/input[1]")
    private WebElement userEmail;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[1]/form[1]/div[2]/input[1]")
    private WebElement userPassword;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[1]/form[1]/div[3]/button[1]")
    private WebElement loginButton;

    @FindBy(css = ".list-group-item.list-group-item-action.py-2")
    private WebElement loginWithButton;

    @FindBy(xpath = "//body//div[//@id='wrapwrap']//main[1]//div[1]//form[1]//p[1]")
    private WebElement getInvalidLogin;

    /**
    Elements for login with Keycloack
    */
    @FindBy(id = "username")
    private WebElement userKey;

    @FindBy(id = "password")
    private WebElement passwordKey;

    @FindBy(css = ".btn.btn-primary.btn-block.btn-lg")
    private WebElement loginButtonKey;

    @FindBy(xpath = "//div[contains(@id, 'kc-registration')]//span//a")
    private WebElement registerKey;

    @FindBy(xpath = "//div[contains(@class, 'form-group login-pf-settings')]//div//span//a")
    private WebElement forgotPasswordKey;

    @FindBy(className = "kc-feedback-text")
    private WebElement invalidLoginKc;

    /**
     Methods for MAFAO main page
     */
    public void fillLoginForm(String username, String password) throws InterruptedException {
        if(isDisplayed(loginButton)){
            type(username, userEmail);
            type(password, userPassword);
            waitForElementToBeVisible(loginButton);

            try{
                click(loginButton);
                Thread.sleep(1000);
            }catch(ElementClickInterceptedException | InterruptedException e){
                handle_error(loginButton);
            }
        }else{
            System.out.println("Button Login is not displayed");
        }
    }

    public void clickOnLoginWithKeycloak(){
        clickOnElement(loginWithButton);
    }
    public Boolean checkErrorLogin() throws InterruptedException {
        Thread.sleep(1000);
        return isDisplayed(getInvalidLogin);
    }


    /**
     * Methods for login with Keycloack
     */

    public void fillLoginFormWithKey(String username, String password) {
        if(isDisplayed(loginButtonKey)){
            type(username, userKey);
            type(password, passwordKey);
            waitForElementToBeVisible(loginButtonKey);

            try{
                click(loginButtonKey);
                Thread.sleep(1000);
            }catch(ElementClickInterceptedException | InterruptedException e){
                handle_error(loginButtonKey);
            }
        }else{
            System.out.println("Button Login is not displayed");
        }
    }

    public Boolean checkErrorLoginKc() throws InterruptedException {
        Thread.sleep(1000);
        return isDisplayed(invalidLoginKc);
    }

    public void clickOnForgotPasswordKey(){
        clickOnElement(forgotPasswordKey);
    }

    public void clickOnRegisterNewUserKey(){
        clickOnElement(registerKey);
    }


}
