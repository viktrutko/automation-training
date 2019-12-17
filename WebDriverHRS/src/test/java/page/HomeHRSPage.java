package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class HomeHRSPage extends AbstractPage
{
    private final String PAGE_URL = "https://www.hrs.com/";

    final static String XPATH_OF_MESSAGE_OF_EMPTY_PLACE = "//label[@class='autoWidth hrs_relative']/span[@class='error']";
    final static String XPATH_OF_MESSAGE_OF_DIFFERENT_NUMBER_OF_ROOMS_AND_PERSONS = "//label[@for='adults']/span[@class='error']";

    @FindBy(xpath = "//input[@class='button' and @name='submitBasicSearch']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//input[@id='destiny']")
    private WebElement placeInput;

    @FindBy(xpath= "//label[@class='autoWidth hrs_relative' and @for='destiny']")
    private WebElement headline;

    @FindBy(xpath = "//select[@id='roomSelector']")
    private WebElement travelingPersonsSelect;

    @FindBy(xpath = "//input[@id='singleRooms']")
    private WebElement numberOfSingleRoomSelect;

    @FindBy(xpath = "//input[@id='adults']")
    private WebElement numberOfAdults;

    private WebElement messageOfEmptyPlace;
    private WebElement messageOfDifferentNumberOfRoomsAndPersons;


    public HomeHRSPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public HomeHRSPage openPage(){
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public HomeHRSPage searchHotelWithEmptyPlace(SearchQuery searchQuery){
        buttonSearch.click();
        return this;
    }

    public String messageOfEmptyPlaceError(){
        messageOfEmptyPlace = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_MESSAGE_OF_EMPTY_PLACE)));
        return messageOfEmptyPlace.getText();
    }

    public MessageOfNonexistantPlacePage searchHotelWithTermsAndDefaultDate(SearchQuery searchQuery){
        placeInput.sendKeys(searchQuery.getPlace());
        headline.click();
        buttonSearch.click();
        return new MessageOfNonexistantPlacePage(driver);
    }
    public HomeHRSPage searchOfDifferentNumberOfRoomsAndPersons(SearchQuery searchQuery){
        placeInput.sendKeys(searchQuery.getPlace());
        headline.click();
        travelingPersonsSelect.sendKeys(searchQuery.getTravelingPersons());
        headline.click();
        numberOfSingleRoomSelect.sendKeys(String.valueOf(numberOfSingleRoomSelect));
        headline.click();
        buttonSearch.click();
        return new HomeHRSPage(driver);

    }

    public String messageOfDifferentNumberOfRoomsAndPersonsError() {
        messageOfDifferentNumberOfRoomsAndPersons = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_MESSAGE_OF_DIFFERENT_NUMBER_OF_ROOMS_AND_PERSONS)));
        return messageOfDifferentNumberOfRoomsAndPersons.getText();

    }





}
