package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAndReturnsPage extends CommonAPI {
    
 Logger LOG = LogManager.getLogger(OrderAndReturnsPage.class);
 
    public OrderAndReturnsPage (WebDriver driver ) {
        PageFactory.initElements( driver,this );
    }

    @FindBy (xpath="//a[@href='https://magento.softwaretestingboard.com/sales/guest/form/']")
    WebElement linkToOrderAndReturnsPage;
    @FindBy (xpath="//span[@class='base']")
    WebElement orderAndReturnsPageTitle;
    @FindBy (xpath="//span[.='Order Information']")
    WebElement titleForm;

    @FindBy (xpath="//label[@for='oar-order-id']")
    WebElement orderIdTitle;

    @FindBy (xpath="//input[@id='oar-order-id']")
    WebElement orderField;

    @FindBy (xpath="//label[@for='oar-billing-lastname']")
    WebElement billingLastname;


    @FindBy (xpath="//input[@id='oar-billing-lastname']")
    WebElement billingLastNameField;

    @FindBy (xpath="//label[@for='quick-search-type-id']")
    WebElement findOrderBy;

    @FindBy (xpath="//select[@id='quick-search-type-id']")
    WebElement filterOrderBy;

    @FindBy (xpath="//label[@for='oar_email']")
    WebElement titleEmail;

    @FindBy (xpath="//input[@id='oar_email']")
    WebElement emailField;

    @FindBy (xpath="//label[@for='oar_zip']")
    WebElement zipCodeLabel;

    @FindBy (xpath="//*[@id=\"oar_zip\"]")
    WebElement zipField;

    @FindBy (xpath="//button[@title='Continue']")
    WebElement continueBtn;

    @FindBy (xpath="//span[@data-ui-id='page-title-wrapper']")
    WebElement orderViewPageTitle;

    @FindBy (xpath="//*[@id=\"maincontent\"]/div[1]/span")
    WebElement orderStatus;

    @FindBy (xpath="//*[@id=\"maincontent\"]/div[3]/div/ul/li/strong")
    WebElement orderInfo;

    @FindBy (xpath="//strong[@class='product name product-item-name']")
    WebElement orderedProductName;

    @FindBy  (xpath="//*[@class='message-error error message']")
    WebElement messageErrorIncorrectData;







    public void clickOrderAndReturnsPage (){
        clickOn(linkToOrderAndReturnsPage);
    }

    public boolean OrderAndReturnsPageTitleDisplayed (){
        LOG.info("order And Returns Page Title Displayed");
       return isDisplayed(orderAndReturnsPageTitle);
    }

    public boolean titleFormIsDisplayed (){
        LOG.info("title Form is displayed");
        return isDisplayed(titleForm);
    }

    public boolean orderTitleIsDisplayed (){
        LOG.info("order title is displayed");
        return isDisplayed(orderIdTitle);
    }

    public void typeOrderId (String orderId) {
        type(orderField,orderId);
    }

    public boolean billingLastnameIsDisplayed (){
        LOG.info("billing last name Is Displayed");
        return   isDisplayed(billingLastname);
    }

    public void typeBillingLastName (String lastName) {
        type(billingLastNameField,lastName);
    }

    public boolean findOrderByIsDisplayed (){
       LOG.info("Order By Is Displayed");
        return isDisplayed(findOrderBy);

    }

    public void filterOrderBy (String option){
        selectFromDropdown(filterOrderBy,option);
    }

    public boolean titleEmailIsDisplayed (){
       LOG.info("email label is displayed");
        return isDisplayed(titleEmail);
    }

    public void typeEmail (String email) {
        type(emailField,email);
    }
    public boolean zipCodeLabelIsDisplayed (){
        LOG.info("zip code label is displayed");
        return isDisplayed(zipCodeLabel);

    }
    public void typeZipCode (String zipCode) {
        type(zipField,zipCode);
    }

    public void clickOnContinue(){
        clickOn(continueBtn);
    }

    public boolean orderViewTitleIsDisplayed (){
        LOG.info("order view is displayed");
        return isDisplayed(orderViewPageTitle);
    }

    public boolean orderStatusIsDisplayed (){
        LOG.info("order status on pending  is displayed ");
        return isDisplayed(orderStatus);
    }

    public boolean orderInfoIsDisplayed (){
        LOG.info("order info is displayed");
        return isDisplayed(orderInfo);
    }

    public boolean orderedProductNameIsDisplayed (){
        LOG.info("ordered product name is displayed");
        return isDisplayed(orderedProductName);
    }

    public String getOrderedProductName (){

       return getWebElementText(orderedProductName);
    }


    public String getMessageError (){

        return getWebElementText(messageErrorIncorrectData);
    }




}
