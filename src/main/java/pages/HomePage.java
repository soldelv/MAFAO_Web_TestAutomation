package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".fa.fa-user-o")
    private WebElement userIcon;

    @FindBy(css = "i.fa.fa-shopping-cart")
    private WebElement cartIcon;

    @FindBy(css = "i.fa.fa-search.te_srch_icon")
    private WebElement searchIcon;

    @FindBy(css = ".img.img-fluid")
    private WebElement mafaoLogo;

    @FindBy(css = "navbar-toggler-icon")
    private WebElement navbarIcon;


    public void clickOnUserIcon(){
        clickOnElement(userIcon);
    }

    public void clickOnCartIcon(){
        clickOnElement(cartIcon);
    }

    public void clickOnSearchIcon(){
        clickOnElement(searchIcon);
    }

    public void clickOnMafaoLogo(){
        clickOnElement(mafaoLogo);
    }



}
