package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FormToSearchHotelsForLongStayOrForGroupPage extends AbstractPage {

    private final String XPATH_FOR_SUBMIT_BUTTON = "//button[@class='Submit']";

    public FormToSearchHotelsForLongStayOrForGroupPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public FormToSearchHotelsForLongStayOrForGroupPage openPage(){
        return this;
    }

    public String thereIsSubmitButton(){
        return waitForElementLocatedBy(XPATH_FOR_SUBMIT_BUTTON)
            .getText();
    }
}
