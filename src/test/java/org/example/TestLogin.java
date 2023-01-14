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

public class TestLogin extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestLogin.class.getName());

    String username = Utility.decode(prop.getProperty("username"));
    String password = Utility.decode(prop.getProperty("password"));

    ExcelReader excelReader = new ExcelReader(Utility.currentDir+ File.separator+"data"+File.separator+"test-data.xlsx", "data");

    @Test
    public void loginWithValidCredentials() {

        LoginPage loginPage = new LoginPage(driver);

        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        //click on login page
        loginPage.clickOnLoginPage();

        //login page title
        loginPage.loginPageTitleIsDisabled();
        LOG.info("login page title is displayed");

        //enter username
        loginPage.typeUsername(username);

        //enter password
        loginPage.typePassword(password);


        //click on login button
        loginPage.clickOnLoginButton();

        LOG.info("login success");

        //logged in
        boolean logged = loginPage.loggedIn();
        Assert.assertTrue(logged);

    }
    @Test
    public void loginAttemptWithoutUsername() {

        LoginPage loginPage = new LoginPage(driver);

        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        //click on login page
        loginPage.clickOnLoginPage();

        //login page title
        loginPage.loginPageTitleIsDisabled();

        LOG.info("login page title is displayed");

        //enter username
        loginPage.typeUsername("");

        //enter password
        loginPage.typePassword(password);

        //click on login button
        loginPage.clickOnLoginButton();

        LOG.info("login success");

        // error message displayed
        String textError = loginPage.getUserErrorMessage();
        Assert.assertEquals("This is a required field.", textError);
        LOG.info("error message validation success");
    }
    @Test
    public void loginAttemptWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver);

        //check user land on the right page
        String expected = excelReader.getDataForGivenHeaderAndKey("key", "home page header");
        String actual = getPageTitle();

        Assert.assertEquals(expected, actual);
        LOG.info("page title validation success");

        //click on login page
        loginPage.clickOnLoginPage();
        //login page title
        loginPage.loginPageTitleIsDisabled();
        LOG.info("login page title is displayed");
        //enter username
        loginPage.typeUsername(username);

        //enter password
        loginPage.typePassword("");

        //click on login button
        loginPage.clickOnLoginButton();

        LOG.info("login success");

        // error message displayed
        String textError = loginPage.getPasswordErrorMessage();
        Assert.assertEquals("This is a required field.", textError);
        LOG.info("error message validation success");



    }
}
