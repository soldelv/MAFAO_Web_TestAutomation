package pages.odoo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;
import java.util.Objects;

import static utils.CommonMethods.*;

public class NewProductPage extends BasePage_Odoo{

    public NewProductPage(WebDriver driver) {
        super(driver);
    }
    public static String productTitleName;
    @FindBy(xpath = "//div[contains(@class,'oe_title')]//h1//input")
    private WebElement productName;

    @FindBy(xpath = "//div[contains(@class,'o_field_many2one') and contains(@name,'public_categ_ids')]")
    private WebElement categoryInput;

    @FindBy(xpath = "//ul[contains(@class,'dropdown-menu')]//li//a[contains(text(),'Hardware')]")
    private WebElement hardwareCategory;

    @FindBy(xpath = "//textarea[contains(@name,'description_sale')]")
    private WebElement descriptionField;

    @FindBy(xpath = "//div[contains(@name,'list_price')]//input")
    private WebElement salesPrice;

    @FindBy(xpath = "//div[contains(@class,'o_form_image_controls')]//button[contains(@title, 'Edit')]")
    private WebElement pencilFirstImageBtn;

    @FindBy(xpath = "//li[contains(@class, 'nav-item')][2]")
    private WebElement variantsBtn;

    @FindBy(xpath = "//li[contains(@class, 'nav-item')][3]")
    private WebElement productImagesBtn;

    @FindBy(xpath = "//li[contains(@class, 'nav-item')][4]")
    private WebElement inventoryBtn;

    @FindBy(xpath = "//tr[contains(@data-id, 'product.template.attribute.line_8')]//td[2]")
    private WebElement colorField;

    @FindBy(xpath = "//tr[contains(@data-id, 'product.template.attribute.line_8')]//td[2]//div[contains(@class,'o_input_dropdown')]")
    private WebElement colorField_input;

    @FindBy(xpath = "//tr[contains(@data-id, 'product.template.attribute.line_11')]//td[2]")
    private WebElement heightField;

    @FindBy(xpath = "//tr[contains(@data-id, 'product.template.attribute.line_11')]//td[2]//div[contains(@class,'o_input_dropdown')]")
    private WebElement heightField_input;

    @FindBy(xpath = "//tr[contains(@data-id, 'product.template.attribute.line_14')]//td[2]")
    private WebElement widthField;

    @FindBy(xpath = "//tr[contains(@data-id, 'product.template.attribute.line_14')]//td[2]//div[contains(@class,'o_input_dropdown')]")
    private WebElement widthField_input;

    @FindBy(xpath = "//tr[contains(@data-id, 'product.template.attribute.line_17')]//td[2]")
    private WebElement lengthField;

    @FindBy(xpath = "//tr[contains(@data-id, 'product.template.attribute.line_17')]//td[2]//div[contains(@class,'o_input_dropdown')]")
    private WebElement lengthField_input;

    @FindBy(xpath = "//div//button[contains(@class, 'o-kanban-button-new')]")
    private WebElement addPhotoBtn;

    @FindBy(xpath = "//div[contains(@class,'col')]//button[contains(@title, 'Edit')]")
    private WebElement pencilRestImageBtn;

    @FindBy(id = "o_field_input_52")
    private WebElement imageNameInput;

    @FindBy(xpath = "//footer[contains(@class,'modal-footer')]//button[contains(@class, 'btn btn-primary')][2]")
    private WebElement saveAndNewBtn;

    @FindBy(xpath = "//footer[contains(@class,'modal-footer')]//button[contains(@class, 'btn btn-primary')][1]")
    private WebElement saveAndCloseBtn;

    @FindBy(xpath = "//input[contains(@name, 'sale_delay')]")
    private WebElement leadTime;

    @FindBy(xpath = "//input[contains(@placeholder, 'Initail Quantity')]")
    private WebElement initialQuantity;

    @FindBy(xpath = "//button[contains(@name, 'next_step')]")
    private WebElement nextStepBtn;

    @FindBy(xpath = "//td[contains(@name, 'pickup_location_id')]")
    private WebElement productLocation;

    @FindBy(xpath = "//a[contains(text(),'Reboleira')]")
    private WebElement chosenLocation;

    @FindBy(xpath = "//span[contains(text(),'Create Group')]")
    private WebElement createGroupBtn;

    @FindBy(xpath = "//input[contains(@name, 'expiration_date')]")
    private WebElement expirationDate;

    @FindBy(xpath = "//input[contains(@name, 'expiration_time')]")
    private WebElement expirationTime;

    @FindBy(xpath = "//td[contains(@colspan,'4')]//a[contains(@role,'button')]")
    private WebElement addLineBtn;

    @FindBy(xpath = "//input[contains(@name,'minimum_items')]")
    private WebElement minimumItemsInput;
    @FindBy(xpath = "//input[contains(@name,'maximum_items')]")
    private WebElement maximumItemsInput;
    //discount_percentage
    @FindBy(xpath = "//input[contains(@name,'discount_percentage')]")
    private WebElement discountPercentageInput;

