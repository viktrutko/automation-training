package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PayPalPage extends AbstractPage {

    public final static String XPATH_FOR_HEADLINE_OF_PAY_PAL = "//div[@id='content']/h1";

    public PayPalPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public PayPalPage openPage(){
        return this;
    }

    public String getTextOfHeadlineOfPayPal(){
        return waitForElementLocatedBy(XPATH_FOR_HEADLINE_OF_PAY_PAL)
                .getText();
    }
}
