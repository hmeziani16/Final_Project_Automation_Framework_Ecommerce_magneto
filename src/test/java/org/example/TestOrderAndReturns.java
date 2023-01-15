package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonAPI;
import org.example.pages.HomePage;
import org.example.pages.OrderAndReturnsPage;
import org.example.utilty.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestOrderAndReturns extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestFilterFunction.class);
    HomePage homePage = new HomePage(driver);
    JsonReader jsonReader = new JsonReader();

    @Test
    public void testOrderAndReturnsSearchItemFunction () throws InterruptedException {



        OrderAndReturnsPage orderAndReturns = new OrderAndReturnsPage(driver);
        orderAndReturns.clickOrderAndReturnsPage();

        Assert.assertTrue(orderAndReturns.OrderAndReturnsPageTitleDisplayed());
        Assert.assertTrue(orderAndReturns.titleFormIsDisplayed());

        Assert.assertTrue(orderAndReturns.orderTitleIsDisplayed());
        String orderId = (String) jsonReader.getDataFile("order id");
        orderAndReturns.typeOrderId(orderId);

        Assert.assertTrue(orderAndReturns.billingLastnameIsDisplayed());
        String billingLastName = (String) jsonReader.getDataFile("last name");
        orderAndReturns.typeBillingLastName(billingLastName);

        Assert.assertTrue( orderAndReturns.findOrderByIsDisplayed());

        orderAndReturns.filterOrderBy("Email");

        Assert.assertTrue( orderAndReturns.titleEmailIsDisplayed());

        String email = (String) jsonReader.getDataFile("email");
        orderAndReturns.typeEmail(email);



        orderAndReturns.clickOnContinue();

        LOG.info("landing in order view");

        Assert.assertTrue(orderAndReturns.orderViewTitleIsDisplayed());
        Assert.assertTrue( orderAndReturns.orderStatusIsDisplayed());
        Assert.assertTrue( orderAndReturns.orderInfoIsDisplayed());
        Assert.assertTrue( orderAndReturns.orderedProductNameIsDisplayed());

        String itemExpected = (String) jsonReader.getDataFile("ProductName2");
        String itemActual = orderAndReturns.getOrderedProductName();
        Assert.assertEquals(itemExpected, itemActual);
        LOG.info("Product ordered lately found successfully");

    }
    @Test
    public void testOrderAndReturnsSearchItemWithIncorrectData()  {

        OrderAndReturnsPage orderAndReturns = new OrderAndReturnsPage(driver);

        orderAndReturns.clickOrderAndReturnsPage();

        Assert.assertTrue(orderAndReturns.OrderAndReturnsPageTitleDisplayed());
        Assert.assertTrue(orderAndReturns.titleFormIsDisplayed());

        Assert.assertTrue(orderAndReturns.orderTitleIsDisplayed());
        String orderId = (String) jsonReader.getDataFile("order id");
        orderAndReturns.typeOrderId(orderId);

        Assert.assertTrue(orderAndReturns.billingLastnameIsDisplayed());
        String billingLastName = (String) jsonReader.getDataFile("last name");
        orderAndReturns.typeBillingLastName(billingLastName);

        Assert.assertTrue( orderAndReturns.findOrderByIsDisplayed());

        orderAndReturns.filterOrderBy("ZIP Code");

        Assert.assertTrue( orderAndReturns.zipCodeLabelIsDisplayed());

        String zipCode = (String) jsonReader.getDataFile("zip code");
        orderAndReturns.typeZipCode(zipCode);

        orderAndReturns.clickOnContinue();

        String messageErrorActual = (String) jsonReader.getDataFile("incorrect data");
        String messageErrorExpected = orderAndReturns.getMessageError();

        Assert.assertEquals(messageErrorExpected, messageErrorActual);

        LOG.info("can't find item with billing zip code error message popup success'");


    }

    @Test
    public void testOrderAndReturnsSearchItemWithZipCode (){
        OrderAndReturnsPage orderAndReturns = new OrderAndReturnsPage(driver);

        orderAndReturns.clickOrderAndReturnsPage();

        Assert.assertTrue(orderAndReturns.OrderAndReturnsPageTitleDisplayed());
        Assert.assertTrue(orderAndReturns.titleFormIsDisplayed());

        Assert.assertTrue(orderAndReturns.orderTitleIsDisplayed());
        String orderId = (String) jsonReader.getDataFile("order id");
        orderAndReturns.typeOrderId(orderId);

        Assert.assertTrue(orderAndReturns.billingLastnameIsDisplayed());
        String billingLastName = (String) jsonReader.getDataFile("last name");
        orderAndReturns.typeBillingLastName(billingLastName);

        Assert.assertTrue( orderAndReturns.findOrderByIsDisplayed());

        orderAndReturns.filterOrderBy("ZIP Code");

        Assert.assertTrue( orderAndReturns.zipCodeLabelIsDisplayed());

        String zipCode = (String) jsonReader.getDataFile("correct zip code");
        orderAndReturns.typeZipCode(zipCode);

        orderAndReturns.clickOnContinue();

        LOG.info("landing in order view");

        Assert.assertTrue(orderAndReturns.orderViewTitleIsDisplayed());
        Assert.assertTrue( orderAndReturns.orderStatusIsDisplayed());
        Assert.assertTrue( orderAndReturns.orderInfoIsDisplayed());
        Assert.assertTrue( orderAndReturns.orderedProductNameIsDisplayed());

        String itemExpected = (String) jsonReader.getDataFile("ProductName2");
        String itemActual = orderAndReturns.getOrderedProductName();
        Assert.assertEquals(itemExpected, itemActual);
        LOG.info("Product ordered lately found successfully");

    }


}
