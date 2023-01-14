package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.base.CommonAPI;

import static org.openqa.selenium.support.How.CSS;

public class LoginPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#email")
    WebElement usernameField;
    @FindBy(xpath = "//*[@title=\"Password\"]")
    WebElement passwordField;
    @FindBy(css = "#send2.action.login.primary")
    WebElement loginBtn;

    @FindBy(css = "body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.greet.welcome")
    WebElement loggedIn;

    @FindBy(css = "body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.authorization-link > a")
    WebElement loginPageClick;

    @FindBy(css = "#email-error")
    WebElement userErrorMessage;

    @FindBy(css = "#pass-error")
    WebElement passwordErrorMessage;

    @FindBy(xpath = "//*[.='Customer Login']")
    WebElement loginPageTitle;

    //reusable steps
    public boolean loggedIn() {
        LOG.info("Logged in success");
        return isDisplayed(loggedIn);

    }

    public boolean usernameFieldIsDisplayed() {
        return isDisplayed(usernameField);
    }

    public void typeUsername(String username) {
        type(usernameField, username);
        System.out.println("enter username success");
    }

    public boolean passwordFieldIsDisplayed() {
        return isDisplayed(passwordField);
    }

    public void typePassword(String password) {
        type(passwordField, password);
        System.out.println("enter password success");
    }

    public boolean loginBtnIsDisplayed() {
        LOG.info("Logged in btn is disabled");
        return isDisplayed(loginBtn);
    }

    public void clickOnLoginPage() {
        clickOn(loginPageClick);
        LOG.info("click on login page");
    }

    public void clickOnLoginButton() {
        clickOn(loginBtn);
        LOG.info("login button click success");
    }

    public String getUserErrorMessage() {

        return getWebElementText(userErrorMessage);
    }

    public String getPasswordErrorMessage() {

        return getWebElementText(passwordErrorMessage);
    }

    public void login(String username, String password) {
        typeUsername(username);
        typePassword(password);
        clickOnLoginButton();
        System.out.println("login process success");
    }

    public boolean loginPageTitleIsDisabled() {
        LOG.info("login page title is disabled");
        return isDisplayed(loginPageTitle);
    }

}

