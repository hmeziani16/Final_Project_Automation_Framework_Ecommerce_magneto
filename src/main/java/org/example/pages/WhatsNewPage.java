package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.base.CommonAPI;

public class WhatsNewPage extends CommonAPI {

    public WhatsNewPage (WebDriver driver ) {
        PageFactory.initElements( driver,this );
    }

    @FindBy (xpath = "//a[@href='https://magento.softwaretestingboard.com/what-is-new.html'] ")
    WebElement whatsNewPage;

    @FindBy (css = "span[class='base']")
    WebElement title1;

    @FindBy (xpath =  "//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/strong[1]/span")
    WebElement title2;

    @FindBy (css = "body > div:nth-child(5) > main:nth-child(4) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > ol:nth-child(1) > li:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4)")
    WebElement cardHover;

    @FindBy (xpath= "//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[2]/div/div/div[3]/div[2]/div")
    WebElement cardHover2;

    @FindBy (xpath= "//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[3]/div/div/div[3]/div[2]/div\n")
    WebElement cardHover3;

    @FindBy (xpath = "//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[4]/div/div/div[3]/div[2]/div\n")
    WebElement cardHover4;

    @FindBy (xpath=("//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[2]/h2"))
    WebElement latestProductTitle;

    public void clickOnWhatsNewPage() {

        clickOn (whatsNewPage);
        System.out.println("landing on what's new page successfully");

    }

    public String title1IsDisplayed() {
        return getWebElementText(title1);

    }

    public String title2IsDisplayed() {
        return getWebElementText(title2);
    }

    public String getLatestProductTitle() {return getWebElementText(latestProductTitle);}

    public void testHoverOnCard (WebDriver driver) {
        hoverOver(driver,cardHover);
    }

    public void testHoverOnCard2 (WebDriver driver) {
        hoverOver(driver,cardHover2);
    }

    public void testHoverOnCard3 (WebDriver driver) {
        hoverOver(driver,cardHover3);
    }

    public void testHoverOnCard4 (WebDriver driver) {
        hoverOver(driver,cardHover4);
    }


}


