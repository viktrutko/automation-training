package com.epam.ta.page;

import com.epam.ta.model.Hotel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchHotelResultPage extends AbstractPage{

    private final String XPATH_FOR_CHOOSE_SEARCH_DEPARTURE_DATE = "//input[@id='q-localised-check-out']";
    private final String XPATH_FOR_FREE_BREAKFAST_CHECKBOX = "//input[@id='f-popular-2048']";
    private final String XPATH_FOR_SELECT_HOTEL_BUTTON = "//a[@class='cta' and @target='_blank']";
    private final String XPATH_FOR_DATA_FILTER_MARK = "//a[@data-filter-id='f-facilities-2048']";
    private final String XPATH_FOR_NOTE_TO_INPUT_DATES = "//a[@class='cta cta-check-dates']";

    private Hotel hotelTerms;

    @FindBy(xpath = XPATH_FOR_SELECT_HOTEL_BUTTON)
    private List<WebElement> selectHotelButtons;

    @FindBy(xpath = XPATH_FOR_NOTE_TO_INPUT_DATES)
    private List<WebElement> notesToInputDates;

    private WebElement freeBreakfastCheckbox;

    public SearchHotelResultPage(WebDriver driver, Hotel hotelTerms){
        super(driver);
        this.hotelTerms = hotelTerms;
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public SearchHotelResultPage openPage(){
        return this;
    }

    public String changedDepartureDateTerm(){
        return waitForElementLocatedBy(XPATH_FOR_CHOOSE_SEARCH_DEPARTURE_DATE)
                .getAttribute("value");
    }

    public String getTextOfNotesToInputDates(){
        waitForElementLocatedBy(XPATH_FOR_NOTE_TO_INPUT_DATES);
        return notesToInputDates.get(1).getText();
    }

    public SearchHotelResultPage selectFreeBreakfastHotelTerm(){
        freeBreakfastCheckbox = waitForElementToBeClickable(XPATH_FOR_FREE_BREAKFAST_CHECKBOX);
        freeBreakfastCheckbox.click();;
        return this;
    }

    public HotelPage selectHotelFromSearchResults(){
        waitForElementLocatedBy(XPATH_FOR_SELECT_HOTEL_BUTTON);
        waitForElementToBeClickable(XPATH_FOR_SELECT_HOTEL_BUTTON);
        selectHotelButtons.get(1).click();
        switchToNewTab();
        return new HotelPage(driver);
    }

    public HotelPage selectHotelWithFreeBreakfastFromSearchResults(){
        waitForElementLocatedBy(XPATH_FOR_DATA_FILTER_MARK);
        return selectHotelFromSearchResults();
    }

    public void switchToNewTab(){
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}
