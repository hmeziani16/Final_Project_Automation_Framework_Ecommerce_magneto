package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonAPI;
import org.example.pages.LoginPage;
import org.example.utilty.ExcelReader;
import org.example.utilty.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class TestInitialPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(TestInitialPage.class.getName());
    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");


    @Test
    public void validateLandingPage(){
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");
    }

    @Test
    public void validateLoginPageElements(){
        LoginPage loginPage = new LoginPage(driver);

        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        //click on login page
       loginPage.clickOnLoginPage();

        //username
        boolean userNameFiledDisplayed = loginPage.usernameFieldIsDisplayed();
        Assert.assertTrue(userNameFiledDisplayed);
        LOG.info("username field is displayed");

        //password
        boolean passwordFiledDisplayed = loginPage.passwordFieldIsDisplayed();
        Assert.assertTrue(passwordFiledDisplayed);
        LOG.info("password field is displayed");

        //login button
        boolean loginButtonIsDisplayed = loginPage.loginBtnIsDisplayed();
        Assert.assertTrue(loginButtonIsDisplayed);
        LOG.info("login button is displayed");
    }


}
