package com.epam.ta.page;

import com.epam.ta.model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookingPage extends AbstractPage {

    private final static String XPATH_FOR_TOTAL_ARRIVAL_DATE_NOTE = "//td[@class='col-value va-t ta-r pv-tiny travel-dates-check-in fw-bold']";
    private final static String XPATH_FOR_TOTAL_DEPARTURE_DATE_NOTE = "//td[@class='col-value va-t ta-r pv-tiny travel-dates-check-out fw-bold']";
    private final static String XPATH_FOR_NAME_INPUT = "//input[@id='room-details-room-0-first-name']";
    private final static String XPATH_FOR_SURNAME_INPUT = "//input[@id='room-details-room-0-last-name']";
    private final static String XPATH_FOR_EMAIL_INPUT = "//input[@id='contact-details-email']";
    private final static String XPATH_FOR_PHONE_INPUT = "//input[@id='contact-details-phone']";
    private final static String XPATH_FOR_PAY_PAL_CHECKBOX = "//input[@id='payment-option-selector-PAYPAL']";
    private final static String XPATH_FOR_CONFIRM_BOOKING_BUTTON = "//button[@id='book-button']";
    private final static String XPATH_FOR_OTHER_GUEST_INPUT = "//input[@id='room-details-room-0-other-guest-0-full-name']";

    @FindBy(xpath = XPATH_FOR_TOTAL_ARRIVAL_DATE_NOTE)
    private List<WebElement> totalArrivalDateNote;

    @FindBy(xpath = XPATH_FOR_TOTAL_DEPARTURE_DATE_NOTE)
    private List<WebElement> totalDepartureDateNote;

    @FindBy(xpath = XPATH_FOR_NAME_INPUT)
    private WebElement nameInput;

    @FindBy(xpath = XPATH_FOR_SURNAME_INPUT)
    private WebElement surnameInput;

    @FindBy(xpath = XPATH_FOR_EMAIL_INPUT)
    private WebElement emailInput;

    @FindBy(xpath = XPATH_FOR_PHONE_INPUT)
    private WebElement phoneInput;

    @FindBy(xpath = XPATH_FOR_OTHER_GUEST_INPUT)
    private WebElement otherGuestInput;

    @FindBy(xpath = XPATH_FOR_PAY_PAL_CHECKBOX)
    private WebElement payPalCheckbox;

    @FindBy(xpath = XPATH_FOR_CONFIRM_BOOKING_BUTTON)
    private WebElement confirmBookingButton;


    public BookingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public BookingPage openPage(){
        return this;
    }

    public String getInformationAboutBookingHotelTerms(){
        waitForElementToBeClickable(XPATH_FOR_TOTAL_ARRIVAL_DATE_NOTE);
        return totalArrivalDateNote.get(0).getText() + " " + totalDepartureDateNote.get(0).getText();
    }

    public BookingPage inputName(String name){
        waitForElementLocatedBy(XPATH_FOR_NAME_INPUT);
        nameInput.sendKeys(name);
        return this;
    }

    public BookingPage inputSurname(String surname){
        waitForElementLocatedBy(XPATH_FOR_SURNAME_INPUT);
        surnameInput.sendKeys(surname);
        return this;
    }

    public BookingPage inputOtherGuest(String otherGuest){
        waitForElementLocatedBy(XPATH_FOR_OTHER_GUEST_INPUT);
        otherGuestInput.sendKeys(otherGuest);
        return this;
    }

    public BookingPage inputEmail(String email){
        waitForElementLocatedBy(XPATH_FOR_EMAIL_INPUT);
        emailInput.sendKeys(email);
        return this;
    }

    public BookingPage inputPhone(String phone){
        waitForElementLocatedBy(XPATH_FOR_PHONE_INPUT);
        phoneInput.sendKeys(phone);
        return this;
    }

    public BookingPage clickPayPalCheckbox(){
        waitForElementToBeClickable(XPATH_FOR_PAY_PAL_CHECKBOX);
        payPalCheckbox.click();
        return this;
    }

    public BookingPage clickConfirmBookingHotelButton(){
        waitForElementLocatedBy(XPATH_FOR_CONFIRM_BOOKING_BUTTON);
        confirmBookingButton.click();
        return this;
    }

    public PayPalPage confirmBookingHotel(User user){
        inputName(user.getName())
                .inputSurname(user.getSurname())
                .inputOtherGuest(user.getGuest())
                .inputEmail(user.getEmail())
                .inputPhone(user.getPhone())
                .clickPayPalCheckbox()
                .clickConfirmBookingHotelButton();
        return new PayPalPage(driver);
    }
}
