package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonAPI;
import org.example.pages.CartPage;
import org.example.pages.FilterFunctionPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.utilty.ExcelReader;
import org.example.utilty.JsonReader;
import org.example.utilty.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestCart extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestCart.class.getName());

    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));

    ExcelReader excelReader = new ExcelReader(Utility.currentDir + File.separator + "data" + File.separator + "test-data.xlsx", "data");

    JsonReader jsonReader = new JsonReader();

    @Test
    public void testCartLogo() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        LoginPage loginPage = new LoginPage(driver);


        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String actual = getPageTitle();
        String expected1 = excelReader.getDataForGivenHeaderAndKey("key", "home page banner");
        String actual1 = homePage.onLandingPage();
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected1, actual1);
        LOG.info("landing page validation success");

        // cart is displayed

        Assert.assertTrue(cartPage.cartIsDisplayed());
        LOG.info("cart is displayed");

    }

    @Test
    public void testEmptyCart() {

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        LoginPage loginPage = new LoginPage(driver);

        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String actual = getPageTitle();
        String expected1 = excelReader.getDataForGivenHeaderAndKey("key", "home page banner");
        String actual1 = homePage.onLandingPage();
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected1, actual1);
        LOG.info("landing page validation success");

        // cart is displayed

        Assert.assertTrue(cartPage.cartIsDisplayed());
        LOG.info("cart is displayed");


        // click on emptyCart

        cartPage.clickOnEmptyCart();
        String messageEmptyCart = (String) jsonReader.getDataFile("empty cart");
        String displayed = cartPage.EmptyCartMessagePopup();
        Assert.assertEquals(messageEmptyCart, displayed);
        LOG.info("Empty cart message popup successfully");


    }

    @Test
    public void testAddToCart() {

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        LoginPage loginPage = new LoginPage(driver);

        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String actual = getPageTitle();
        String expected1 = excelReader.getDataForGivenHeaderAndKey("key", "home page banner");
        String actual1 = homePage.onLandingPage();
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected1, actual1);
        LOG.info("landing page validation success");

        // go to men's category.

        cartPage.clickOnMenCategory();

        //select item to add

        cartPage.selectItem();
        waitFor(2);
        //select size

        cartPage.selectSize();


        //select color

        cartPage.selectColor();

        //click on add to cart

        cartPage.clickOnAddToCart();

        waitFor(3);

        // add to cart confirmation message

        String addItemOk = (String) jsonReader.getDataFile("item add to cart");
        String messageDisp = cartPage.getConfirmationMessage();

        Assert.assertEquals(addItemOk, messageDisp);
        LOG.info("Message popup success");

    }

    @Test
    public void testCartNotification() {

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        LoginPage loginPage = new LoginPage(driver);

        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String actual = getPageTitle();
        String expected1 = excelReader.getDataForGivenHeaderAndKey("key", "home page banner");
        String actual1 = homePage.onLandingPage();
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected1, actual1);
        LOG.info("landing page validation success");

        // go to men's category.

        cartPage.clickOnMenCategory();

        //select item to add

        cartPage.selectItem();

        //select size
        waitFor(1);

        cartPage.selectSize();
        //select color

        cartPage.selectColor();

        //click on add to cart

        cartPage.clickOnAddToCart();

        waitFor(10);

        // add to cart confirmation message

        String addItemOk = (String) jsonReader.getDataFile("item add to cart");
        String messageDisp = cartPage.getConfirmationMessage();

        Assert.assertEquals(addItemOk, messageDisp);
        LOG.info("Message popup success");

        // item on count popup

        String itemOnCartCount = "1";
        String countPopUp = cartPage.itemCountDisplayed();

        Assert.assertEquals(itemOnCartCount, countPopUp);
        LOG.info("item count popup on cart icon successfully");

    }

    @Test
    public void testPurchaseItem() {

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        LoginPage loginPage = new LoginPage(driver);

        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String actual = getPageTitle();
        String expected1 = excelReader.getDataForGivenHeaderAndKey("key", "home page banner");
        String actual1 = homePage.onLandingPage();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected1, actual1);
        LOG.info("landing page validation success");

        // go to men's category.

        cartPage.clickOnMenCategory();

        //select item to add

        cartPage.selectItem();
        waitFor(2);
        //select size

        cartPage.selectSize();


        //select color

        cartPage.selectColor();

        //click on add to cart

        cartPage.clickOnAddToCart();

        waitFor(3);

        // add to cart confirmation message

        String addItemOk = (String) jsonReader.getDataFile("item add to cart");
        String messageDisp = cartPage.getConfirmationMessage();

        Assert.assertEquals(addItemOk, messageDisp);
        LOG.info("Message popup success");

        // click on cart icon
        cartPage.clickOnEmptyCart();

        // click on proceed to checkout

        cartPage.clickOnCheckOut();

        //land on shipping



        String urlCheckout = (String) jsonReader.getDataFile("check out url");
        String getUrl = cartPage.getShippingPageUrl(driver);
        LOG.info("current url: " +getUrl );
        waitFor(2);
        Assert.assertEquals(urlCheckout, getUrl);

        LOG.info("url validation success");

        waitFor(3);

        // type shipping details

        //login with username and password

        cartPage.typeShippingDetailsEmail(username);
        waitFor(5);

        cartPage.typeShippingDetailsPass(password);
        waitFor(5);
        cartPage.clickOnLoginBtn();
        waitFor(10);

        LOG.info("login with username and password success");

        //filling shipping details on form for new account

        //cartPage.typeShippingDetailsFirstName("lklk");
        //cartPage.typeShippingDetailsLastName("oklk");
        //cartPage.typeShippingDetailsAddress("ljlkl");
        //cartPage.typeShippingDetailsCity("kjiojpokpo");
        //cartPage.selectStateDropdown();
        //cartPage.typeShippingDetailsZipcode("060000");
        //cartPage.selectCountryDropdown();
        //cartPage.typeShippingDetailsPhoneNumber("06666666");

        //continue to final steps

        cartPage.clickOnRadioBtn();
        cartPage.clickOnNextBtn();

        LOG.info("form filled success ");

        waitFor(10);

        cartPage.clickOnOrderBtn();

        LOG.info("item order ok");

    }

    @Test
    public void testCompareTwoProducts() {

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        FilterFunctionPage filterFunctionPage = new FilterFunctionPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String actual = getPageTitle();
        String expected1 = excelReader.getDataForGivenHeaderAndKey("key", "home page banner");
        String actual1 = homePage.onLandingPage();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected1, actual1);
        LOG.info("landing page validation success");

        filterFunctionPage.mainPageIsDisplayed();
        cartPage.clickOnMenCategory();
        filterFunctionPage.menPageTitleIsDisplayed();

        LOG.info("landing in men's category");
        waitFor(5);
        filterFunctionPage.clickOnShortForMen();
        filterFunctionPage.shortForMenPageTitleIsDisplayed();
        LOG.info("landing in men's short page");

        //  waitFor(5);

        cartPage.testHoverOnShort1Card(driver);
        waitFor(1);
        cartPage.clickOnCompareBtn1();
        String expectedMessage1 = (String) jsonReader.getDataFile("product1");
        waitFor(5);
        String actualMessage1 = cartPage.getMessageAddToCompareList1();
        waitFor(5);
        Assert.assertEquals(expectedMessage1, actualMessage1);

        // waitFor(2);
        cartPage.testHoverOnShort2Card(driver);
        //  waitFor(2);
        cartPage.clickOnCompareBtn2();
        String expectedMessage2 = (String) jsonReader.getDataFile("product2");
        waitFor(5);
        String actualMessage2 = cartPage.getMessageAddToCompareList2();
        waitFor(5);
        Assert.assertEquals(expectedMessage2, actualMessage2);


        cartPage.clickOnCompareBtn();
        Assert.assertTrue(cartPage.titlePageIsDisplayed());

        String expectedCompareProductName1 = (String) jsonReader.getDataFile("short2");
        String actualCompareProductName1 = cartPage.getCompareProductName1();
        Assert.assertEquals(expectedCompareProductName1, actualCompareProductName1);

        LOG.info("short1 name as expected");

        String expectedCompareProductName2 = (String) jsonReader.getDataFile("short1");
        String actualCompareProductName2 = cartPage.getCompareProductName2();
        Assert.assertEquals(expectedCompareProductName2, actualCompareProductName2);

        LOG.info("short2 name as expected");

        LOG.info("short1 and short 2 are displayed in the compare page");


    }
}
