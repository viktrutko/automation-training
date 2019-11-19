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

	@FindBy(xpath = "//input[@class='button' and @name='submitBasicSearch']")
	private WebElement buttonSearch;

	@FindBy(xpath = "//input[@id='destiny']")
	private WebElement placeInput;

	@FindBy(xpath= "//label[@class='autoWidth hrs_relative' and @for='destiny']")
	private WebElement headline;

	@FindBy(xpath = "//input[@id='roomSelector']")
	private WebElement travelingPersonsSelect;

	private WebElement messageOfEmptyPlace;

	public HomeHRSPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public HomeHRSPage openPage(){
		driver.navigate().to(PAGE_URL);
		logger.info("Login page opened");
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
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_OF_MESSAGE_OF_EMPTY_PLACE)));
		buttonSearch.click();
		return new MessageOfNonexistantPlacePage(driver);
	}





}
