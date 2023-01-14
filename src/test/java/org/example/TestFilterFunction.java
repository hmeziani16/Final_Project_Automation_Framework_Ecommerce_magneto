package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonAPI;
import org.example.pages.CartPage;
import org.example.pages.FilterFunctionPage;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.utilty.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestFilterFunction extends CommonAPI {
    FilterFunctionPage filterFunctionPage = new FilterFunctionPage(driver);

    Logger LOG = LogManager.getLogger(TestFilterFunction.class);


    @Test
    public void testFilterByPriceAsc() {

        CartPage cartPage = new CartPage(driver);
        FilterFunctionPage filterFunctionPage = new FilterFunctionPage(driver);

        filterFunctionPage.mainPageIsDisplayed();
        cartPage.clickOnMenCategory();
        filterFunctionPage.menPageTitleIsDisplayed();

        LOG.info("landing in men's category");
        waitFor(5);
        filterFunctionPage.clickOnShortForMen();
        filterFunctionPage.shortForMenPageTitleIsDisplayed();
        LOG.info("landing in men's short page");
        filterFunctionPage.filterMensPageDropDown();

        double[] finalPrices = Utility.listToArrayOfDoubles(filterFunctionPage.getItemsPrice());
        Assert.assertTrue(Utility.isSorted(finalPrices));
        LOG.info("items sorted low to high success");

    }

    @Test
    public void testFilterByPriceDsc() {

        CartPage cartPage = new CartPage(driver);
        FilterFunctionPage filterFunctionPage = new FilterFunctionPage(driver);

        // on main page

        filterFunctionPage.mainPageIsDisplayed();
        cartPage.clickOnMenCategory();
        // on men's page

        filterFunctionPage.menPageTitleIsDisplayed();
        LOG.info("landing in men's category");
        waitFor(5);
        // set filter
        filterFunctionPage.clickOnShortForMen();
        filterFunctionPage.shortForMenPageTitleIsDisplayed();
        LOG.info("landing in men's short page");
        filterFunctionPage.filterMensPageDropDown();
        // set to descending
        filterFunctionPage.setFilterToDsc();


        double[] finalPrices = Utility.listToArrayOfDoubles(filterFunctionPage.getItemsPrice());
        Assert.assertTrue(Utility.isSorted(finalPrices));
        LOG.info("items sorted high to low success");
    }


    @Test
    public void testFilterByNameAtoZ() {

        CartPage cartPage = new CartPage(driver);
        FilterFunctionPage filterFunctionPage = new FilterFunctionPage(driver);

        // on main page

        filterFunctionPage.mainPageIsDisplayed();
        cartPage.clickOnMenCategory();
        // on men's page

        filterFunctionPage.menPageTitleIsDisplayed();
        LOG.info("landing in men's category");
        waitFor(5);
        // set filter
        filterFunctionPage.clickOnShortForMen();
        filterFunctionPage.shortForMenPageTitleIsDisplayed();
        LOG.info("landing in men's short page");

        filterFunctionPage.filterMensPageDropDownAtoZ();
        // capture Product-name In a List

        List<String> listProductNames = filterFunctionPage.getItemsName();

        System.out.println(listProductNames);

        Assert.assertTrue(Utility.listSortAtoZ(listProductNames));

        LOG.info("items sorted A to Z success");


    }

    @Test
    public void testFilterByNameZtoA() {

        CartPage cartPage = new CartPage(driver);
        FilterFunctionPage filterFunctionPage = new FilterFunctionPage(driver);

        // on main page

        filterFunctionPage.mainPageIsDisplayed();
        cartPage.clickOnMenCategory();
        // on men's page

        filterFunctionPage.menPageTitleIsDisplayed();
        LOG.info("landing in men's category");
        waitFor(5);
        // set filter
        filterFunctionPage.clickOnShortForMen();
        filterFunctionPage.shortForMenPageTitleIsDisplayed();
        LOG.info("landing in men's short page");

        filterFunctionPage.filterMensPageDropDownAtoZ();

        // set to descending

        filterFunctionPage.setFilterToDsc();

        // capture Product-name In a List

        List<String> listProductNames = filterFunctionPage.getItemsName();

        System.out.println(listProductNames);

        Assert.assertTrue(Utility.sortedAlphaZtoA(listProductNames));


        LOG.info("items sorted Z to A success");

    }


}

