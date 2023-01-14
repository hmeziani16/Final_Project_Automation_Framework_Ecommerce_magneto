package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.base.CommonAPI;

public class CartPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(CartPage.class);

    public CartPage (WebDriver driver ) {
        PageFactory.initElements( driver,this );
    }
    @FindBy (css= "body > div.page-wrapper > header > div.header.content > div.minicart-wrapper > a")
    WebElement cartDisplayed ;

    @FindBy (css=  "a[class='action showcart']")
    WebElement emptyCart;

    @FindBy (xpath=  "//a[@href='https://magento.softwaretestingboard.com/men.html']")
    WebElement menCategoryPage;

    @FindBy (css=  "a[title='Argus All-Weather Tank']")
    WebElement addItem;

    @FindBy (css= "#option-label-size-143-item-166")
    WebElement addSize;

    @FindBy (xpath=  "//*[@id=\"option-label-color-93-item-52\"]")
    WebElement addColor;

    @FindBy (xpath=  "//*[@id=\"product-addtocart-button\"]/span")
    WebElement addToCartBtn;

    @FindBy (css=  "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement confirmationMessage;

    @FindBy (css=  "a[class='action showcart']")
    WebElement emptyCartBtnClick;

    @FindBy (css = "#top-cart-btn-checkout")
    WebElement itemInCart;

    @FindBy (xpath=  "//strong[@class='subtitle empty']")
    WebElement emptyCartMessage;

    @FindBy (css= "span[class='counter-number']")
    WebElement itemCount;

    @FindBy (css= "#top-cart-btn-checkout")
    WebElement checkOutBtn;

    @FindBy (xpath= "//input[@id='customer-email']")
    WebElement customerEmail;

    @FindBy (css= "#customer-password")
    WebElement customerPassword;

    @FindBy (xpath= "//input[@id='VKGBNY9']")
    WebElement customerFirstName;

    @FindBy (xpath= "//input[@id='G7F9MPV']")
    WebElement customerLastName;

    @FindBy (xpath="//input[@name='street[0]']")
    WebElement customerAddress;

    @FindBy (xpath="//input[@name='city']")
    WebElement customerCity;

    @FindBy (xpath="//select[@name='region_id']")
    WebElement customerState;

    @FindBy (xpath="//select[@name='country_id']")
    WebElement customerCountry;

    @FindBy (xpath="//*[@name='postcode']")
    WebElement customerZipCode;

    @FindBy (xpath="//*[@name='telephone']")
    WebElement customerPhoneNumber;

    @FindBy (css="input[value='flatrate_flatrate']")
    WebElement shippingMethod;

    @FindBy (xpath="//button[@class='button action continue primary']")
    WebElement nextBtn;

    @FindBy (xpath="//*[@id='checkout-payment-method-load']/div/div/div[2]/div[2]/div[4]/div/button")
    WebElement orderBtn;

    @FindBy (xpath="//button[@class='action login primary']")
    WebElement loginBtn;

    @FindBy (xpath="//input[@name='ko_unique_1']")
    WebElement radioBtn;



    public boolean cartIsDisplayed () {
        LOG.info("cart is displayed");

        return isDisplayed(cartDisplayed);
    }

    public void clickOnEmptyCart (){
     LOG.info("click On Empty Cart");
        clickOn(emptyCartBtnClick);
    }

    public String EmptyCartMessagePopup () {
        LOG.info("empty cart message popup success");
        return getWebElementText(emptyCartMessage);
    }

    public void clickOnMenCategory () {
        LOG.info("click On men category ");

        clickOn(menCategoryPage);

    }

    public void selectItem () {

        clickOn(addItem);
        LOG.info("Item Selected successfully");

    }

    public void selectSize ()   {

        clickOn(addSize);
        LOG.info("choose size to validate cart");

    }

    public void selectColor () {

        clickOn(addColor);
        LOG.info("choose color to validate cart");


    }

    public void clickOnAddToCart () {

        clickOn(addToCartBtn);
        LOG.info("item added to cart");

    }

    public String getConfirmationMessage () {
        return getWebElementText(confirmationMessage);
    }

    public String itemCountDisplayed () {
        LOG.info("cart is displayed");
        return getWebElementText(itemCount);
    }

    public void clickOnCart () {
        clickOn(itemInCart);
    }

    public void clickOnCheckOut () {
        LOG.info("click on checkout");
        clickOn(checkOutBtn);
    }

    public String getShippingPageUrl (WebDriver driver)  {
        return  getPageUrl(driver);
    }

    public void typeShippingDetailsEmail (String email)  {

        type(customerEmail, email);

    }
    public void typeShippingDetailsPass (String pass)  {

        type(customerPassword, pass);

    }
    public void typeShippingDetailsFirstName (String firstname)  {

        type(customerFirstName, firstname);

    }
    public void typeShippingDetailsLastName (String lastname)  {

        type(customerLastName, lastname);

    }
    public void typeShippingDetailsAddress (String address)  {

        type(customerAddress, address);

    }
    public void typeShippingDetailsCity (String city)  {

        type(customerCity, city);

    }
    public void typeShippingDetailsZipcode (String zip)  {

        type(customerZipCode, zip);

    }
    public void typeShippingDetailsPhoneNumber (String phone) {

        type(customerPhoneNumber, phone);

    }

    public void selectStateDropdown () {

        selectFromDropdown(customerState, "Alaska");

    }

    public void selectCountryDropdown () {

        selectFromDropdown(customerCountry, "United States");
    }

    public void clickOnShippingMethod () {
        clickOn(shippingMethod);
    }

    public void clickOnNextBtn () {
        clickOn(nextBtn);
    }

    public void clickOnOrderBtn () {
        clickOn(orderBtn);
    }


    public void typeShippingDetails() {
        typeShippingDetailsEmail("onethug@mail.com");
        typeShippingDetailsPass("Userdemo90");
        typeShippingDetailsFirstName("lklk");
        typeShippingDetailsLastName("oklk");
        typeShippingDetailsAddress("ljlkl");
        selectStateDropdown();
        typeShippingDetailsCity("bb");
        selectCountryDropdown();
        typeShippingDetailsZipcode("060000");
        typeShippingDetailsPhoneNumber("06666666");
        clickOnShippingMethod();

    }

    public void clickOnLoginBtn() {
        clickOn(loginBtn);

    }

    public void clickOnRadioBtn() {
        clickOn(radioBtn);
    }







}
