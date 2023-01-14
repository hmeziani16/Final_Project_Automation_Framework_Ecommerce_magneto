package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FilterFunctionPage extends CommonAPI {

    Logger LOG = LogManager.getLogger(FilterFunctionPage.class);

    public FilterFunctionPage(WebDriver driver ) {
        PageFactory.initElements( driver,this );
    }

    @FindBy (css="#maincontent > div.columns > div.sidebar.sidebar-main > div.widget.block.block-static-block > div > ul:nth-child(4) > li:nth-child(2) > a")
    WebElement shortForMen;

    @FindBy (xpath="//h1[@class='page-title']")
    WebElement shortForMenPageTitle;

    @FindBy (xpath="//*[@id='sorter']")
    WebElement filterMensPage;

    @FindBy(xpath = "//li[@class='item product product-item']")
    List<WebElement> productPrice;

    @FindBy (xpath=  "//*[@id='ui-id-5']")
    WebElement menCategoryPage2;

    @FindBy (xpath="//h1[@class='page-title']")
    WebElement menPageTitle;

    @FindBy (xpath="//*[@id='maincontent']/div[1]/h1/span")
    WebElement mainPage;

    @FindBy (xpath="//*[@id='maincontent']/div[3]/div[1]/div[2]/div[3]/a")
    WebElement setDsc;

    @FindBy (xpath="//strong[@class='product name product-item-name']")
    List<WebElement> productName;

    public void clickOnShortForMen () {
        clickOn(shortForMen);
    }

    public boolean shortForMenPageTitleIsDisplayed () {
        LOG.info("short for Men page is displayed");

        return isDisplayed(shortForMenPageTitle);
    }

    public void filterMensPageDropDown ()  {
        selectFromDropdown(filterMensPage,"Price");
    }

    public void filterMensPageDropDownAtoZ ()  {
        selectFromDropdown(filterMensPage,"Product Name");
    }

    public List<String> getItemsPrice() {
        List<String> prices = new ArrayList<String>();
        for (WebElement itemPrice : productPrice) {
            //prices.add(itemPrice.getText().replace("$", ""));
        }

        return prices;

    }
    public List<String> getItemsName() {
        List<String> productNames = new ArrayList<String>();
        for (WebElement product : productName) {
            productNames.add(product.getText().replace("$", ""));
        }

        return productNames;

    }
    public void clickOnMensProductPage (){
        clickOn(menCategoryPage2);
    }
    public boolean menPageTitleIsDisplayed (){
        LOG.info("Men page is displayed");
        return isDisplayed(menPageTitle);
    }

    public boolean mainPageIsDisplayed (){
        LOG.info("Main page is displayed");

        return isDisplayed(mainPage);
    }

    public void setFilterToDsc (){
        clickOn(setDsc);
    }
}
