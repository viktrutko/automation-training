package com.epam.ta.page;

import com.epam.ta.model.SearchQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeHRSPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private final String PAGE_URL = "https://www.hrs.com/";

	final static String XPATH_OF_MESSAGE_OF_EMPTY_PLACE = "//label[@class='autoWidth hrs_relative']/span[@class='error']";
	final static String XPATH_OF_MESSAGE_OF_DIFFERENT_NUMBER_OF_ROOMS_AND_PERSONS = "//label[@for='adults']/span[@class='error']";
    final static String XPATH_OF_MESSAGE_NUMBER_OF_ROOMS = "//label[@for='singleRooms']/span[@class='error']";
    final static String XPATH_OF_MESSAGE_OF_DATE = "//label[@for='stayPeriod']/span[@class='error']";
	final static String XPATH_OF_MESSAGE_CHILDREN_AND_ROOMS = "//label[@for='doubleRooms']/span[@class='error']";
	final static String XPATH_OF_MESSAGE_CHILDREN_AGE = "//label[@for='age']/span[@class='error']";



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

	@FindBy(xpath = "//input[@id='start_stayPeriod']")
    private WebElement arrivalDate;

    @FindBy(xpath = "//input[@id='end_stayPeriod'")
    private WebElement depurtareDate;

	@FindBy(xpath = "//input[@id='doubleRooms']")
	private WebElement numberOfDoubleRoomSelect;

	@FindBy(xpath = "//select[@id='children']")
	private WebElement numberOfChildren;

	private WebElement messageOfEmptyPlace;
	private WebElement messageOfDifferentNumberOfRoomsAndPersons;
	private WebElement messageOfEmptyNumberOfRooms;
    private WebElement messageOfDate;

	public HomeHRSPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public HomeHRSPage openPage(){
		driver.navigate().to(PAGE_URL);
		//logger.info("Login page opened");
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
		travelingPersonsSelect.sendKeys(searchQuery.getTravelingPersons());
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

    public String messageOfEmptyNumberOfRoomsError() {
        messageOfEmptyNumberOfRooms = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_MESSAGE_NUMBER_OF_ROOMS)));
        return messageOfEmptyNumberOfRooms.getText();

    }
    public HomeHRSPage searchNumberOfRoomsAndPersons(SearchQuery searchQuery){
        placeInput.sendKeys(searchQuery.getPlace());
        headline.click();
        travelingPersonsSelect.sendKeys(searchQuery.getTravelingPersons());
        headline.click();
        buttonSearch.click();
        return new HomeHRSPage(driver);

    }
    public HomeHRSPage searchHotelForMainTerms(SearchQuery searchQuery){
	    placeInput.sendKeys(searchQuery.getPlace());
	    headline.click();
	    arrivalDate.sendKeys(searchQuery.getPlace());
        depurtareDate.sendKeys(searchQuery.getPlace());
        headline.click();
        buttonSearch.click();
        return new HomeHRSPage(driver);
    }
    public String changedDepartureDateTerm(){
        messageOfDate = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_MESSAGE_OF_DATE)));
        return messageOfDate.getText();

    }
	public String messageOfMoreChildrenThanRoomsError() {
		messageOfEmptyNumberOfRooms = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_MESSAGE_CHILDREN_AND_ROOMS)));
		return messageOfEmptyNumberOfRooms.getText();

	}
	public HomeHRSPage searchMoreChildrenThanRooms(SearchQuery searchQuery){
		placeInput.sendKeys(searchQuery.getPlace());
		headline.click();
		travelingPersonsSelect.sendKeys(searchQuery.getTravelingPersons());
		headline.click();
		numberOfSingleRoomSelect.sendKeys(searchQuery.getPlace());
		headline.click();
		numberOfDoubleRoomSelect.sendKeys(searchQuery.getPlace());
		headline.click();
		numberOfChildren.sendKeys(searchQuery.getPlace());
		buttonSearch.click();
		return new HomeHRSPage(driver);

	}

	public String messageOfChildrenAgeError() {
		messageOfEmptyNumberOfRooms = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_OF_MESSAGE_CHILDREN_AGE)));
		return messageOfEmptyNumberOfRooms.getText();

	}
	public HomeHRSPage searchChildrenAge(SearchQuery searchQuery){
		placeInput.sendKeys(searchQuery.getPlace());
		headline.click();
		travelingPersonsSelect.sendKeys(searchQuery.getTravelingPersons());
		headline.click();
		numberOfSingleRoomSelect.sendKeys(searchQuery.getPlace());
		headline.click();
		numberOfDoubleRoomSelect.sendKeys(searchQuery.getPlace());
		headline.click();
		numberOfChildren.sendKeys(searchQuery.getPlace());
		buttonSearch.click();
		return new HomeHRSPage(driver);

	}


}
