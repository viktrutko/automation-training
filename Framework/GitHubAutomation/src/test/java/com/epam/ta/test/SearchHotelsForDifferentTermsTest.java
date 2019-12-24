package com.epam.ta.test;

import com.epam.ta.model.Hotel;
import com.epam.ta.page.HotelsHomePage;
import com.epam.ta.service.HotelCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class SearchHotelsForDifferentTermsTest extends CommonConditions {


    @Test
    public void searchHotelForLongStay(){
        Hotel testSearchQueryMain = HotelCreator.forLongStay();
        String textOfButtonToSubmitFormForLongStay = new HotelsHomePage(driver)
                .openPage()
                .defineMainTermsForSearchHotel(testSearchQueryMain)
                .obtainFormToSearchHotelForLongStay()
                .thereIsSubmitButton();
        assertThat(textOfButtonToSubmitFormForLongStay, is(equalTo("Отправить")));
    }

    @Test
    public void searchHotelWithNonexistentPlace(){
        Hotel testSearchQueryMain = HotelCreator.withNonexistentPlace();
        String textOfMessageAboutNonexistentPlace = new HotelsHomePage(driver)
                .openPage()
                .defineMainTermsForSearchHotel(testSearchQueryMain)
                .getTextOfMessageAboutNonexistentPlace();
        assertThat(textOfMessageAboutNonexistentPlace, is(equalTo("К сожалению, нам не удалось найти QQQ")));
    }

    @Test
    public void searchHotelWithYesterdayDate(){
        Hotel testSearchQueryMain = HotelCreator.withYesterdayDate();
        String textOfMessageAboutErrorsWithDate = new HotelsHomePage(driver)
                .openPage()
                .defineMainTermsForSearchHotel(testSearchQueryMain)
                .getTextOfMessageAboutErrorsWithDate();
        assertThat(textOfMessageAboutErrorsWithDate, is(equalTo("Указана дата заезда раньше сегодняшнего дня")));
    }

    @Test
    public void searchHotelWithoutDepartureDate(){
        Hotel testSearchQueryMain = HotelCreator.withoutDepartureDate();
        String textOfMessageAboutErrorsWithDate = new HotelsHomePage(driver)
                .openPage()
                .defineMainTermsForSearchHotel(testSearchQueryMain)
                .getTextOfMessageAboutErrorsWithDate();
        assertThat(textOfMessageAboutErrorsWithDate, is(equalTo("Укажите дату выезда")));
    }


    @Test
    public void searchHotelWithFreeBreakfast(){
        Hotel testSearchQueryMain = HotelCreator.withCredentialsFromProperty();
        String textOfFreeBreakfastMark = new HotelsHomePage(driver)
                .openPage()
                .searchHotelForMainTerms(testSearchQueryMain)
                .selectFreeBreakfastHotelTerm()
                .selectHotelWithFreeBreakfastFromSearchResults()
                .getTextOfFreeBreakfastMark();
        Assert.assertTrue(textOfFreeBreakfastMark.contains("Бесплатный завтрак"));
    }
    @Test
    public void searchHotelWithoutArrivalAndDepartureDate(){
        Hotel testSearchQueryMain = HotelCreator.withoutArrivalAndDepartureDate();
        String textOfNoteToInputDates = new HotelsHomePage(driver)
                .openPage()
                .searchHotelForMainTerms(testSearchQueryMain)
                .getTextOfNotesToInputDates();
        assertThat(textOfNoteToInputDates, is(equalTo("Введите даты")));
    }
    @Test
    public void searchHotelForGroup(){
        Hotel testSearchQueryMain = HotelCreator.forGroup();
        String textOfButtonToSubmitFormForGroup = new HotelsHomePage(driver)
                .openPage()
                .searchHotelForGroup(testSearchQueryMain)
                .thereIsSubmitButton();
        assertThat(textOfButtonToSubmitFormForGroup, is(equalTo("Отправить")));
    }

}
