package com.epam.ta.test;

import com.epam.ta.model.Hotel;
import com.epam.ta.model.User;
import com.epam.ta.page.HotelsHomePage;
import com.epam.ta.service.HotelCreator;
import com.epam.ta.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BookingHotelTest extends CommonConditions {

    @Test
    public void isTermsOfSearchedHotelMatchToTermsOnBookingPage(){
        Hotel testSearchQueryMain = HotelCreator.withCredentialsFromProperty();
        String bookingHotelTerms = new HotelsHomePage(driver)
                .openPage()
                .searchHotelForMainTerms(testSearchQueryMain)
                .selectHotelFromSearchResults()
                .selectRoomOfHotel()
                .getInformationAboutBookingHotelTerms();
        Assert.assertTrue(bookingHotelTerms.contains("20 января 2020 г.") && bookingHotelTerms.contains("21 января 2020 г."));
    }

    @Test
    public void payForBookingHotelWithPayPal(){
        Hotel testSearchQuery = HotelCreator.withCredentialsFromProperty();
        User  testUser = UserCreator.withCredentialsFromProperty();
        String messageOfPayingWithPayPal = new HotelsHomePage(driver)
                .openPage()
                .searchHotelForMainTerms(testSearchQuery)
                .selectHotelFromSearchResults()
                .selectRoomOfHotel()
                .confirmBookingHotel(testUser)
                .getTextOfHeadlineOfPayPal();
        assertThat(messageOfPayingWithPayPal, is(equalTo("Pay with PayPal")));
    }
}
