package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonAPI;
import org.example.pages.AdvancedSearchPage;
import org.example.pages.HomePage;
import org.example.utilty.ExcelReader;
import org.example.utilty.JsonReader;
import org.example.utilty.Utility;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestAdvancedSearchPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestFilterFunction.class);

    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");
    JsonReader jsonReader= new JsonReader();

    @Test
    public void testSearchWithNameProduct ()  {
        AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage (driver);
        HomePage homePage = new HomePage(driver);



        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String actual = getPageTitle();
        String expected1 = excelReader.getDataForGivenHeaderAndKey("key", "home page banner");
        String actual1 = homePage.onLandingPage();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected1, actual1);

        Assert.assertEquals(expected, actual);
        LOG.info("landing page validation success");


        advancedSearchPage.clickAdvancedSearchPage();


        Assert.assertTrue(advancedSearchPage.advancedSearchPageTitleDisplayed());


        LOG.info("landing on advanced search page success");

        Assert.assertTrue(advancedSearchPage.searchSettingsIsDisplayed());

        advancedSearchPage.nameLabelIsDisplayed();

        String productName = (String) jsonReader.getDataFile("ProductName");

        advancedSearchPage.typeNameProduct(productName);

        Assert.assertTrue(advancedSearchPage.skuLabelIsDisplayed());
        //String sku =  excelReader.getDataForGivenHeaderAndKey("key", "Sku");
        advancedSearchPage.typeSkuField("");

        Assert.assertTrue( advancedSearchPage.descriptionLabelIsDisplayed());
        //String description = (String) jsonReader.getDataFile("Description");
        advancedSearchPage.typeDescriptionField("");

        Assert.assertTrue(advancedSearchPage.shortDescriptionLabelIsDisplayed());
        //String shortDescription = (String) jsonReader.getDataFile("Short Description");
        advancedSearchPage.typeShortDescriptionField("");

        Assert.assertTrue( advancedSearchPage.priceLabelIsDisplayed());
        //String price = (String) jsonReader.getDataFile("Price");
        advancedSearchPage.typePrice("");

        advancedSearchPage.clickOnSearch();

        waitFor(2);

        String expectedSearchResult =  (String) jsonReader.getDataFile("expectedSearchResult");
        String actualSearchResult = advancedSearchPage.getSearchResults();
        Assert.assertEquals(expectedSearchResult, actualSearchResult);

        LOG.info("search using product name success");




    }

    @Test
    public void testSearchWithNameAndSku ()  {

        AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage (driver);
        HomePage homePage = new HomePage(driver);


        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String actual = getPageTitle();
        String expected1 = excelReader.getDataForGivenHeaderAndKey("key", "home page banner");
        String actual1 = homePage.onLandingPage();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected1, actual1);

        Assert.assertEquals(expected, actual);
        LOG.info("landing page validation success");


        advancedSearchPage.clickAdvancedSearchPage();

        Assert.assertTrue(advancedSearchPage.advancedSearchPageTitleDisplayed());

        advancedSearchPage.searchSettingsIsDisplayed();

        Assert.assertTrue(advancedSearchPage.nameLabelIsDisplayed());
        String productName = (String) jsonReader.getDataFile("ProductName");
        advancedSearchPage.typeNameProduct(productName);



        Assert.assertTrue(advancedSearchPage.skuLabelIsDisplayed());
        String sku =  (String) jsonReader.getDataFile("Sku");
        advancedSearchPage.typeSkuField(sku);

        Assert.assertTrue(advancedSearchPage.descriptionLabelIsDisplayed());

        advancedSearchPage.typeDescriptionField("");

        Assert.assertTrue(advancedSearchPage.shortDescriptionLabelIsDisplayed());

        advancedSearchPage.typeShortDescriptionField("");

        Assert.assertTrue(advancedSearchPage.priceLabelIsDisplayed());

        advancedSearchPage.typePrice("");

        advancedSearchPage.clickOnSearch();

        waitFor(2);

        String expectedSearchResult =  (String) jsonReader.getDataFile("expectedSearchResult");
        String actualSearchResult = advancedSearchPage.getSearchResults();
        Assert.assertEquals(expectedSearchResult, actualSearchResult);

        LOG.info("search title : item found");

        String expectedSearchResult3 =  (String) jsonReader.getDataFile("expectedSearchResult3");
        String actualSearchResult3 = advancedSearchPage.getSearchResults2();
        Assert.assertEquals(expectedSearchResult3, actualSearchResult3);

        LOG.info("search using product name success");

        String expectedSearchResult2 = (String) jsonReader.getDataFile("expectedSearchResult2");
        String actualSearchResult2 = advancedSearchPage.getSearchResults3();
        Assert.assertEquals(expectedSearchResult2, actualSearchResult2);

        LOG.info("search using SKU success");

    }
}
