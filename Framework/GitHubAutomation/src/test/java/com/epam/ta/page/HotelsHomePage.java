package com.epam.ta.page;

import com.epam.ta.model.Hotel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsHomePage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();
    private static final String HOMEPAGE_URL = "https://ru.hotels.com/";

    private final static String XPATH_FOR_SEARCH_BUTTON = "//button[@class='cta cta-strong']";
    private final static String XPATH_FOR_PLACE_INPUT = "//input[@id='qf-0q-destination']";
    private final static String XPATH_FOR_ROOMS_SELECT = "//select[@id='qf-0q-rooms']";
    private final static String XPATH_FOR_DEPARTURE_DATE_INPUT= "//input[@id='qf-0q-localised-check-out']";
    private final static String XPATH_FOR_ARRIVAL_DATE_INPUT = "//input[@id='qf-0q-localised-check-in']";
    private final static String XPATH_FOR_LONG_STAY_LINK = "//div[@class='form-error']/span/a";
    private final static String XPATH_FOR_HEADLINE = "//h1[@class='cont-hd-alt widget-query-heading']";
    private final static String XPATH_FOR_MESSAGE_ABOUT_NONEXISTENT_PLACE = "//h2[@id='widget-overlay-title-1']";
    private final static String XPATH_FOR_MESSAGE_ABOUT_ERRORS_WITH_DATES = "//div[@class='form-error']/span";

    @FindBy(xpath = XPATH_FOR_PLACE_INPUT)
    private WebElement placeInput;

    @FindBy(xpath = XPATH_FOR_ARRIVAL_DATE_INPUT)
    private WebElement arrivalDateInput;

    @FindBy(xpath = XPATH_FOR_DEPARTURE_DATE_INPUT)
    private WebElement departureDateInput;

    @FindBy(xpath = XPATH_FOR_ROOMS_SELECT)
    private WebElement roomsSelect;

    @FindBy(xpath = XPATH_FOR_SEARCH_BUTTON)
    private WebElement searchButton;

    @FindBy(xpath = XPATH_FOR_LONG_STAY_LINK)
    private WebElement longStayLink;

    @FindBy(xpath = XPATH_FOR_HEADLINE)
    private WebElement headline;

    public HotelsHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HotelsHomePage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        logger.info("Home Page opened");
        return this;
    }

    public HotelsHomePage inputPlace(String place){
        placeInput.sendKeys(place);
        headline.click();
        return this;
    }

    public HotelsHomePage inputArrivalDate(String arrivalDate){
        waitForElementLocatedBy(XPATH_FOR_ARRIVAL_DATE_INPUT);
        arrivalDateInput.clear();
        arrivalDateInput.sendKeys(arrivalDate);
        headline.click();
        return this;
    }

    public HotelsHomePage inputDepartureDate(String departureDate){
        waitForElementLocatedBy(XPATH_FOR_DEPARTURE_DATE_INPUT);
        departureDateInput.clear();
        departureDateInput.sendKeys(departureDate);
        headline.click();
        return this;
    }

    public HotelsHomePage selectRoomNumber(int roomNumber){
        waitForElementToBeClickable(XPATH_FOR_ROOMS_SELECT);
        roomsSelect.sendKeys(String.valueOf(roomNumber));
        headline.click();
        return this;
    }

    public HotelsHomePage clickSearchButton(){
        waitForElementToBeClickable(XPATH_FOR_SEARCH_BUTTON);
        searchButton.click();
        return this;
    }

    public HotelsHomePage defineMainTermsForSearchHotel(Hotel hotelTerms){
        return inputPlace(hotelTerms.getPlace())
                .inputArrivalDate(hotelTerms.getArrivalDate())
                .inputDepartureDate(hotelTerms.getDepartureDate())
                .selectRoomNumber(hotelTerms.getRoomsNumber())
                .clickSearchButton();
    }

    public SearchHotelResultPage searchHotelForMainTerms(Hotel hotelTerms){
        defineMainTermsForSearchHotel(hotelTerms);
        logger.info("Search hotel result page opened");
        return new SearchHotelResultPage(driver, hotelTerms);
    }

    public FormToSearchHotelsForLongStayOrForGroupPage searchHotelForGroup(Hotel hotelTerms){
        defineMainTermsForSearchHotel(hotelTerms);
        logger.info("Page with form to search hotels for group opened");
        return new FormToSearchHotelsForLongStayOrForGroupPage(driver);
    }

    public FormToSearchHotelsForLongStayOrForGroupPage obtainFormToSearchHotelForLongStay(){
        longStayLink = waitForElementLocatedBy(XPATH_FOR_LONG_STAY_LINK);
        longStayLink.click();
        logger.info("Page with form to search hotels for long stay opened");
        return new FormToSearchHotelsForLongStayOrForGroupPage(driver);
    }


    public String getTextOfMessageAboutNonexistentPlace(){
        return waitForElementLocatedBy(XPATH_FOR_MESSAGE_ABOUT_NONEXISTENT_PLACE)
                .getText();
    }

    public String getTextOfMessageAboutErrorsWithDate(){
        return waitForElementLocatedBy(XPATH_FOR_MESSAGE_ABOUT_ERRORS_WITH_DATES)
                .getText();
    }
}
