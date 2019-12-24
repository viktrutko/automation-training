package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HotelPage extends AbstractPage{

    private final static String XPATH_FOR_FREE_BREAKFAST_MARK = "//span[@class='freebie item']";
    private final static String XPATH_FOR_BOOKING_BUTTON = "//form[@id = 'rooms-and-rates.room-1-rateplan-1']/button[@class='cta']";

    private WebElement bookingButton;

    public HotelPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public HotelPage openPage(){
        return this;
    }

    public String getTextOfFreeBreakfastMark(){
        return waitForElementLocatedBy(XPATH_FOR_FREE_BREAKFAST_MARK)
                .getText();
    }

    public BookingPage selectRoomOfHotel(){
        waitForElementLocatedBy(XPATH_FOR_BOOKING_BUTTON);
        bookingButton = waitForElementToBeClickable(XPATH_FOR_BOOKING_BUTTON);
        bookingButton.click();
        return new BookingPage(driver);
    }
}
