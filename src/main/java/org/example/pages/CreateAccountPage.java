package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    public CreateAccountPage (WebDriver driver ) {
        PageFactory.initElements( driver,this );
    }
}
