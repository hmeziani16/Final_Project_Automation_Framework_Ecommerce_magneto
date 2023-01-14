package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonAPI;

import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.utilty.ExcelReader;
import org.example.utilty.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestHomePage extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestHomePage.class.getName());
    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");

    @Test
    public void testHomepage()  {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(driver);

        //check user land on the right page actual
        String actual = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String expected = getPageTitle();
        String  actual1  = excelReader.getDataForGivenHeaderAndKey("key", "home page banner");
        String expected1 = homePage.onLandingPage();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected1, actual1);

        Assert.assertEquals(expected, actual);
        LOG.info("landing page validation success");

    }

    @Test
    public void testHeaders() {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(driver);

        //check user land on the right page actual
        String actual = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String expected = getPageTitle();
        String  actual1  = excelReader.getDataForGivenHeaderAndKey("key", "home page banner");
        String expected1 = homePage.onLandingPage();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected1, actual1);

        Assert.assertEquals(expected, actual);
        LOG.info("landing page validation success");

        //header is Displayed

        boolean headerIsDisplayed = homePage.headerDisplayed();
        Assert.assertTrue(headerIsDisplayed);
        LOG.info("header is displayed");


    }

    @Test
    public void testFooter(){
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(driver);

        //check user land on the right page
        String actual = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String expected = getPageTitle();
        String  actual1  = excelReader.getDataForGivenHeaderAndKey("key", "home page banner");
        String expected1 = homePage.onLandingPage();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected1, actual1);

        Assert.assertEquals(expected, actual);
        LOG.info("landing page validation success");

        // footer is Displayed

        boolean footerDisplayed = homePage.footerIsDisplayed();
        Assert.assertTrue(footerDisplayed);
        LOG.info("footer is displayed");


    }

    @Test
    public void testNavbar ()  {
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(driver);

        //check user land on the right page actual
        String actual = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String expected = getPageTitle();
        String  actual1  = excelReader.getDataForGivenHeaderAndKey("key", "home page banner");
        String expected1 = homePage.onLandingPage();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected1, actual1);

        Assert.assertEquals(expected, actual);
        LOG.info("landing page validation success");
        //navbar is Displayed

        boolean navbarIsDisplayed = homePage.navBarDisplayed();
        Assert.assertTrue(navbarIsDisplayed);
        LOG.info("navbar is displayed");

    }
    @Test
    public void testSearchBar ()  {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(driver);

        //check user land on the right page actual
        String actual = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String expected = getPageTitle();
        String  actual1  = excelReader.getDataForGivenHeaderAndKey("key", "home page banner");
        String expected1 = homePage.onLandingPage();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected1, actual1);

        Assert.assertEquals(expected, actual);
        LOG.info("landing page validation success");
        // SearchBar is Displayed
        boolean searchBarIsDisplayed = homePage.searchBarDisplayed();
        Assert.assertTrue(searchBarIsDisplayed);
        LOG.info("searchBarIsDisplayed");
    }
}


