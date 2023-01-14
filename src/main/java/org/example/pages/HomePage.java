package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.base.CommonAPI;

public class HomePage extends CommonAPI {
      Logger LOG = LogManager.getLogger(HomePage.class);
      public HomePage(WebDriver driver ) {
          PageFactory.initElements( driver,this );
      }
      @FindBy (css = "body > div.message.global.demo")
      WebElement landingPage;

      @FindBy (css = "body > div.page-wrapper > header > div.panel.wrapper > div")
      WebElement header;

      @FindBy (css = "body > div.page-wrapper > footer > div")
      WebElement footer;

      @FindBy (css = "#store\\.menu > nav")
      WebElement navBar;

      @FindBy (css = "#search_mini_form > div.field.search > label")
      WebElement searchBar;

      @FindBy (css = "body > div.page-wrapper > header > div.panel.wrapper > div")
      WebElement headerDisplayed;


      public String onLandingPage (){

          return getWebElementText(landingPage);

      }

      public boolean headerDisplayed (){

            LOG.info("Header displayed");

            return isDisplayed(headerDisplayed);
      }

      public boolean footerIsDisplayed (){
            LOG.info("footer displayed");
            return isDisplayed(footer);
      }

      public boolean navBarDisplayed () {
            LOG.info("navbar displayed");
            return isDisplayed(navBar);

      }

      public boolean searchBarDisplayed () {
            LOG.info("Searchbar displayed");
            return isDisplayed(searchBar);
      }





}
