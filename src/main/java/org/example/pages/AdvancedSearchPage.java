package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearchPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(AdvancedSearchPage.class);

    public AdvancedSearchPage (WebDriver driver ) {
        PageFactory.initElements( driver,this );
    }

    @FindBy(xpath="/html/body/div[2]/footer/div/ul/li[3]/a")
    WebElement linkToAdvancedSearchPage;
    @FindBy (xpath="//span[@class='base']")
    WebElement advancedSearchPageTitle;
    @FindBy (xpath="//*[@id='form-validate']/fieldset/legend/span")
    WebElement searchSettings;

    @FindBy (xpath="//label[@for='name']")
    WebElement nameLabel;

    @FindBy (xpath="//input[@id='name']")
    WebElement nameField;

    @FindBy (xpath="//label[@for='sku']")
    WebElement skuLabel;


    @FindBy (xpath="//input[@id='sku']")
    WebElement skuField;

    @FindBy (xpath="//label[@for='description']")
    WebElement descriptionLabel;

    @FindBy (xpath="//input[@id='description']")
    WebElement descriptionField;

    @FindBy (xpath="//label[@for='short_description']")
    WebElement shortDescriptionLabel;

    @FindBy (xpath="//input[@id='short_description']")
    WebElement shortDescriptionField;

    @FindBy (xpath="//label[@for='price']")
    WebElement priceLabel;

    @FindBy (xpath="//input[@id='price']")
    WebElement priceField;

    @FindBy (xpath="//input[@id='price_to']")
    WebElement priceField2;



    @FindBy (xpath="//button[@class='action search primary']")
    WebElement searchBtn;

    @FindBy (xpath="//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]")
    WebElement searchResults;

    @FindBy (xpath="//*[@id='maincontent']/div[3]/div[1]/div[3]/ul/li/strong")
    WebElement searchResults2;

    @FindBy (xpath="//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ul[2]/li/strong")

    WebElement searchResults3;


    public void clickAdvancedSearchPage (){
        clickOn(linkToAdvancedSearchPage);
    }

    public boolean advancedSearchPageTitleDisplayed (){

        LOG.info("advanced Search Page Title is Displayed");

        return isDisplayed(advancedSearchPageTitle);
    }

    public boolean searchSettingsIsDisplayed (){
        LOG.info("search settings label is displayed");
        return isDisplayed(searchSettings);
    }

    public boolean nameLabelIsDisplayed (){
        LOG.info("name label is displayed");
       return  isDisplayed(nameLabel);
    }

    public void typeNameProduct (String nameProduct) {
        type(nameField,nameProduct);
    }

    public boolean skuLabelIsDisplayed (){
        LOG.info("Sku label is displayed");
       return isDisplayed(skuLabel);
    }

    public void typeSkuField (String sku) {
        type(skuField,sku);
    }

    public boolean descriptionLabelIsDisplayed (){

       LOG.info("Description label is displayed");
        return isDisplayed(descriptionLabel);
    }

    public void typeDescriptionField (String description) {
        type(descriptionField,description);
    }

    public boolean shortDescriptionLabelIsDisplayed (){

        LOG.info("Description label is displayed");

        return isDisplayed(shortDescriptionLabel);
    }

    public void typeShortDescriptionField (String description) {
        type(shortDescriptionField,description);
    }

    public boolean priceLabelIsDisplayed (){

        LOG.info("Price label is displayed");

        return isDisplayed(priceLabel);
    }

    public void typePrice (String price1) {
        type(priceField,price1);

    }
    public void typePrice2 (String price2) {
        type(priceField2,price2);

    }

    public void clickOnSearch(){
        LOG.info("Click on search");
        clickOn(searchBtn);
    }

   /* public void getSearchResults () {
        getWebElementText(searchResults);
    }*/

    public String getSearchResults () {

        return getWebElementText(searchResults);
    }

    public String getSearchResults2 () {

        return getWebElementText(searchResults2);
    }

    public String getSearchResults3 () {

        return getWebElementText(searchResults3);
    }




}
