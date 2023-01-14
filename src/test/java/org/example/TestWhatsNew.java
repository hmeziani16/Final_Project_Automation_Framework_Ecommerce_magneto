package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonAPI;
import org.example.pages.HomePage;
import org.example.pages.WhatsNewPage;
import org.example.utilty.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWhatsNew extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestWhatsNew.class.getName());
    JsonReader jsonReader = new JsonReader();

    @Test
    public void testWhatsNewPage () {

        HomePage homePage = new HomePage(driver);
        WhatsNewPage whatsNewPage = new WhatsNewPage(driver);

        String expected = (String) jsonReader.getDataFile("page head banner");
        String actual = homePage.onLandingPage();

        Assert.assertEquals(expected, actual);
        LOG.info("landing page validation success");

        // go to what's new page

        whatsNewPage.clickOnWhatsNewPage();

    }

    @Test
    public void testWhatsNewTitle (){

        HomePage homePage = new HomePage(driver);
        WhatsNewPage whatsNewPage = new WhatsNewPage(driver);

        String expected = (String) jsonReader.getDataFile("page head banner");
        String actual = homePage.onLandingPage();

        Assert.assertEquals(expected, actual);
        LOG.info("landing page validation success");

        // go to what's new page

        whatsNewPage.clickOnWhatsNewPage();


        String expectedTitle = (String) jsonReader.getDataFile("title whats new");
        String actualTitle = whatsNewPage.title1IsDisplayed();
        Assert.assertEquals(expectedTitle,actualTitle);
        LOG.info("body title displayed");




    }

   @Test
    public void testNewInWomen (){

        HomePage homePage = new HomePage(driver);
        WhatsNewPage whatsNewPage = new WhatsNewPage(driver);


        String expected = (String) jsonReader.getDataFile("page head banner");
        String actual = homePage.onLandingPage();

        Assert.assertEquals(expected, actual);
        LOG.info("landing page validation success");

        // go to what's new page

        whatsNewPage.clickOnWhatsNewPage();


        String expectedTitle2 = (String) jsonReader.getDataFile("new women");
        String actualTitle2 = whatsNewPage.title2IsDisplayed();
        Assert.assertEquals(expectedTitle2,actualTitle2);
        LOG.info(" Women's menu title displayed");


    }
    @Test
    public void testHoverOverCardOnLumasLatest () {

        HomePage homePage = new HomePage(driver);
        WhatsNewPage whatsNewPage = new WhatsNewPage(driver);

        waitFor(3);


        String expected = (String) jsonReader.getDataFile("page head banner");
        String actual = homePage.onLandingPage();

        Assert.assertEquals(expected, actual);
        LOG.info("landing page validation success");

        // go to what's new page

        whatsNewPage.clickOnWhatsNewPage();

        String expectedTitle= whatsNewPage.getLatestProductTitle();
        String actualTitle = (String) jsonReader.getDataFile("latest title");
        Assert.assertEquals(expectedTitle, actualTitle);
        LOG.info("luma's latest is displayed");

        //test hover over item card

        waitFor(1);

        whatsNewPage.testHoverOnCard(driver);
        LOG.info("hover over card 1");
        waitFor(1);
        whatsNewPage.testHoverOnCard2(driver);
        LOG.info("hover over card 2");
        waitFor(1);
        whatsNewPage.testHoverOnCard3(driver);
        LOG.info("hover over card 3");
        waitFor(1);
        whatsNewPage.testHoverOnCard4(driver);
        LOG.info("hover over card 4");
        waitFor(1);
        LOG.info("hover over products cards success");

    }






}