    @FindBy(xpath = "//footer//button[contains(@class,'o_form_button_save')]")
    private WebElement formSaveBtn;

    @FindBy(xpath = "//button[contains(@class,'close')]")
    private WebElement closeBtn;

    @FindBy(xpath = "//button[contains(@name,'set_pending')]")
    private WebElement requestToApproveBtn;

    @FindBy(className = "o_menu_brand")
    private WebElement goToSellerDashboard;

    @FindBy(xpath = "//a[contains(@class, 'bg-primary') and contains(@data-name, '628')]")
    private WebElement pendingProducts;

    @FindBy(xpath = "//div[contains(@class, 'o_Message_trackingValueNewValue o_Message_trackingValueItem')]")
    private WebElement transitionStatus;

    public void fillNewProductFormInformation(){
        productTitleName = "product_"+generateDateTimeString();
        print("Product name: "+productTitleName);
        type(productTitleName,productName);
        safeClick(categoryInput);
        safeClick(hardwareCategory);
        String description = "Description generated automatically for product: "+productTitleName;
        type(description,descriptionField);
        String price = ""+generateRandom3DigitNumber();
        click(salesPrice);
        clearAndType(price,salesPrice);
    }

    public void fillNewProductFormVariants(){
        click(variantsBtn);
        holdOn(1000);
        click(colorField);
        click(colorField_input);
        holdOn(1000);
        WebElement color = findElement(By.xpath("//a[contains(text(),'Color: Pink')]"));
        click(color);
        holdOn(1000);
        click(heightField);
        click(heightField_input);
        holdOn(1000);
        WebElement height = findElement(By.xpath("//a[contains(text(),'Height (cm): 3')]"));
        click(height);
        holdOn(1000);
        click(widthField);
        click(widthField_input);
        holdOn(1000);
        WebElement width = findElement(By.xpath("//a[contains(text(),'Width (cm): 20')]"));
        click(width);
        holdOn(1000);
        click(lengthField);
        click(lengthField_input);
        holdOn(1000);
        WebElement length = findElement(By.xpath("//a[contains(text(),'Length (cm): 34')]"));
        click(length);
    }

    public void fillNewProductFormImages() throws AWTException {
        click(productImagesBtn);
        //First image
        WebElement elementToHover = findElement(By.className("o_form_image_controls"));
        hoverElement(elementToHover);
        uploadFirstImage(pencilFirstImageBtn, "0_image.jpg");

        //Rest of the images
        uploadAnImage(5);
    }
    public void uploadAnImage(int limitPictures) throws AWTException {
        click(addPhotoBtn);
        for(int i=1 ; i<=limitPictures; i++){
            String imageName = i+"_image.jpg";
            uploadRestImages(pencilRestImageBtn, imageName);
            if(i<limitPictures){
                click(saveAndNewBtn);
            }
        }
        click(saveAndCloseBtn);
        holdOn(800);
    }

    public void fillNewProductFormInventory(){
        click(inventoryBtn);
        holdOn(800);
        click(leadTime);
        clearAndType("3", leadTime);
        click(initialQuantity);
        clearAndType("200", initialQuantity);
        click(nextStepBtn);
    }

    public void fillNewProductFormPickUpLocation(){
        click(productLocation);
        click(productLocation);
        click(chosenLocation);
        click(nextStepBtn);
    }

    public void fillNewProductFormDiscountGroups(){
        click(createGroupBtn);

        //getDateThreeMonthsAfterToday()
        type(getDateThreeMonthsAfterToday(),expirationDate);
        enterKeyboard(expirationDate);
        type("10:30",expirationTime);
        enterKeyboard(expirationTime);
        scrollDown();
        scrollDown();
        scrollDown();
        scrollDown();
        click(addLineBtn);
        holdOn(1000);
        clearAllAndType("5",minimumItemsInput);
        clearAllAndType("10",maximumItemsInput);
        clearAllAndType("5", discountPercentageInput);
        enterKeyboard(discountPercentageInput);

        click(addLineBtn);
        holdOn(1000);
        clearAllAndType("11",minimumItemsInput);
        clearAllAndType("15",maximumItemsInput);
        clearAllAndType("10", discountPercentageInput);
        enterKeyboard(discountPercentageInput);
        scrollDown();
        holdOn(800);
        click(addLineBtn);
        holdOn(1000);
        clearAllAndType("16",minimumItemsInput);
        clearAllAndType("20",maximumItemsInput);
        clearAllAndType("15", discountPercentageInput);
        holdOn(1000);
        safeClick(formSaveBtn);
        holdOn(1000);
        safeClick(closeBtn);
    }

    public void fillNewProductFormRequestToApprove(){
        click(requestToApproveBtn);
    }

    public boolean checkProductIsInPendingList(){
        Boolean isPending = false;
        waitUntilIsNotVisible(requestToApproveBtn);
        waitForElementToBeVisible(transitionStatus);
        print(transitionStatus.getText());
        if (Objects.equals(transitionStatus.getText(), "Pending")){
            isPending=true;
        }
        return isPending;
    }
}
