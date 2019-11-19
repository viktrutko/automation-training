package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessageOfNonexistantPlacePage extends  AbstractPage{

    final static String XPATH_OF_MESSAGE_OF_NONEXISTANT_PLACE = "//div[@class='teaser errorBox']/h4";

    private WebElement messageOfNonexistantPlace;

    public MessageOfNonexistantPlacePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MessageOfNonexistantPlacePage openPage(){
        return this;
    }

    public String messageOfNonexistantPlaceError(){
        messageOfNonexistantPlace = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_MESSAGE_OF_NONEXISTANT_PLACE)));
        return messageOfNonexistantPlace.getText();
    }
}
